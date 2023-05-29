package com.java.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeAddresssMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAddresssMicroservice1Application.class, args);
	}

}
