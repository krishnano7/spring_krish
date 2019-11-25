<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<form action="addItemPage" ><!-- methot = "post" -->

		<h2 style="text-align:center">Home Page!!</h2>
		<table width="50%">
			<tr><td>Click this button to Add NewItem</td></br>
				<td><input type="submit" size="25" value="Add Items"/></td></br>
			</tr>
			</table>
</form>
			
<form action="showMenu" ><!-- methot = "post" -->

		<table width="50%">
			<tr>
				<td>Click this button to Show Menu</td>
				<td><input type="submit" size="25" value="Show Menu"/></td>
			</tr>
		</table>
</form>
<a href="goToHomePage">Click Here</a> For Home Page
</body>
</html>