package com.accolite.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.accolite.web.service.EmployeeService;
import com.accolite.web.models.Employee;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	
	
	@RequestMapping(value="/hi")
	public @ResponseBody String sayHi()
	{
		return "hi";
	}
	
	
	@RequestMapping("employee/{id}")
	public ModelAndView getEmployee(@PathVariable int id) { 
		ModelAndView model = new ModelAndView("EmployeeList");
		model.addObject("employees",es.getEmployee(id));
		return model;
	}
	
	@RequestMapping("/employee")
	public ModelAndView getAllEmployees() {
		ModelAndView model = new ModelAndView("EmployeeList");
		model.addObject("employees",es.getAllEmployees());
		return model;
	}
	
	@RequestMapping(value="/add")
	public ModelAndView addEmployeeForm() {
		ModelAndView model = new ModelAndView("AddEmployee");
		return model;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam int id,@RequestParam String name, @RequestParam int salary) {
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		es.getAllEmployees().add(e);
		ModelAndView model = new ModelAndView("EmployeeList");
		model.addObject("employees",es.getAllEmployees());
		System.out.println(es.getAllEmployees().size());
		return model;
	}
	
	
}
