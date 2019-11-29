<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">

		<thead>
			<tr>
				<th>accountNumber</th>
				<th>balance</th>
				<th>customer</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
			   <tr>
				<td>${account.accountNumber }</td>
				<td>${account.balance }</td>
				<td>${account.customer}</td>
			   </tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="addaccount">add new account</a><br/>
	<a href="transfer">fund transfer</a><br/>
	<a href="deposit">deposit fund</a><br/>
	<a href="withdraw">withdraw fund</a><br/>
	
	
	
<%-- <c:forEach items="${accounts}" var="account">
	<c:out value="${account.accountNumber }"></c:out> |
	<c:out value="${account.balance }"></c:out>	<br/>
</c:forEach> --%>
</body>
</html>