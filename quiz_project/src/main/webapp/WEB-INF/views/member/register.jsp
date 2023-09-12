<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="resources/js/daumPost.js"></script>
</head>
<body>
<%@ include file="../default/header.jsp" %>
<h3>REGISTER</h3>
${msg }
<form action="registerDo" method="post">
	<input type="text" id="id" name="id" value="${dto.id }" placeholder="id"> 
	<button type="button" onclick="idCh()">ID Check"</button>
	<br>
	<input type="pw" id="pw" name="pw" value="${dto.pw }" placeholder="password"><br>
	<input type="text" readonly id="addr1" name="addr" placeholder="우편번호">
      <button type="button" onclick="daumPost()">search post code</button><br>
      <input type="text" readonly id="addr2" name="addr" placeholder="주소"><br>
      <input type="text" name="addr" id="addr3" placeholder="상세주소"><br>
	<input type="submit" value="register"> 
</form>
<%@ include file="../default/footer.jsp" %>
</body>
</html>