<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name=request.getParameter("name");
		String password=request.getParameter("password");		
	%>
	<h2>
		Submitted Details Successfully!
	</h2>
	<b>Name:</b> <%=name %>
	<b>Password</b> <%=password %>
</body>
</html>