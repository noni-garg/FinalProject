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
<title>Checkout Screen</title>
</head>
<body>
	<%
	List<Cart> cartList = (List<Cart>)request.getAttribute("cartList");
	float total=0;
	for(Cart cart:cartList){
		total=total+(cart.getProduct().getPrice())*(cart.getQuantity());
		session.setAttribute("totalAmount",total);
	}
	%>
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
	
	Total Amount:<%=total%>
	
	<form action="./currency">
		<input type="radio" name="currency" value="USD">USD
		<input type="radio" name="currency" value="INR">INR
		<input type="submit" value="submit">
	</form>
</body>
</html>