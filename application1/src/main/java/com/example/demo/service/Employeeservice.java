package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.Employeedto;
import com.example.demo.entities.Employee;

@Component
public interface Employeeservice {

	public Employee createEmployee(Employeedto ed);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployees();
	public String deleteEmployee(int id);
	public String updateEmployee(int id,Employeedto st);
	public String deleteAllEmployees();
	
}
