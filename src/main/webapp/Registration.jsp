<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>

<font size="3" color="red">${message}</font>
<form action="Registration" method = "post">

		<h2 style="text-align:center">Fill Registration Form</h2>
		<table width="100%">
			<tr>
				<td>Name</td>
				<td><input type="text" size="25" name="name"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" size="25" name="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" size="25" name="password"/></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" size="25" name="mobile"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" size="25" name="city"/></td>
			</tr>
		</table></br>
		<input type="submit" value="Resister">
		
		Already have a account? <a href="Login.jsp">Login here</a>

	</form>

</body>
</html>