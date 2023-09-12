<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../default/header.jsp" %>
The Login Page
${msg }
<form action="loginDo" method="post">
	<input type="text" id="id" name="id" placeholder="id"><br>
	<input type="password" id="pw" name="pw" placeholder="password">
	<input type="submit" value="login">
	<br>
	<input type="checkbox" name="autoLogin">AutoLogin
</form><br>
<a href="register">Register</a>


<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>