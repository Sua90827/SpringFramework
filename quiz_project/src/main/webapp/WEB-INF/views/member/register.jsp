<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../default/header.jsp" %>
<h3>REGISTER</h3>
<form action="registerDo" method="post">
	id: <input type="text" id="id" name="id"><br>
	pw: <input type="pw" id="pw" name="pw"><br>
	addr: <input type="addr" id="addr" name="addr"><br>
	<input type="submit" value="register">
</form>
<%@ include file="../default/footer.jsp" %>
</body>
</html>