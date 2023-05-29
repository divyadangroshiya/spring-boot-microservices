package com.java.springboot.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.java.springboot.entity.Employee;
import com.java.springboot.repository.EmployeeRepo;
import com.java.springboot.response.AddressResponse;
import com.java.springboot.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
//	@Value("${addressservice.base.url}")
//	private String addressBaseUrl;
	
//	public EmployeeService(@Value("${addressservice.base.url}") String addressBaseUrl, RestTemplateBuilder builder) {
//		System.out.println("uri: "+addressBaseUrl);
//		this.restTemplate = builder
//							.rootUri(addressBaseUrl)
//							.build();
//	}



	public EmployeeResponse getEmployeeById(int id) {
		
		Employee employee = employeeRepo.findById(id).get();
		EmployeeResponse employeeRespo = modelMapper.map(employee, EmployeeResponse.class);
		AddressResponse addressResponse = callToAddressServiceUsingRestTemplate(id);
		//AddressResponse addressResponse = callToAddressServiceUsingWebClient(id);
		employeeRespo.setAddressResponse(addressResponse);
		
		return employeeRespo;
	}



	private AddressResponse callToAddressServiceUsingRestTemplate(int id) {
		
//		List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
//		ServiceInstance serviceInstance = instances.get(0);
		
//		ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
//		
//		String uri = serviceInstance.getUri().toString();
//		String configPath = serviceInstance.getMetadata().get("configPath");
//		
//		System.out.println("uri >>>>>>>>>>>>>>>>>>>>" + uri + configPath);
//		
//		return restTemplate.getForObject(uri + configPath + "/address/{id}", AddressResponse.class, id);
		
		return restTemplate.getForObject("http://address-service/address-app/api/address/{id}", AddressResponse.class, id);
	}

	private AddressResponse callToAddressServiceUsingWebClient(int id) {
		return webClient
				.get()
				.uri("/address/"+id)
				.retrieve()
				.bodyToMono(AddressResponse.class)
				.block();
	}

}
