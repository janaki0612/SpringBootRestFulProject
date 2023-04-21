package com.project.springbootapp.service;

import java.util.List;

import com.project.springbootapp.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeebyID(long id);
	
	Employee updateEmployee(Employee employee,long id);
	
	void deleteEmployee(long id);
	
}
