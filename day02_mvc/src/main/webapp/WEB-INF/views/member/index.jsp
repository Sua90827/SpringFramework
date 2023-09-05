<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="a" value="/root/"/>
<body>
	<h1> index main page </h1>
	<a href="${a }login"> move to login page</a> <br>
	<a href="${a }logout">move to logout page</a>
</body>
</html>