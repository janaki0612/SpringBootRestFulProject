package com.project.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springbootapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	

}
