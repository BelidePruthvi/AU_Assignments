package com.accolite.web.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.accolite.web.demo.models.User;
import com.accolite.web.demo.services.UserService;

@RestController
public class SecondController {

		List<User> users;
		
		@Autowired
		private UserService userService;
		
		@GetMapping("users/{name}")
		public User getUserbyName(@PathVariable String name)
		{
			return userService.getUser(name);
		}
		
		
//		@GetMapping("users")
//		public User getUserbyName(@RequestParam String name)
//		{
//			return users.stream().filter(user->user.getName().equals(name)).findFirst().get();
//		}
		
//		SecondController()
//		{
//			users=new ArrayList<User>();
//			User u=new User();
//			u.setAge(19);
//			u.setName("pruthvi");
//			u.setId(1);
//			users.add(u);
//		}
}
