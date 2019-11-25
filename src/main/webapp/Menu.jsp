<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function editItem(itemid) {

		alert('edit triggered!! for ' + itemid);

	}

	function deleteItem(itemid) {

		alert('delete button triggered ' + itemid);
		document.forms[0].action = "${pageContext.request.contextPath}/deleteItem?itemid=" + itemid; //itemid is a RequestParam, we access itemid by using this name.
		document.forms[0].method = "post";
		document.forms[0].submit();

	}
</script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>MenuPage</title>
</head>
<body>
<font color = "red">${message}</font>
	<form action=""></form>
	<table border="1">
		<tr>
			<th>ItemId</th>
			<th>Item</th>
			<th>Price</th>
			<th>Veg/NonVeg</th>
			<th>Qty</th>
		</tr>

		<c:forEach var="item" items="${menuData}">

			<tr>
				<!--${itemInfo.itemid}</td>  -->
				<td>${item.itemid}</td>
				<td>${item.item}</td>
				<td>${item.price}</td>
				<td>${item.typeofitem }</td>
				<td>${item.qty}</td>
				<td><input type="button" onclick="editItem('${item.itemid}')"
					value="Edit" /></td>
				<td><input type="button" onclick="deleteItem('${item.itemid}')"
					value="Delete" /></td>
			</tr>

		</c:forEach>
	</table>
	</form>
	<a href="goToHomePage">Click Here</a> For Home Page
</body>
</html>