<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>This is the logout page. Are you sure you want to logout?</h3>
${test }<br>
<%=request.getParameter("test") %><br>
<%=request.getAttribute("test") %>
<c:set var="a" value="/root/"/>
<a href="${ a }login">move to login page</a> <br>
<a href="${ a }index">move to index page</a>
</body>
</html>