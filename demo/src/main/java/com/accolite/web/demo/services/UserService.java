package com.accolite.web.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accolite.web.demo.models.User;

@Component
public class UserService {
	
	List<User> users;
	
	public User getUser(@RequestParam String name)
	{
		return users.stream().filter(user->user.getName().equals(name)).findFirst().get();
	}
	
	@PostConstruct
	public void setUp()
	{
		users=new ArrayList<User>();
		User u=new User();
		u.setAge(21);
		u.setName("pruthvi");
		u.setId(1);
		users.add(u);
	}
}
