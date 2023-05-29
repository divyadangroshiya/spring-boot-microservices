package com.java.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmployeeAddresssDiscoveryServiceMicroservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAddresssDiscoveryServiceMicroservice3Application.class, args);
	}

}
