package com.accolite.web.service;

import org.springframework.stereotype.Service;

import com.accolite.web.models.Employee;

import java.util.*;
//import javax.annotation.PostConstruct;

@Service
public class EmployeeService {

	
	List<Employee> employees;
	
	EmployeeService()
	{
		employees = new ArrayList<Employee>();
		Employee e = new Employee();
		e.setId(1);
		e.setName("pruthvi");
		e.setSalary(20000);
		employees.add(e);
	}
	public Employee getEmployee(int id) {
//		return employees.stream().filter( employee -> employee.getId() == id).findFirst().get();
		Employee e = new Employee();
		e.setId(1);
		e.setName("pruthvi");
		e.setSalary(20000);
		return e;
	}
	
	public List<Employee> getAllEmployees() {
		return employees;
	}
}
