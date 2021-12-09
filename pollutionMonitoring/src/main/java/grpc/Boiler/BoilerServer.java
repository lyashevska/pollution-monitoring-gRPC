package grpc.Boiler;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author patrick
 * 
 */
public class BoilerServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(4141)
                .addService(new BoilerServiceImpl()).build();

        server.start();
        System.out.println("Server created for Boiler Service: Listening on port 4141");
        server.awaitTermination();
    }
}
