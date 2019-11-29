<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADDITION USER</title>
<style type="text/css">
	.errors{
		color:red;
		font-family: Calibri;
		font-style: italic;
	}
</style>
</head>
</br>
<center>
<body>
	<form:form action="adduser" method="post" modelAttribute="customer">
		<form:hidden path="id"/>
		Enter name: <form:input path="name"/><form:errors path="name" class="errors"/><br/>
		Enter password: <form:input path="password"/><form:errors path="password" class="errors"/><br/>
		Enter email: <form:input path="email"/><form:errors path="email" class="errors"/><br/>
		Enter phone: <form:input path="phone"/><form:errors path="phone" class="errors"/><br/>
		Enter address: <form:input path="address"/><form:errors path="address" class="errors"/><br/>
		Enter roles: <form:input path="roles"/><form:errors path="roles" class="errors"/><br/>
		Enter active: <form:input path="active"/><form:errors path="active" class="errors"/><br/>

		<input type="submit"/>
	</form:form>
</center>
</body>
</html>