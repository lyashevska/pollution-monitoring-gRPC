package gui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
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

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Request bag id");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("", 10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke service 1");
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

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value");
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

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Request sample id");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("", 10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke service 3");
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

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value");
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

		JFrame frame = new JFrame("Pollution Monitoring");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

		panel.add(getService1JPanel());
		panel.add(getService2JPanel());
		panel.add(getService3JPanel());
		panel.add(getService4JPanel());

		// Set size for the frame
		frame.setSize(400, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String label = button.getActionCommand();

		if (label.equals("Invoke service 1")) {
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
			
			reply1.setText(String.valueOf(response.getTagResponse()));

		} else if (label.equals("Invoke Service 2")) {
			System.out.println("service 2 to be invoked ...");

			// insert here
			
		} else if (label.equals("Invoke service 3")) {

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
			
			try {
				requestObserver.onNext(SampleRequest.newBuilder().setId(entry3.getText()).build());

				// Mark the end of requests
				requestObserver.onCompleted();
				
				// retrieving reply from server
				// HERE
			    reply3.setText("Awaiting for response");

				// Sleep for a bit before sending the next one.
				Thread.sleep(new Random().nextInt(1000) + 500);


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
			System.out.println("service 4 to be invoked ...");
			// insert here
		} else {
		}

	}

}
