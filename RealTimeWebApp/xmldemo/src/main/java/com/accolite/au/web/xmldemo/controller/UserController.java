package com.accolite.au.web.xmldemo.controller;

import com.accolite.au.web.xmldemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.accolite.au.web.xmldemo.models.User;
import com.accolite.au.web.xmldemo.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value="api")
public class UserController {
	
	@Autowired
	private UserDAO userService;
	
	@GetMapping(value="user/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public User getUserbyName(@PathVariable int id)
	{
		return userService.getUser(id);
	}
	
	@PostMapping(value="sguser",produces=MediaType.APPLICATION_XML_VALUE,consumes=MediaType.APPLICATION_XML_VALUE)
	public User setandGetUser(@RequestBody User user)
	{
		return userService.setandGetUserservice(user);
	}

	@PostMapping(value="adduser",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user)
	{
		userService.addUserService(user);
	}

	@GetMapping(value="all",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getallUser() { return userService.getUsers(); }

	@PostMapping(value="edit/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public void editUser(@PathVariable int id){
		userService.editUserService(id);
	}
}
