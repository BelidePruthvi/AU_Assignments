package com.accolite.au.resteasy.app;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import com.accolite.au.services.MenuServiceImpl;


public class MenuApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MenuApplication() {
		singletons.add(new MenuServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}


}