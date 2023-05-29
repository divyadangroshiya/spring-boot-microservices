package com.java.springboot.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.entity.Address;
import com.java.springboot.repository.AddressRepository;
import com.java.springboot.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AddressResponse getAddressByEmployeeId(int id) {
		
		Address address = addressRepo.findAddressByEmployeeId(id);
		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
		return addressResponse;
		
	}

}
