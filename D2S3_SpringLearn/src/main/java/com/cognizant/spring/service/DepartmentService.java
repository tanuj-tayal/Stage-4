package com.cognizant.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.spring.model.Department;
import com.cognizant.spring.dao.DepartmentDao;

@Service
public class DepartmentService
{
	@SuppressWarnings("static-access")
	public ArrayList<Department> getAllDepartments()
	{
		return new DepartmentDao().getAllDepartments();
	}
}
