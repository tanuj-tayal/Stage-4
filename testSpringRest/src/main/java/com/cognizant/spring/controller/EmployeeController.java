package com.cognizant.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring.model.Employee;
import com.cognizant.spring.service.EmployeeServiceI;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController
{
	@Autowired
	EmployeeServiceI employeeService;
	
	@PostMapping(value="/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee)
	{
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee added Successfully",HttpStatus.OK);
	}
}
