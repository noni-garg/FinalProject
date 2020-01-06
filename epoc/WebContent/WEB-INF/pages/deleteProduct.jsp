<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
	<h1>Category : <%=session.getAttribute("categoryName")%></h1><br/>
	<h1>SubCategory : <%=session.getAttribute("subcategoryName")%></h1><br/>
	<h2>Products</h2>
	<ul>
		<c:forEach var="product" items="${productList}">
			<li><c:out value="${product.productId}"/><c:out value="  "/>
			<c:out value="${product.productName}"/></li>
		</c:forEach>
	</ul>
	<form action="./deleteProductResult">
		<select name="productId">
			<c:forEach var="product" items="${productList}">
				<option>${product.productId}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>