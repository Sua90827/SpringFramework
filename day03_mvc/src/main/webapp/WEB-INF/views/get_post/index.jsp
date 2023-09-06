<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	This is the index page.
	<h3>get 방식</h3>
	<form action="result" method="get">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="get전송"><br>
	</form>
	<h3>post 방식</h3>
	<form action="result" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="post전송"><br>
	</form>
	<h3>DTO 방식</h3>
	<form action="dto" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="text" name="addr"><br>
		<input type="submit" value="dto전송"><br>
	</form>
</body>
</html>