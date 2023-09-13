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
<h3> 수정페이지 </h3>
	<form action="modify.do" method="post" enctype="multipart/form-data">
		ID  
		<br><input type="text" name="id" readonly value="${dto.id }"><hr>
		NAME 
		<br> <input type="text" name="name" value="${dto.name }"><hr>
		PREVIOUS IMG 
		<br> <img src="download?file=${dto.imgName }" width="100" height="100">
		<br>  ${dto.imgName }<hr>
		NEW IMG
		<br> <input type="file" name="file"><hr>
		<input type="submit" value="수정하기">	
	</form>
</body>
</html>