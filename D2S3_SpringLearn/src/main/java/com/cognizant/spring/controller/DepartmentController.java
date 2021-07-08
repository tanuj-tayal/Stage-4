package com.cognizant.spring.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import com.cognizant.spring.model.Department;
import com.cognizant.spring.service.DepartmentService;

@Slf4j
@RestController
public class DepartmentController
{
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments()
	{
		log.info("Inside getAllDepartments");
		log.debug("Departments : {}",departmentService.getAllDepartments());
		return departmentService.getAllDepartments();
	}
}
