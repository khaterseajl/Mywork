package com.example.demo.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Employeedto;
import com.example.demo.entities.Employee;
import com.example.demo.repositorys.EmployeeRepo;
import com.example.demo.service.Employeeservice;

@Service
public class Employeeimpl implements Employeeservice{

	@Autowired
	EmployeeRepo er;

	@Override
	public Employee createEmployee(Employeedto ed) {
		Employee e=Employee.builder()
				.eid(ed.getEid())
				.ename(ed.getEname())
				.edept(ed.getEdept())
				.esal(ed.getEsalary())
				.build();
		return er.save(e);
	}

	@Override
	public Employee getEmployee(int id) {
		return er.findById(id).get();
	
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return er.findAll();
	}

	@Override
	public String deleteEmployee(int id) {
		er.deleteById(id);
		return "record deleted successfully";
	}

	@Override
	public String updateEmployee(int id, Employeedto st) {
          er.findById(id).get();
          Employee e=Employee.builder().
        		  eid(st.getEid())
  				.ename(st.getEname())
  				.edept(st.getEdept())
  				.esal(st.getEsalary())
  				.build();
  		er.save(e);
  		return "recird updated successfully";
	}

	@Override
	public String deleteAllEmployees() {
		er.deleteAll();
		return "all records deleted successfully";
	}
	
}	


