package grpc.Boiler;

import grpc.Boiler.BoilerServiceGrpc;
import grpc.Boiler.BoilerRequest;
import grpc.Boiler.BoilerResponse;
import io.grpc.stub.StreamObserver;

/**
 * @author patrick
 * 
 */
public class BoilerServiceImpl extends BoilerServiceGrpc.BoilerServiceImplBase {
	
	@Override
	public StreamObserver<BoilerRequest> sendBoilerRequest(StreamObserver<BoilerResponse> responseObserver) {
		return new StreamObserver<BoilerRequest>() {

			@Override
			public void onNext(BoilerRequest boilerRequest) {
				System.out.println("new request sended with emission gas " + boilerRequest.getEmissionGases());
			}

			@Override
			public void onCompleted() {
				responseObserver.onNext(BoilerResponse.newBuilder().setIsSafe(true).build());
				responseObserver.onCompleted();
			}

			// handle onError() ...
			@Override
			public void onError(Throwable throwable) {
				System.out.println("Got Error : " + throwable.getMessage().toString());
			}

		};
	}
}
