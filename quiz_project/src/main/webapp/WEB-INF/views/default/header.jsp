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
	<header>
	<a href="index"><h2>CARE LAB</h2></a>
	<hr>
	<a href="index">HOME</a>
	<a href="board">BOARD</a>
	<c:if test="${ empty sessionScope.user_id }">
		<a href="login">LOGIN</a>
		<a href="login">MEMBER INFO</a>
	</c:if>
	<c:if test="${ not empty sessionScope.user_id }">
		<a href="logout">LOGOUT</a>
		<a href="memberInfo">MEMBER INFO</a>
	
	</c:if>
	<hr>
	</header>
</body>
</html>