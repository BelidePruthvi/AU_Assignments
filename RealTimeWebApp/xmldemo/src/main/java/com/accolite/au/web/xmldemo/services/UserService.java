package com.accolite.au.web.xmldemo.services;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestParam;

import com.accolite.au.web.xmldemo.models.User;

import java.util.List;

public interface UserService {

	User getUser(String name);

	User setandGetUserservice(User user);

	void setUp();

	void addUserService(User user);

	List<User> getUsers();

}