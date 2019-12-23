package com.example.demo;

import com.example.demo.service.MyClientEndPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

/**
 * @author duanqichao
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException, DeploymentException {
		SpringApplication.run(DemoApplication.class, args);
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		String uri = "ws://localhost:8080/test/websocket";
		container.connectToServer(MyClientEndPoint.class, URI.create(uri));

	}

}
