<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="servlets.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean Deneme</title>
</head>
<body>
	<jsp:useBean id="user" class="servlets.User" scope="request">
		
	</jsp:useBean>
	<jsp:getProperty property="name" name="user"/>
	<jsp:getProperty property="surname" name="user"/>
</body>
</html>