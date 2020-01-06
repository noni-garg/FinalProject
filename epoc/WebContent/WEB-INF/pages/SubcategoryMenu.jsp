<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SubCategory Selection</title>
</head>
<body>
	
	<h1>Category : <%=session.getAttribute("categoryName")%></h1><br/>
	<h2>SubCategory</h2>
	<ul>
		<c:forEach var="subcategory" items="${subcategoryList}">
			<li><c:out value="${subcategory}"/></li>
		</c:forEach>
	</ul>
	<form action="./findproduct">
		<select name="subcategoryName">
			<c:forEach var="subcategory" items="${subcategoryList}">
				<option>${subcategory}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>