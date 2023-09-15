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
	<h3>게시판</h3>
	
	<table border="1">
	
		<tr>
			<th>번호</th>
			<th>id</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>image_file_name</th>
		</tr>
		
		
		<tr>
		
		<c:if test="${ empty boardList }">
			<td colspan="6">
				등록된 글이 없습니다.		
			</td>
		</c:if>
		
		<c:if test="${ not empty boardList }">
			<td>${writeNo }</td>
			<td>${id }</td>
			<td>${title }</td>
			<td>${saveDate }</td>
			<td>${hit }</td>
			<td>${imagineFileName }</td>
		</c:if>
		
		</tr>
	
	
		<tr>
			<c:if test="${ empty sessionScope.user_id }">
				<a href="login">글작성</a>
			</c:if>
			
			<c:if test="${ not empty sessionScope.user_id }">
				<a href="writeForm">글작성</a>
			</c:if>
		</tr>
		
	</table>
</body>
</html>