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
		let n = document.getElementById("name").value;
		let a = $("#age").val();
		let form = {name : n, age : a}; //object type  =>서버에서 받을 수 없음. json형식으로 바꿔야 함.
		$.ajax({
			url : "result03",
			type : "post",
			data : JSON.stringify(form),//서버로 전송할 데이터
			contentType : "application/json; charset=utf-8",//form이 어떤 유형인지 (서버로 보낼 데이터 유형)
			dataType : "json" ,//서버로 받을 리턴 타입 지정
			success : function(data){
				console.log("name : "+data.name)
				console.log("age : "+data.age)
			}
		});
	}
</script>
</head>
<body>
	name : <input type="text" id="name"><br>
	age : <input type="text" id="age"><br>
	<input type="button" onclick="test()" value="send"><br>
</body>
</html>