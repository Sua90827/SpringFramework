<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/test.js"></script>
<link href="${contextPath }/css/test.css" rel="stylesheet"/>
<!-- 
<script type="text/javascript">
	function test(){
		alert("test click")
	}
	window.onload=()=>{
		const btn = document.getElementById("btn")
		btn.addEventListener("click", test); 
	}
</script>
 -->
</head>
<body>
path; ${contextPath }
<h3>login page</h3>
<button type="button" id="btn">click</button>
<button type="button" onclick="test()">click test</button>
	<form action="login_chk" method="post">
		<input type="text" id="id" name="id"><br>
		<input type="password" name="pwd"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>