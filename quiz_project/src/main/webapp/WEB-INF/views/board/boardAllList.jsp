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
		
		
		<c:if test="${ empty boardList }">
		<tr>
		
			<td colspan="6">
				등록된 글이 없습니다.		
			</td>
		</tr>
		</c:if>
		
		<c:if test="${ not empty boardList }">
		<c:forEach var="dto" items="${boardList }">
			<tr>
				<td>${dto.writeNo }</td>
				<td>${dto.id }</td>
				<td><a href="contentView?writeNo=${dto.writeNo }">${dto.title }</a></td>
				<td>${dto.saveDate }</td>
				<td>${dto.hit }</td>
				<td>${dto.imageFileName }</td>
			</tr>
		</c:forEach>
		</c:if>
		
	
	
		<tr>
			<td colspan="6">
				<c:forEach var="n" begin="1" end="${repeat }">
					<a href="board?num=${n }">${ n } </a>
				</c:forEach>
			<c:if test="${ empty sessionScope.user_id }">
				<a href="login">글작성</a>
			</c:if>
			
			
			<c:if test="${ not empty sessionScope.user_id }">
				<a href="writeForm">글작성</a>
			</c:if>
			</td>
		</tr>
		
	</table>
	      <%@ include file="../default/footer.jsp" %>
	
</body>
</html>