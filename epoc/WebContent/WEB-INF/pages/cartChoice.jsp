<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Choice Menu</title>
</head>
<body>
	<c:if test="${not empty message}">
		<c:out value="${message}"></c:out>
	</c:if>
	<a href="./order">Add more products</a>
	<a href="./checkout">Continue to Checkout</a>
</body>
</html>