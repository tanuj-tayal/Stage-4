package com.cognizant.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring.model.Employee;
import com.cognizant.spring.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees()
	{
		log.info("Inside getAllEmployees");
		log.debug("Employees : {}",employeeService.getAllEmployees());
		return employeeService.getAllEmployees();
	}
}
