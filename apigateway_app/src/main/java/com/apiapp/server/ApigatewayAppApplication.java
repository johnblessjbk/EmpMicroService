package com.apiapp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayAppApplication.class, args);
	}

}
