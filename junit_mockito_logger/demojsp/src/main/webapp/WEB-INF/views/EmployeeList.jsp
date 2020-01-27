<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList"%>      
<%@page import="com.accolite.web.models.Employee"%>
<%@page import="java.util.Iterator"%> 
 
<% ArrayList<Employee> users= (ArrayList) request.getAttribute("employees"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>
 
<h1>Users List</h1>
<br></br>
 
<table border="2" width="50%" cellpadding="2">  
 
<tr><th>ID</th><th>Age</th><th>Name</th></tr>
<%
 
if(request.getAttribute("employees") != null)  
{
	

 Iterator<Employee> iterator = users.iterator(); 
 
 while(iterator.hasNext())  
 {
 Employee user= iterator.next(); 
 %>

 <tr><td><%=user.getId()%></td>
 <td><%=user.getName()%></td>
 <td><%=user.getSalary()%></td>
 </tr>
 <%
 }
}
%>
</table>