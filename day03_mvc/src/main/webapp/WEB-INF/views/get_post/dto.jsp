<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>result</h3>
	name: ${dto.name }
	age: ${dto.getAge() }
	addr: ${dto.getAddr() }
</body>
</html>