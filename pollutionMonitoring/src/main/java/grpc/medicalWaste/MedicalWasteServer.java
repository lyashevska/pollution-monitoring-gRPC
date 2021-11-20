package grpc.medicalWaste;

import java.io.IOException;

import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author olga
 *
 */
public class MedicalWasteServer {

	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {

		final MedicalWasteServer ourServer = new MedicalWasteServer();
		ourServer.start();
	}

	private void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();

	}

	// Extend abstract base class for our implementation
	static class NewServerImpl extends medicalWasteServiceImplBase {
		@Override
		public void getBagId(containsBagId request, StreamObserver<containsBagId> responseObserver) {
			// find out what was sent by the client
			String tagRequest = request.getTagRequest();
			System.out.println("Tag requested is " + tagRequest);

			// now build our response
			containsBagId.Builder response = containsBagId.newBuilder();

			response.setTagResponse("Our first response string: " + tagRequest);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			

		}

	}

}
