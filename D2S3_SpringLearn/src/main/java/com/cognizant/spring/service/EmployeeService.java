package com.cognizant.spring.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.cognizant.spring.model.Employee;
import com.cognizant.spring.dao.EmployeeDao;

@Service
public class EmployeeService
{
	@SuppressWarnings("static-access")
	public ArrayList<Employee> getAllEmployees()
	{
		return new EmployeeDao().getAllEmployees();
	}
}
