<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>all app users</h5>
<table border="1">

		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>password</th>
				<th>email</th>
				<th>phone</th>
				<th>address</th>
				<th>roles</th>
				<th>active?</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
			   <tr>
				<td>${user.id }</td>
				<td>${user.password }</td>
				<td>${user.name }</td>
				<td>${user.email}</td>
				<td>${user.phone}</td>
				<td>${user.address}</td>
				<td>
				<c:forEach var="temp" items="${user.roles}">
        			<c:out value="${temp}"></c:out>
    			</c:forEach>
				</td>
				
				<td>${user.valid}</td>
			   </tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="adduser">add new app user</a><br/>

</body>
</html>