package com.accolite.au.web.xmldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.web.xmldemo.models.User;
import com.accolite.au.web.xmldemo.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="user/{name}",produces=MediaType.APPLICATION_XML_VALUE)
	public User getUserbyName(@PathVariable String name)
	{
		return userService.getUser(name);
	}
	
	@PostMapping(value="sguser",produces=MediaType.APPLICATION_XML_VALUE,consumes=MediaType.APPLICATION_XML_VALUE)
	public User setandGetUser(@RequestBody User user)
	{
		return userService.setandGetUserservice(user);
	}
}
