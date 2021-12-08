package grpc.medicalWaste;

import java.io.IOException;
import java.lang.System.Logger;

import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author olga
 * unary api
 * server for a medical waste service
 * runs on port 50051 and uses jmdns for registration 
 * 
 */

public class MedicalWasteServer extends medicalWasteServiceImplBase {
	
	// private static final Logger logger = Logger.getLogger(MedicalWasteServer.class.getName());

	public static void main(String[] args) {

		MedicalWasteServer service1 = new MedicalWasteServer();
		
		int port = 50051;
		String service_type = "_waste._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		

	try {
		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();
		
		System.out.println("Server started, listening on " + port);
		server.awaitTermination();
	} catch(Exception e) {
		System.out.println(e);
	}
}
		
		@Override
		public void getBagId(containsBagId request, StreamObserver<containsBagId> responseObserver) {
			
			// find out what was sent by the client
			String tagRequest = request.getTagRequest();
			System.out.println("Tag requested is " + tagRequest);

			// now build our response
			containsBagId.Builder response = containsBagId.newBuilder();

			response.setTagResponse("Information about " + tagRequest + " retrieved");
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();


	}

}
