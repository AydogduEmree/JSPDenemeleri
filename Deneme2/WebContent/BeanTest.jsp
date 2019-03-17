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
	<%
		User user1 = (User)request.getAttribute("user");
	if(user1.getName() == null){
		user1.setName("Ali");
	}
	%>

	<jsp:useBean id="user" class="servlets.User" scope="request">
		<jsp:setProperty property="name" name="user" value="Ali"/>
	</jsp:useBean>
	<jsp:getProperty property="name" name="user"/>
	<jsp:getProperty property="surname" name="user"/>
</body>
</html>