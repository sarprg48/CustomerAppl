<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>sav prod details</h2>
	
	<form action="saveProduct" method="post">
		<table><tr>
			<td>P Id:</td>
			<td><input type="text" name="pid"></td>
		</tr>
		<tr>
			<td>P name:</td>
			<td><input type="text" name="pname"></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price"></td>
		</tr>
		<tr>
			<td><input type="reset" name="Reset"></td>
			<td><input type="submit" name="Submit"></td>
		</tr>
		</table>
	
	</form>
</body>
</html>