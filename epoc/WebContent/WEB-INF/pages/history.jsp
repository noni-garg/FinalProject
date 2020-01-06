<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
</head>
<body>
	<h2>Order History</h2>
	<table>
		<tr>
			<td>Order ID</td>
			<td>Product Name</td>
			<td>Product Price</td>
			<td>Product Quantity</td>
		</tr>
		<c:forEach var="order" items="${orderHistory}">
			<tr>
				<td><c:out value="${order.orderId}"></c:out></td>
				<c:forEach var="cart" items="${order.cartList}">
				 	<td><c:out value="${cart.product.productName}"></c:out></td>
					<td><c:out value="${cart.product.price}"></c:out></td>
					<td><c:out value="${cart.quantity}"></c:out></td> 
					</tr><tr><td></td>
				</c:forEach>
			</tr>
			<tr>
				<td>Total Amount : <c:out value="${order.total}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>