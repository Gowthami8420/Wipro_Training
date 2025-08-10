<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: lightblue; font-family: Arial;">
	<h2>Login form</h2>
	<form action="page.jsp" method="post">
	<label for="t1">Name</label>
	<input type="text" name="name" id="t1">
	<br><br>
	<label for="t2">Password</label>
	<input type="password" name="password" id="t2">
	<br><br>
	<input type="submit" value="submit">
	<input type="reset" value="Reset">
	</form>
</body>
</html>