package com.java.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.repository.AddressRepository;
import com.java.springboot.response.AddressResponse;
import com.java.springboot.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/{employeeId}")
   	ResponseEntity<AddressResponse> getAddressByEmployeeeId(@PathVariable("employeeId") int id) {
		
		AddressResponse addressResponse = addressService.getAddressByEmployeeId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
   		
   	}

}
