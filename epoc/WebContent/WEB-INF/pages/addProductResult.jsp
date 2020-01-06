<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty productname}">
			Product <c:out value="${productname}"></c:out> added successfully!
		</c:when>
		<c:otherwise>
			<c:out value="${message}"></c:out>
		</c:otherwise>
	</c:choose>
	<a href="./goToMain">Main</a>
</body>
</html>