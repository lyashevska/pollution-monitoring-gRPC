package grpc.Ventilation;

import grpc.Ventilation.VentilationRequest;
import grpc.Ventilation.VentilationResponse;
import grpc.Ventilation.VentilationServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class VentilationServiceImpl extends VentilationServiceGrpc.VentilationServiceImplBase {



    @Override
    public void sendVentilationRequest(VentilationRequest request, StreamObserver<VentilationResponse> responseObserver) {

        for (int i = 1; i <= 5; i++) {
            VentilationResponse stockQuote = VentilationResponse.newBuilder()
                    .setRoomId(""+i)
                    .setTemp(request.getTemp())
                    .setDate(new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH).format(new Date()))
                    .setTimeSampling(new SimpleDateFormat("HH:mm:ss Z", Locale.ENGLISH).format(new Date()))
                    .build();
            responseObserver.onNext(stockQuote);
        }
        responseObserver.onCompleted();
    }
}
