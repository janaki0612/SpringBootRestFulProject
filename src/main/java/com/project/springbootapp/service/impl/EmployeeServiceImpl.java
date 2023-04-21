package com.project.springbootapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springbootapp.exception.ResourceNotFoundException;
import com.project.springbootapp.model.Employee;
import com.project.springbootapp.repository.EmployeeRepository;
import com.project.springbootapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}



	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}



	
	@Override
	public Employee getEmployeebyID(long id) {
		
//		Optional<Employee> employee =  employeeRepository.findById(id);
//		
//		if(employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new ResourceNotFoundException("Employee","ID",id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",id));
		
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		Employee existingemployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",id));
		
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		existingemployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingemployee);
		return existingemployee;
		
	
		
		
	}



	@Override
	public void deleteEmployee(long id) {
		
		// check whether it exists in DB or not and then delete
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",id));
		employeeRepository.deleteById(id);
		
	}

}
