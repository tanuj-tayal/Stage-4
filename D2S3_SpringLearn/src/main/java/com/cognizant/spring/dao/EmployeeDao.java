package com.cognizant.spring.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.model.Employee;

public class EmployeeDao
{
	private static ArrayList<Employee> EMPLOYEE_LIST;
	
	@SuppressWarnings({ "unchecked", "static-access" } )
	public EmployeeDao()
	{
		super();
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		this.setEMPLOYEE_LIST((ArrayList<Employee>)context.getBean("employeeList"));
	}
	public static ArrayList<Employee> getAllEmployees()
	{
		return EMPLOYEE_LIST;
	}

	public static void setEMPLOYEE_LIST(ArrayList<Employee> eMPLOYEE_LIST)
	{
		EMPLOYEE_LIST = eMPLOYEE_LIST;
	}
}
