<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login From</title>
</head>
<body>
<font color="red">${message}</font>
	<form action="login"  ><!-- method = "post" -->

		<h2 style="text-align:center">Enter Login Details</h2>
		<table width="100%">
			<tr>
				<td>User Name</td>
				<td><input type="text" size="25" name="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" size="25" name="password"/></td>
			</tr>
		</table></br>
		<input type="submit" value="login">
		
		New User? <a href="Registration.jsp">click here</a></br>

	</form>
	<a href="goToHomePage">Click Here</a> For Home Page
</body>
</html>