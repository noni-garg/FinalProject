<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css">
	<style type="text/css">
	td{
		text-align: center;
	}
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
		<spring:form action="./editProductResult" style="border:1px solid #ccc" method="post" modelAttribute="tempProduct">
 			 <div class="container">
   			 	 <h1>Update Product details</h1>
    			 <p>Please retype the fields to be updated.</p>
  				 <hr>
    			 <label for="productname"><b>Product Name</b></label>
    	  	 	 <spring:input type="text" id="ProductName" placeholder="Enter Product Name" name="ProductName" path="productName" required="required"/>

    			 <label for="category"><b>Category</b></label>
    			 <spring:input type="text" id="Category" placeholder="Enter Category" name="category" path="category" required="required"/>
    			 
    			 <label for="subcategory"><b>Subcategory</b></label>
    	  	 	 <spring:input type="text" id="Subcategory" placeholder="Enter Subcategory" name="subcategory" path="subCategory" required="required"/>

    			 <label for="Price"><b>Price</b></label>
    			 <spring:input type="number" id="price" placeholder="Enter Price" name="price" path="price" required="required"/>
    				
    			 <label for="stock"><b>Enter Stock</b></label>
    			 <spring:input type="number" id="stock" placeholder="Enter Stock" name="stock" path="productStock" required="required"/>
    			 
   		 		 <div class="clearfix">
    			   <a class="cancelbtn" href="">Cancel</a>
      			   <button type="submit" class="signupbtn">Accept</button>
    			 </div>
  			 </div>
		</spring:form>
		</div>
	</div>
</body>
<script type="text/javascript">
	document.getElementById("ProductName").value="${product.productName}";
	document.getElementById("Category").value="${product.category}";
	document.getElementById("Subcategory").value="${product.subCategory}";
	document.getElementById("price").value="${product.price}";
	document.getElementById("stock").value="${product.productStock}";
</script>
</html>