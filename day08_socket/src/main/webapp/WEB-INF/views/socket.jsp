<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script type="text/javascript">
  let sock = null;
  window.onload =()=>{
	  let wsUri = "ws://localhost:8080/root/test/websocket";
	  sock = new WebSocket(wsUri);
	  sock.onmessage = onMessage;//onmessage라는 변수에 onSessage라는 함수를 등록. 이걸 해야 내가 보낸 메세지를 내가 받을 수 있음.
	  $("#sendBtn").click( ()=>{
		sendMessage(); 
	  })
  }
  function onMessage( msg ){
	  $("#rec_data").append(msg.data+"<br>")
  }
  function sendMessage(){
	  sock.send($("#send_msg").val());//연결되어 있는 소켓으로 메세지를 전송해라.  
  		$("#send_msg").val("");
  }
  
 
  </script>
</head>
<body>
	<div id="rec_data"></div>
	<input type="text" id="send_msg"><br>
	<button type="button" id="sendBtn">전송</button>
</body>
</html>