package grpc.Boiler;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import javax.swing.*;

import grpc.medicalWaste.SimpleServiceDiscovery;

import java.net.InetAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author patrick
 * client streaming api
 */
public class BoilerClient {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch finishLatch = new CountDownLatch(1);
		
		// jmdns discovery
		ServiceInfo serviceInfo;
		String service_type = "_boiler._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		String[] emissionGases = { "co2", "nox", "sox" };
		
		JFrame f;
		f = new JFrame();

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		BoilerServiceGrpc.BoilerServiceStub stub = BoilerServiceGrpc.newStub(channel);

		int a = JOptionPane.showConfirmDialog(f,
				"Welcome to Hospital Boiler Emissions Monitoring\n\nDo you want to check Safety");
		if (a != JOptionPane.YES_OPTION) {
			return;
		}

		StreamObserver<BoilerResponse> responseObserver = new StreamObserver<BoilerResponse>() {
			@Override
			public void onNext(BoilerResponse summary) {
				if (summary.getIsSafe()) {
					JOptionPane.showMessageDialog(f, "RESPONSE = Emission Gases are {" + emissionGases[0] + ", "
							+ emissionGases[1] + ", " + emissionGases[2] + "} and Alarm Level is safe");
				} else {
					JOptionPane.showMessageDialog(f, "RESPONSE = Emission Gases are {" + emissionGases[0] + ", "
							+ emissionGases[1] + ", " + emissionGases[2] + "} and Alarm Level is not safe");
				}

				System.out.println("Response = " + summary);
			}

			@Override
			public void onCompleted() {
				System.out.println("Server completed the given task");
			}

			// Override OnError ...
			@Override
			public void onError(Throwable throwable) {
				System.out.println("Got Error : " + throwable.getMessage().toString());
			}
		};

		StreamObserver<BoilerRequest> requestObserver = stub.sendBoilerRequest(responseObserver);
		try {

			BoilerRequest req = BoilerRequest.newBuilder().build();

			BoilerRequest[] BoilerRequests = new BoilerRequest[3];
			BoilerRequests[0] = BoilerRequest.newBuilder().setEmissionGases("co2").build();
			BoilerRequests[1] = BoilerRequest.newBuilder().setEmissionGases("nox").build();
			BoilerRequests[2] = BoilerRequest.newBuilder().setEmissionGases("sox").build();

			for (BoilerRequest bolierRequest : BoilerRequests) {
				requestObserver.onNext(bolierRequest);
			}
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			System.out.println("Got Error : " + e.toString());

			throw e;
		}
		requestObserver.onCompleted();
		finishLatch.await(1, TimeUnit.MINUTES);

	}
}