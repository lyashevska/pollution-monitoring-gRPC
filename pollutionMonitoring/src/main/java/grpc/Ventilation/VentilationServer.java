package grpc.Ventilation;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import grpc.medicalWaste.SimpleServiceRegistration;

/**
 * @author patrick
 * server streaming api
 * jmdns integration
 *
 */
public class VentilationServer {

    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	int port = 50052;
		String service_type = "_ventilation._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
    	    	
    	
    	
    	Server server = ServerBuilder
                .forPort(port)
                .addService(new VentilationServiceImpl()).build();

        server.start();
        System.out.println("Server created for Ventilation Service: Listening on port: "+ port);
        server.awaitTermination();
    }

}
