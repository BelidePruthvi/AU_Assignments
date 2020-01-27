package com.accolite.web;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.accolite.web.controller.EmployeeController;
import com.accolite.web.models.Employee;
import com.accolite.web.service.EmployeeService;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestApplication {
	
	@InjectMocks
	EmployeeController empController;

	@Mock
	EmployeeService service;
	
	Logger logger=Logger.getLogger(TestApplication.class);
	
	@Before
	public void setup() {
		this.service=Mockito.mock(EmployeeService.class);
	}
	
	
	@Test
	public void getEmployeeTest()
	{
		Employee emp=new Employee();
		emp.setId(1);
		emp.setName("pruthvi");
		emp.setSalary(20000);
		
		when(service.getEmployee(1)).thenReturn(emp);

		Employee checkemp=service.getEmployee(1);
		
		assertEquals(emp.getId(),checkemp.getId());
		assertEquals(emp.getName(),checkemp.getName());
		assertEquals(emp.getSalary(),checkemp.getSalary());
		
		logger.info("getemployeetest");
	}
	
	@Test
	public void getAllEmployee() {

		List<Employee> emps=new ArrayList<Employee>();
		Employee emp=new Employee();
		emp.setId(1);
		emp.setName("pruthvi");
		emp.setSalary(20000);
		emps.add(emp);
		List<Employee> result=new ArrayList<Employee>();
		when(service.getAllEmployees()).thenReturn(emps);

		result = service.getAllEmployees();
		
		assertEquals(emps.getClass(),result.getClass());
		
		logger.info("getallemployeetest");
	}
}
