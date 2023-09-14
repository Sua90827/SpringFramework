<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
		function test(){
			$.ajax({url : "result02", type : "get", 
				success : function(data){
				$("#txt").html(data+"<br>aa");
			},
			error : function(){
				console.log("문제 발생!!!");
			}
			});
			
		}
	</script>
</head>
<body>
	<h1>1111</h1>  <h1>1111</h1>  <h1>1111</h1>
	<h1>1111</h1>  <h1>1111</h1>  <h1>1111</h1>
	<h1>1111</h1>  <h1>1111</h1>  <h1>1111</h1>
	<h1>1111</h1>  <h1>1111</h1>  <h1>1111</h1>
	<button type="button" onclick="test()">click</button>
	<hr>
	<b id="txt"></b>
</body>
</html>