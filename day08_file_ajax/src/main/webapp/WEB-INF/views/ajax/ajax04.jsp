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
		let frm = {}
		let arr = $("#frm").serializeArray();
		console.log(arr);
		for( var i=0; i<arr.length; i++)
			frm[arr[i].name] = arr[i].value;
		console.log(frm);//{id: '1', name: '2', pwd: '3', age: '4', addr: '5'}
		
		$.ajax({
			url : "result04",
			type : "post",//put과 post는 동일함.
			data : JSON.stringify(frm)	,//서버로 전송할 데이터
			contentType : "application/json; charset=utf-8",//form이 어떤 유형인지 (서버로 보낼 데이터 유형)
			dataType : "json" ,//서버로 받을 리턴 타입 지정
			success : function(data){
				console.log("name : "+data.name)
				console.log("age : "+data.age)
				console.log("nick : "+data.nick)
			}
		});
	}
</script>
</head>
<body>
	<form id="frm">
	<input type="text" name="id"><br>
	<input type="text" name="name"><br>
	<input type="text" name="pwd"><br>
	<input type="text" name="age"><br>
	<input type="text" name="addr"><br>
	<input type="button" value="click" onclick="test()"	><br>
	</form>	
</body>
</html>