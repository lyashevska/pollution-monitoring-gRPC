package grpc.medicalWaste;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author olga
 *
 */
public class MedicalWasteClient {

	public static void main(String[] args) throws InterruptedException {

		ServiceInfo serviceInfo;
		String service_type = "_waste._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		// build a channel

		ManagedChannel newChannel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		// build a message 

		// input validation 
		String input = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter tag id to retrieve: ");
		
		if(sc.hasNext()) {
			input = sc.next();
		}
		
		containsBagId cString = containsBagId.newBuilder().setTagRequest(input).build();
		
		// create a stub
		// the stub is specific to the service
		medicalWasteServiceBlockingStub bstub = medicalWasteServiceGrpc.newBlockingStub(newChannel);
		
		containsBagId response = bstub.getBagId(cString);
		
		System.out.println("Tag requested from server: "+ response.getTagResponse());

		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
