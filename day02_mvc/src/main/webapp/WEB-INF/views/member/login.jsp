<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>${abc }
<form action="login.do" method="post">
	ID : <input type="text" id="id" name="id">
	PW : <input type="password" id="pwd" name="pwd">
	<input type="submit" value="login">	
</form>
<c:set var="a" value="/root/"/>
<a href="${a }logout">move to logout page</a>
<a href="${a }index">move to index page</a>
</body>
</html>