package com.example.server;

import com.example.server.server.PingPongServiceImpl;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ServerApplication.class, args);
		Server server = ServerBuilder
			.forPort(9090)
			.addService((BindableService) new PingPongServiceImpl())
			.build();

		System.out.println("start server ...");
		server.start();
		server.awaitTermination();
	}

}
