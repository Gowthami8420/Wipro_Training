<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Result</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");

    if (name != null && password != null && name.equals("admin") && password.equals("wipro")) {
%>
        <h2>Login Successfully</h2>
        <b>Name:</b> <%= name %> <br>
        <b>Password:</b> <%= password %>
<%
    } else {
        response.sendRedirect("error.jsp");
    }
%>
</body>
</html>
