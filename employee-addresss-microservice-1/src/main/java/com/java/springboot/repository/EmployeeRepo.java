package com.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.springboot.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
