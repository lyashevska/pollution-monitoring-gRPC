package grpc.Ventilation;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author patrick
 * server streaming api
 *
 */
public class VentilationServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new VentilationServiceImpl()).build();

        server.start();
        System.out.println("Server created for Ventilation Service: Listening on port 8080");
        server.awaitTermination();
    }

}
