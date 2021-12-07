package grpc.waterQuality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author olga client for bidirectional streaming api use jmdns for discovery
 * 
 */
public class WaterQualityClient {

	public static void main(String[] args) throws InterruptedException {

		// jmdns
		ServiceInfo serviceInfo;
		String service_type = "_water._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";

		// build a channel
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		doBiDiStreamingCall(channel);

		System.out.println("Shutting down channel");
		channel.shutdown();
	}

	private static void doBiDiStreamingCall(ManagedChannel channel) {
		// create an asynchronous client
		waterSampleServiceGrpc.waterSampleServiceStub asyncClient = waterSampleServiceGrpc.newStub(channel);

		CountDownLatch latch = new CountDownLatch(1);

		StreamObserver<SampleRequest> requestObserver = asyncClient.createSample(new StreamObserver<SampleResponse>() {

			@Override
			public void onNext(SampleResponse value) {
				System.out.println("Response from server: " + value.getSampleId());
			}

			@Override
			public void onError(Throwable t) {
				// to make sure latch disappears
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("Server is done sending data");
				latch.countDown();
			}
		});

		// generate a few requests
		// send 3 messages to the server using lambda function
		// we expect 3 messages back
		// onNext called many times

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sample id to retrieve: ");

// 		sample id is validated using regex
//		[ : beginning of character group
//		  a-z : any lowercase letter
//		  A-Z : any uppercase letter
//		  0-9 : any digit
//		  ] : end of character group
//		
		String sampleId = "";
		boolean valid = false;
		List<String> sampleList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			do {
				System.out.println("Enter sample id: ");
				if (sc.hasNext("[a-zA-Z0-9]+")) {
					sampleId = sc.nextLine();
					valid = true;
				} else {
					sc.nextLine();
					System.out.println("Please enter a valid sample id");
				}

			} while (!valid);
			sampleList.add(sampleId);
		}

		sampleList.forEach(id -> {
			System.out.println("Sending: " + id);
			requestObserver.onNext(SampleRequest.newBuilder().setId(id).build());
		});

		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		// done sending request
		requestObserver.onCompleted();

		// wait 3 sec
		try {
			latch.await(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
