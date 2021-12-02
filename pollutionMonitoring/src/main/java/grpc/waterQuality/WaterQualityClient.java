package grpc.waterQuality;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class WaterQualityClient {

	public static void main(String[] args) throws InterruptedException {

		ServiceInfo serviceInfo;
		String service_type = "_grpc._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";

		// build a channel

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		System.out.println("Shutting down channel");
		// channel.shutdown();

		doBiDiStreamingCall(channel);
	}

	private static void doBiDiStreamingCall(ManagedChannel channel) {
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

		// send 3 messages to the server
		Arrays.asList("sample1", "sample2", "sample3").forEach(
				id -> {
			System.out.println("Sending: " + id);
			requestObserver.onNext(SampleRequest.newBuilder()
					.setId(id)
					.build());
		});
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		requestObserver.onCompleted();

		try {
			latch.await(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
