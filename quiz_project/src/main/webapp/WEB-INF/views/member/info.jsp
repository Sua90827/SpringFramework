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
<h2>${sessionScope.user_id } Information</h2>
<table  border="1">
	<tr>
		<th>ID</th><td>${info.id }
	</tr>
	<tr>
		<th>PASSWORD</th><td>${info.pw }
	</tr>
	<tr>
		<th>ADDRESS</th><td>${info.addr }
	</tr>
	
</table>
<%@ include file="../default/footer.jsp" %>
</body>
</html>