package grpc.medicalWaste;

import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MedicalWasteClient {

	public static void main(String[] args) throws InterruptedException {

		ServiceInfo serviceInfo;
		String service_type = "_grpc._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		// build a channel

		ManagedChannel newChannel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		// build a message 
		containsBagId cString = containsBagId.newBuilder().setTagRequest("12345").build();
		
		// create a stub
		// the stub is specific to the service
		medicalWasteServiceBlockingStub bstub = medicalWasteServiceGrpc.newBlockingStub(newChannel);
		
		containsBagId response = bstub.getBagId(cString);
		
		System.out.println("Tag requested from server: "+ response.getTagResponse());

		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
