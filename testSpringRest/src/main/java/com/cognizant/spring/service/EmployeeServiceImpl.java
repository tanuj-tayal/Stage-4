package com.cognizant.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring.dao.EmployeeDao;
import com.cognizant.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI
{
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee addEmployee(Employee employee)
	{
		return employeeDao.save(employee);
	}
}
