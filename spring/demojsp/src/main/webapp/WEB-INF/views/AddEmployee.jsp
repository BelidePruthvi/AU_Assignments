<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<h1>Add Employee</h1>
<form method = "POST" action="#" th:action="@{/add}">
	<input type="number" placeholder="Enter Employee Id" name="id" /> <br/>
	<input type="text" placeholder="Enter Employee Name" name="name"/> <br/>
	<input type="number" placeholder="Enter Employee Salary" name="salary"/> <br/>
	<input type="submit" />
</form>
</body>
</body>
</html>