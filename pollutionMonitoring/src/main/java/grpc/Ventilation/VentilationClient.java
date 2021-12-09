package grpc.Ventilation;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import javax.jmdns.ServiceInfo;
import javax.swing.*;

import grpc.medicalWaste.SimpleServiceDiscovery;

import java.util.Iterator;

/**
 * @author patrick
 * 
 *
 */
public class VentilationClient {

	public static void main(String[] args) throws InterruptedException {
		
		// jmdns discovery
		ServiceInfo serviceInfo = null;
		String service_type = "_ventilation._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		JFrame f;
		f = new JFrame();
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		VentilationServiceGrpc.VentilationServiceBlockingStub stub = VentilationServiceGrpc.newBlockingStub(channel);

		int a = JOptionPane.showConfirmDialog(f,
				"Welcome to Ventilation Service\n\nDo you want to send request to Ventilation Server");
		if (a != JOptionPane.YES_OPTION) {
			return;
		}

		VentilationRequest request = VentilationRequest.newBuilder().setAir(true).setLoc("Milli").setTemp("29").build();
		Iterator<VentilationResponse> ventilationResponseIterator;
		try {
			ventilationResponseIterator = stub.sendVentilationRequest(request);
			for (int i = 1; ventilationResponseIterator.hasNext(); i++) {
				VentilationResponse result = ventilationResponseIterator.next();
				JOptionPane.showMessageDialog(f, "RESPONSE # " + i + " : " + result);

				System.out.println("RESPONSE # " + i + " : " + result);
			}
		} catch (StatusRuntimeException e) {
			// logInfo("RPC failed: {0}", e.getStatus());
			System.out.println("RPC failed: {0} " + e.getStatus());
		}

	}

}
