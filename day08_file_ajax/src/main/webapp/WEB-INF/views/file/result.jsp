<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<C:forEach var="dto" items="${ list }">
		id : ${dto.id}<br>
		name : ${dto.name }<br>
		imgName : ${dto.imgName }<br>
		<img src="download?file=${dto.imgName }" width="100" height="100">
		<a href="download?file=${dto.imgName }">${dto.imgName }</a>
		<br>
		<a href="delete?file=${dto.imgName }&id=${dto.id}">삭제</a>
		<br>
		<a href="modify?imgName=${dto.imgName }&id=${dto.id}&name=${dto.name}">수정</a>
		<hr>
	</C:forEach>
	<a href="form">업로드로 이동</a>
</body>
</html>