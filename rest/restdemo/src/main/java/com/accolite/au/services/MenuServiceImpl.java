package com.accolite.au.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.accolite.au.models.GenericResponse;
import com.accolite.au.models.Menu;
import com.accolite.au.models.MenuItem;
import com.accolite.au.services.MenuService;


@Path("/menu")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuServiceImpl implements MenuService{

	private static Map<Integer,Menu> menus = new HashMap<Integer,Menu>();
	
	@POST
	@Path("/add")
	public Response addMenu(Menu menu) {
		// TODO Auto-generated method stub
		GenericResponse res=new GenericResponse();
		if(menus.get(menu.getId()) != null){
			res.setStatus(false);
			res.setMessage("Menu Exists");
			res.setErrorCode("M-01");
			return Response.status(422).entity(res).build();
		}
		menus.put(menu.getId(), menu);
		res.setStatus(true);
		res.setMessage("Menu Created ");
		return Response.ok(res).build();
	}
	
	@POST
	@Path("/add/{id}")
	public Response addMenuItem(@PathParam("id") int mid,MenuItem item) {
		// TODO Auto-generated method stub
		GenericResponse res = new GenericResponse();
		if(menus.get(mid) == null){
			res.setStatus(false);
			res.setMessage("Menu Doesn't Exists");
			res.setErrorCode("M-02");
			return Response.status(404).entity(res).build();
		}
		Menu menu = menus.get(mid);
		if(menu.getItems().get(item.getId()) != null){
			res.setStatus(false);
			res.setMessage("Item already Exists in the menu");
			res.setErrorCode("I-01");
			return Response.status(422).entity(res).build();
		}
		menu.addItem(item.getId(), item);
		menus.put(menu.getId(), menu);
		res.setStatus(true);
		res.setMessage("Item added successfully");
		return Response.ok(res).build();
	}

	
	
	@DELETE
    @Path("/delete/{id}")
	public Response deleteMenu(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if(menus.get(id) == null){
			response.setStatus(false);
			response.setMessage("Menu Doesn't Exists");
			response.setErrorCode("M-02");
			return Response.status(404).entity(response).build();
		}
		menus.remove(id);
		response.setStatus(true);
		response.setMessage("Menu deleted successfully");
		return Response.ok(response).build();
	}

	@DELETE
    @Path("/delete/{id}/{itemid}")
	public Response deleteItem(@PathParam("id") int id, @PathParam("itemid") int itemid) {
		GenericResponse response = new GenericResponse();
		if(menus.get(id) == null){
			response.setStatus(false);
			response.setMessage("Menu Doesn't Exists");
			response.setErrorCode("M-02");
			return Response.status(404).entity(response).build();
		}
		Menu menu = menus.get(id);
		if(menu.getItem(itemid) == null) {
			response.setStatus(false);
			response.setMessage("Item Doesn't Exists");
			response.setErrorCode("L-01"); 
			return Response.status(404).entity(response).build();
		}
		menu.removeItem(itemid);
		menus.put(menu.getId(),menu);
		response.setStatus(true);
		response.setMessage("menu Item Deleted");
		return Response.ok(response).build();
	}
	
	@GET
	@Path("/{id}")
	public Menu getMenu(@PathParam("id") int id) {
		if(menus.get(id) == null){
			return new Menu();
		}
		return menus.get(id);
	}



}
