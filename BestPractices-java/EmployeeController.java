package com.accolite.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.accolite.web.service.EmployeeService;
import com.accolite.web.models.Employee;

/* Usage of comments example*/

/* Controller class which dispatches the request to the service Employee Service */
@Controller
public class EmployeeController {

	/* Service to get,add Employee */
	@Autowired
	private EmployeeService es;
	
	
	/**
	 * This method returns a "hi" response.
	 */
	@RequestMapping(value="/hi")
	public @ResponseBody String sayHi()
	{
		return "hi";
	}

	/**
	 * This method is intended to get the details of an employee.
	 * Note that there is only one employee with a particular id.
	 * This makes use of a Service EmployeeService to get the details.
	 * @pathvariable id to get the details of that particular employee.
	 * @return This method returns a ModelAndView type - a jsp page containing the requested employee
	 */


	@RequestMapping("employee/{id}")
	public ModelAndView getEmployee(@PathVariable int id) { 
		ModelAndView model = new ModelAndView("EmployeeList");
		model.addObject("employees",es.getEmployee(id));
		return model;
	}


	/**
	 * This method is intended to get the details of all the  employees.
	 * This makes use of a Service EmployeeService to get the details.
	 * @return This method returns a ModelAndView type - a jsp page containing all the employees.
	 */
	@RequestMapping("/employee")
	public ModelAndView getAllEmployees() {
		ModelAndView model = new ModelAndView("EmployeeList");
		model.addObject("employees",es.getAllEmployees());
		return model;
	}

	/**
	 *This method is intended to add a employee
	 * @return It is returns a jsp page containing the add user component.
	 */
	@RequestMapping(value="/add")
	public ModelAndView addEmployeeForm() {
		ModelAndView model = new ModelAndView("AddEmployee");
		return model;
	}

	/**
	 * This method is intended to add the employee to existing users.
	 * This method is invoked when the user clicks submit on add user jsp page.
	 * @param id -- employee id submitted by the form.
	 * @param name -- employee name submitted by the form.
	 * @param salary -- employee salary submitted by the form.
	 * @return It returns the list of employees jsp page
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam int id,@RequestParam String name, @RequestParam int salary) {
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		es.getAllEmployees().add(e);
		ModelAndView model = new ModelAndView("EmployeeList");
		model.addObject("employees",es.getAllEmployees());
		return model;
	}
	
	
}
