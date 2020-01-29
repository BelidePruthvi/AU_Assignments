package com.accolite.au.web.xmldemo.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.accolite.au.web.xmldemo.models.User;

@Service
public class UserServiceImpl implements UserService {
		
	List<User> users;
	
	/* (non-Javadoc)
	 * @see com.accolite.au.web.xmldemo.services.UserService#getUser(java.lang.String)
	 */
	@Override
	public User getUser(@RequestParam String name)
	{
		return new User();
//		return users.stream().filter(user->user.getName().equals(name)).findFirst().get();
	}
	
	/* (non-Javadoc)
	 * @see com.accolite.au.web.xmldemo.services.UserService#setandGetUserservice(com.accolite.au.web.xmldemo.models.User)
	 */
	@Override
	public User setandGetUserservice(User user)
	{
		return user;
	}

	@Override
	public void addUserService(User user) {
		users.add(user);
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	/* (non-Javadoc)
	 * @see com.accolite.au.web.xmldemo.services.UserService#setUp()
	 */
	@Override
	@PostConstruct
	public void setUp()
	{
//		users=new ArrayList<User>();
//		User u=new User();
//		u.setAge(21);
//		u.setName("pruthvi");
//		u.setId(1);
//		users.add(u);
//		User u1=new User();
//		u1.setAge(20);
//		u1.setId(2);
//		u1.setName("test");
//		users.add(u1);
	}
}
