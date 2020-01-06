<%@page import="java.util.ArrayList"%>
<%@page import="com.sunlife.epoc.entity.Cart"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
</head>
<body>
	<table>
		<tr>
			<td>Product Name</td>
			<td>Product Price</td>
			<td>Quantity</td>
			<td>Total</td>
		</tr>
			<c:forEach var="cart" items="${cartList}">
				<tr>
					<td><c:out value="${cart.product.productName}"/></td>
					<td><c:out value="${cart.product.price}"/></td>
					<td><c:out value="${cart.quantity}"/></td>
					<td><c:out value="${cart.product.price*cart.quantity}"/></td>
				</tr>
			</c:forEach>
	</table>
	<br/>
	Total Amount : <c:out value="${totalAmount}"></c:out><c:out value="${currency}"></c:out><br/>
	Entered Amount : <c:out value="${customerAmount}"><c:out value="${currency}"></c:out></c:out><br/>
	Balance Amount : <c:out value="${balance}"><c:out value="${currency}"></c:out></c:out>
	
</body>
</html>