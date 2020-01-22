package com.accolite.web.servlet;

import java.io.IOException;

import javax.servlet.http.*;

import com.accolite.web.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		try {
			response.getWriter().write("This response is from the servlet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper=new ObjectMapper();
		User user=new User();
		user.setAge(20);
		user.setId(1);
		user.setName("pruthvi");
		try {
			String str=mapper.writeValueAsString(user);
			response.getWriter().write(str);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		
	}
}
