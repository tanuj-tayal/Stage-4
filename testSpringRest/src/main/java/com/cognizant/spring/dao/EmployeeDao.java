package com.cognizant.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.spring.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>
{

}
