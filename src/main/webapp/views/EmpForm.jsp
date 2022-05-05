<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!--   <link rel="stylesheet" th:href="@{webjars/bootstrap/4.2.1/css/bootstrap.min.css}"/> -->
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}"/>
    <link rel="stylesheet" th:href="@{/css/main.css}"/>
</head>
<body>
<h2>Employee Entry Form</h2>
	
	<form action="insert" method="post">
		<table>
<!-- 		<tr> -->
<!-- 			<td>Eml Id:</td> -->
<!-- 			<td><input type="text" name="pid"></td> -->
<!-- 		</tr> -->
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstName"></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastName"></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td><input type="reset" name="Reset"></td>
			<td><input type="submit" name="Submit"></td>
		</tr>
		</table>
	
	</form>
</body>
</html>