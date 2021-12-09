package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import grpc.Boiler.BoilerRequest;
import grpc.Boiler.BoilerResponse;
import grpc.Boiler.BoilerServiceGrpc;
import grpc.Ventilation.VentilationRequest;
import grpc.Ventilation.VentilationResponse;
import grpc.Ventilation.VentilationServiceGrpc;
import grpc.medicalWaste.*;
import grpc.medicalWaste.SimpleServiceDiscovery;
import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceBlockingStub;
import grpc.waterQuality.*;

import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.jmdns.ServiceInfo;

/**
 * @author olga gui implementation 4 services with jmdns integration
 * 
 */
public class App implements ActionListener {

	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;
	private JTextField entry4, reply4;

	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		// create an instance of a label
		JLabel label = new JLabel("Request waste bag id");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("", 10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1.setEditable(false);
		panel.add(reply1);
		panel.setLayout(boxlayout);
		return panel;

	}

	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("Request air temperature");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("", 10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 2");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2.setEditable(false);
		panel.add(reply2);
		panel.setLayout(boxlayout);
		return panel;

	}

	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("Request water sample id");
		panel.add(label);

		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("", 10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 3");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 10);
		reply3.setEditable(false);
		panel.add(reply3);
		panel.setLayout(boxlayout);
		return panel;

	}

	private JPanel getService4JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("Request emission gasses check");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry4 = new JTextField("", 10);
		panel.add(entry4);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 4");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply4 = new JTextField("", 10);
		reply4.setEditable(false);
		panel.add(reply4);
		panel.setLayout(boxlayout);
		return panel;

	}

	public static void main(String[] args) {
		App gui = new App();
		gui.build();
	}

	private void build() {

		// create an instance of frame
		JFrame frame = new JFrame("Pollution Monitoring");

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

		panel.add(getService1JPanel());
		panel.add(getService2JPanel());
		panel.add(getService3JPanel());
		panel.add(getService4JPanel());

		// Set size for the frame
		frame.setSize(420, 420);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();

		// make frame visible
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String label = button.getActionCommand();

		if (label.equals("Invoke Service 1")) {
			System.out.println("Medical Waste Service to be invoked ...");

			// jmdns
			ServiceInfo serviceInfo = null;
			String service_type = "_waste._tcp.local.";
			try {
				serviceInfo = SimpleServiceDiscovery.run(service_type);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			int port = serviceInfo.getPort();
			String host = "localhost";

			// build a channel
			ManagedChannel channel1 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
			medicalWasteServiceBlockingStub bstub = medicalWasteServiceGrpc.newBlockingStub(channel1);

			// preparing message to send
			grpc.medicalWaste.containsBagId request = grpc.medicalWaste.containsBagId.newBuilder()
					.setTagRequest(entry1.getText()).build();

			// retrieving reply from server
			grpc.medicalWaste.containsBagId response = bstub.getBagId(request);

			reply1.setText("RESPONSE: "+String.valueOf(response.getTagResponse()));

		} else if (label.equals("Invoke Service 2")) {
			System.out.println("Ventilation service to be invoked ...");

			ServiceInfo serviceInfo = null;
			String service_type = "_ventilation._tcp.local.";

			try {
				serviceInfo = SimpleServiceDiscovery.run(service_type);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			int port = serviceInfo.getPort();
			String host = "localhost";

			ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
			VentilationServiceGrpc.VentilationServiceBlockingStub stub = VentilationServiceGrpc
					.newBlockingStub(channel);

			VentilationRequest request = VentilationRequest.newBuilder().setTemp(entry2.getText()).build();
			Iterator<VentilationResponse> ventilationResponseIterator;

			try {
				ventilationResponseIterator = stub.sendVentilationRequest(request);
				
				// only last response is returned in gui
				for (int i = 1; ventilationResponseIterator.hasNext(); i++) {
					VentilationResponse result = ventilationResponseIterator.next();
					reply2.setText("RESPONSE # " + i + ": " + result);
				}
			} catch (StatusRuntimeException e1) {
				// logInfo("RPC failed: {0}", e.getStatus());
				System.out.println("RPC failed: {0} " + e1.getStatus());
			}

		} else if (label.equals("Invoke Service 3")) {

			System.out.println("Water Quality Service to be invoked ...");

			// jmdns
			ServiceInfo serviceInfo = null;
			String service_type = "_water._tcp.local.";
			try {
				serviceInfo = SimpleServiceDiscovery.run(service_type);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			int port = serviceInfo.getPort();
			String host = "localhost";

			// build channel
			ManagedChannel channel3 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

			waterSampleServiceGrpc.waterSampleServiceStub asyncClient = waterSampleServiceGrpc.newStub(channel3);

			CountDownLatch latch = new CountDownLatch(1);

			StreamObserver<SampleRequest> requestObserver = asyncClient
					.createSample(new StreamObserver<SampleResponse>() {

						@Override
						public void onNext(SampleResponse value) {
							reply3.setText("RESPONSE: "+value.getSampleId());
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

			String sampleId1 = entry3.getText();

			// a list of one element
			try {
				Arrays.asList(sampleId1).forEach(id -> {
					System.out.println("Sending: " + id);
					// reply3.setText();
					requestObserver.onNext(SampleRequest.newBuilder().setId(id).build());
				});

				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				// done sending request
				requestObserver.onCompleted();

				// Sleep for a bit before sending the next one.
				Thread.sleep(new Random().nextInt(100) + 500);

			} catch (RuntimeException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		} else if (label.equals("Invoke Service 4")) {
			System.out.println("Boiler safety check to be invoked ...");

			// jmdns discovery
			ServiceInfo serviceInfo = null;
			String service_type = "_boiler._tcp.local.";

			try {
				serviceInfo = SimpleServiceDiscovery.run(service_type);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int port = serviceInfo.getPort();
			String host = "localhost";

			ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

			BoilerServiceGrpc.BoilerServiceStub stub = BoilerServiceGrpc.newStub(channel);

			StreamObserver<BoilerResponse> responseObserver = new StreamObserver<BoilerResponse>() {

				@Override
				public void onNext(BoilerResponse summary) {
					if (summary.getIsSafe()) {
						reply4.setText("RESPONSE: Alarm Level is safe");
					} else {
						reply4.setText("RESPONSE: Alarm Level is not safe");
					}

					System.out.println("Response = " + summary);
				}

				@Override
				public void onCompleted() {
					System.out.println("Server completed the given task");
				}

				@Override
				public void onError(Throwable throwable) {
					System.out.println("Got Error : " + throwable.getMessage().toString());
				}
			};

			StreamObserver<BoilerRequest> requestObserver = stub.sendBoilerRequest(responseObserver);
			try {

				BoilerRequest req = BoilerRequest.newBuilder().build();

				BoilerRequest[] BoilerRequests = new BoilerRequest[3];
				BoilerRequests[0] = BoilerRequest.newBuilder().setEmissionGases(entry4.getText()).build();

				for (BoilerRequest bolierRequest : BoilerRequests) {
					requestObserver.onNext(bolierRequest);
				}
			} catch (RuntimeException e1) {
				requestObserver.onError(e1);
				System.out.println("Got Error : " + e1.toString());

				throw e1;
			}
			requestObserver.onCompleted();

		} else {
		}

	}

}
