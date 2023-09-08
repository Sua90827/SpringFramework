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

	<h3>Every Member's Info</h3>
	<table border="1">
		<tr>
			<th>ID</th><th>PASSWORD</th><th>ADDRESS</th>
		</tr>
		
		<c:forEach var="info" items="${list }" varStatus="status">
			<tr>
				<td><a href="info?id=${info.id }">${info.id }</a></td><td>${info.pw }</td><td>${info.addr }</td>
			</tr>
		</c:forEach>
		
	</table>

<%@ include file="../default/footer.jsp" %>
</body>
</html>