package com.hmis.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsermicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermicroServiceApplication.class, args);
	}

}
