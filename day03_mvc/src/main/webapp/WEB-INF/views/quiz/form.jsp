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
<form action="login.do" method="post">
	<input type="text" name="id" placeholder="id"><br>
	<input type="password" name="pwd" placeholder="password"><br>
	<input type="submit" value="login"><br>
</form>
<%
    String userId = (String) session.getAttribute("userId");
%>

<a href="quiz/register">register</a><br>
<c:if test="${not empty userId}">
<a href="quiz/list">every member's info</a>
</c:if>
</body>
</html>