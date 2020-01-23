package com.accolite.au.services;

import javax.ws.rs.core.Response;

import com.accolite.au.models.Menu;
import com.accolite.au.models.MenuItem;

public interface MenuService {
	
	public Response addMenu(Menu list);
	public Response addMenuItem(int mid,MenuItem item);
	public Response deleteMenu(int id);
	public Response deleteItem(int menuid,int itemid);
	public Menu getMenu(int id);
	
}
