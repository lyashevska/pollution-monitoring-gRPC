package grpc.waterQuality;

import java.io.IOException;
import java.lang.System.Logger;

import grpc.medicalWaste.SimpleServiceRegistration;
import grpc.medicalWaste.medicalWasteServiceGrpc.medicalWasteServiceImplBase;
import grpc.waterQuality.waterSampleServiceGrpc.waterSampleServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author olga bidirectional streaming api server for a water quality service
 *         runs on port 50053 and uses jmdns for registration
 */

public class WaterQualityServer extends waterSampleServiceImplBase {

	//private static final Logger logger = Logger.getLogger(MedicalWasteServer.class.getName());

	public static void main(String[] args) {
		WaterQualityServer service3 = new WaterQualityServer();

		int port = 50053;
		String service_type = "_water._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);

		try {
			Server server = ServerBuilder.forPort(port).addService(service3).build().start();

			System.out.println("Server started, listening on " + port);
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public StreamObserver<SampleRequest> createSample(StreamObserver<SampleResponse> responseObserver) {
			
		   StreamObserver<SampleRequest> requestObserver = new StreamObserver<SampleRequest>() {

			@Override
			// every time sample request is received 
			public void onNext(SampleRequest value) {
				
				String result = "Sample id is: " + value.getId();
				
				// response
				SampleResponse sampleResponse = SampleResponse.newBuilder().setSampleId(result).build();
				
				// send message back to response observer
				responseObserver.onNext(sampleResponse);
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
		return requestObserver;
	}

}
