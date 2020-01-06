<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h1>Welcome <c:out value="${name}"></c:out></h1>
	<h3>Please Choose Your Category</h3>
	<ul>
		<li><a href="./add">Add New product</a></li>
		<li><a href="./edit/edit">Edit product</a></li>
		<li><a href="./del/delete">Delete product</a></li>
		<li><a href="./order">Order</a></li>
		<li><a href="./history">Order History</a></li>
	</ul>
</body>
</html>