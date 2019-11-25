<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function editItem(){
	
	alert( "edit button triggered")
}

function deleteItem(){
	
	alert(itemInfo.itemid + "delete button triggered")
	
}

</script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>MenuPage</title>
</head>
<body>
<form action="editUser"></form>
	<table border="1">
		<tr>
			<th>ItemId</th>
			<th>Item</th>
			<th>Price</th>
			<th>Veg/NonVeg</th>
			<th>Qty</th>
		</tr>

	<c:forEach items="${menuData}" var="item">

		<tr>
		<!--${itemInfo.itemid}</td>  -->
		<td>${itemInfo.itemid}</td>
		<td>${itemInfo.item}</td>
		<td>${itemInfo.price}</td>
		<td>${itemInfo.typeofitem }</td>
		<td>${itemInfo.qty}</td>
		<td><input type="button" onclick="editItem('${itemInfo.itemid}')" value="Edit"></td>
		<td><input type="button" onclick="deleteItem('${itemInfo.itemid}')" value="Delete"></td>
		</tr>

	</c:forEach>
	</table>
</form>
<a href="goToHomePage">Click Here</a> For Home Page
</body>
</html>