<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Selection</title>
</head>
<body>
	<h2>Category</h2>
	<ul>
		<c:forEach var="category" items="${categoryList}">
			<li><c:out value="${category}"/></li>
		</c:forEach>
	</ul>
	<form action="./subcategory">
		<select name="categoryName">
			<c:forEach var="category" items="${categoryList}">
				<option>${category}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>