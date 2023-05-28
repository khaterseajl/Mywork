package com.example.demo.controller1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employeedto;
import com.example.demo.entities.Employee;
import com.example.demo.exception.UserNotFoundexception;
import com.example.demo.service.Employeeservice;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	Employeeservice es;
	
	@PostMapping("/employee")
	public  ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employeedto st)
	{	  	
		 Employee e=es.createEmployee(st);
		if(e!=null)
			return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
		
	   return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id)
	{
		try {
		Employee s=es.getEmployee(id);
		if(s!=null)
			return new ResponseEntity<Employee>(s, HttpStatus.OK);
		}catch(Exception e)
		{		
	       throw new UserNotFoundexception("user not found");
		}
		 return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/Employees")
	public ResponseEntity<List<Employee>> getEmployees()
	{
		try {
			List<Employee> slist=es.getAllEmployees();
			if(slist!=null)
				return new ResponseEntity<List<Employee>>(slist, HttpStatus.OK);
			}catch(Exception e)
			{		
		       e.printStackTrace();
			}
			 return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id,@RequestBody Employeedto st)
	{
		try
		{
			String s=es.updateEmployee(id, st);
			if(s!=null)
				return new ResponseEntity<String>(s,HttpStatus.CREATED);
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity <String>deleteEmployee(@PathVariable int id)
	{
		try
		{
		String s=es.deleteEmployee(id);
		if(s!=null)
			return new ResponseEntity<String>(s,HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	
}
