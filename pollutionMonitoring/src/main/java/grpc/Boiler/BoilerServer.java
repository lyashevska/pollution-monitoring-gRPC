package grpc.Boiler;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import grpc.medicalWaste.SimpleServiceRegistration;

/**
 * @author patrick
 * jmdns registration
 */
public class BoilerServer {

    public static void main(String[] args) throws IOException, InterruptedException {
    	
		int port = 50054;
		String service_type = "_boiler._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
    	    	
    	
        Server server = ServerBuilder
                .forPort(port)
                .addService(new BoilerServiceImpl()).build();

        server.start();
        System.out.println("Server created for Boiler Service: Listening on port: " + port);
        server.awaitTermination();
    }
}
