<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지</h1>
${msg }
	<form action="login.do" method="post">
		<input type="text" name="id" placeholder="id">
		<button>로그인</button>
	</form>
</body>
</html>