<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css">
	<style>
	.button_logout{
    -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;
    text-decoration:none;
    font-size:22px;
    padding:8px;
    position:absolute;
    top:25px;
    right:80px;
    color:teal;
    }
	</style>
</head>
<body>
	<span class='welcome'>${message}</span>
	<span><a href="goToindex.html" class="button_logout">Logout</a></span>
	<hr/>
	<div class="containerclass clearfix">
		<div class="left_disp left">
		<!--<ul>
			<li>Links</li>
			<li class="blink"><a href="fillup.html">Add Employee</a></li>
			<li><a href="display.html">View Employees</a></li>
			<li><a href="edit.html">Edit Employee</a></li>
		</ul> -->
		</div>
		<div class="right_disp left">
		<spring:form action="./addresult" style="border:1px solid #ccc" method="post" modelAttribute="product">
 			 <div class="container">
   			 	<h1>Add New Product</h1>
    			 <p>Please fill every field in this form to make a product.</p>
  				 <hr>
    			 <label for="productname"><b>Product Name</b></label>
    	  	 	 <spring:input type="text" placeholder="Enter Product Name" name="ProductName" path="productName" required="required"/>

    			 <label for="category"><b>Category</b></label>
    			 <spring:input type="text" placeholder="Enter Category" name="category" path="category" required="required"/>
    			 
    			 <label for="subcategory"><b>Subcategory</b></label>
    	  	 	 <spring:input type="text" placeholder="Enter Subcategory" name="subcategory" path="subCategory" required="required"/>

    			 <label for="Price"><b>Price</b></label>
    			 <spring:input type="number" placeholder="Enter Price" name="price" path="price" required="required"/>
    
    			 <label for="stock"><b>Enter Stock</b></label>
    			 <spring:input type="number" placeholder="Enter Stock" name="stock" path="productStock" required="required"/>
    			 
   		 		 <div class="clearfix">
    			   <a class="cancelbtn" href="">Cancel</a>
      			   <button type="submit" class="signupbtn">Accept</button>
    			 </div>
  			 </div>
		</spring:form>
		</div>
	</div>
</body>
</html>