<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update_Items</title>
</head>
<body>
	<font color="green">${message}</font>
	<form action="updateItem" method="post">

		Item Id : <input type="text" name="itemid" value="${itemInfo.itemid}" /></br>

		Item:<input type="text" name="item" value="${ itemInfo.item}"></br>
		Price:<input type="text" name="price" value="${ itemInfo.price}"></br>
		Quantity:<input type="text" name="qty" value="${ itemInfo.qty}"></br>
		Veg:<input type="radio" name="typeofitem" checked="${veg }"
			value="Veg"></br> Non-Veg:<input type="radio" name="typeofitem"
			checked="${nonVeg }" value="Non-Veg"></br> <input type="submit"
			name="Update" value="Update"></br>


	</form>
	<a href="goToHomePage">Click Here</a> For Home Page
</body>
</html>