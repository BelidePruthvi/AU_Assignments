package com.accolite.web.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import com.accolite.web.models.User;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	private List<User> users;
	
	
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public @ResponseBody String sayHi() {
		return "Hello first controller";
	}
	
	@RequestMapping(value="/bye")
	public @ResponseBody String sayBye() {
		return "Bye first controller";
	}
	
	@RequestMapping(value="/user")
	public @ResponseBody User getUser() {
		User user=new User();
		user.setAge(20);
		user.setId(1);
		user.setName("pruthvi");
		return user;
	}
	
	@RequestMapping(value="/anotheruser",method=RequestMethod.POST)
	public @ResponseBody User getandSendUser(@RequestBody User user) {
		return user;
	}
	
//	@RequestMapping(value="/induser")
//	public @ResponseBody User getUserbyId(@RequestParam int id) {
//		return users.stream().filter(user->user.getId()==id).findFirst().get();
//	}

	@RequestMapping(value="/employee")
	public String getEmployeePage() {
		return "EmployeeList";
	}
}
