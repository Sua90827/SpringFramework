<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div align="center">
      <h3>upload1</h3>
      <form action="upload1" method="post" enctype="multipart/form-data">
         <input type="text" name="id"><br>
         <input type="text" name="name"><br>
         <input type="file" name="file"><br>
         <input type="submit" value="전송">
      </form>
      <a href = "views">내용확인</a>
   </div>
   <br><br><br><br>
   <div align="center">
      <h3>upload2</h3>
      <form action="upload2" method="post" enctype="multipart/form-data">
         <input type="text" name="id"><br>
         <input type="text" name="name"><br>
         <input type="file" name="file"><br>
         <input type="submit" value="전송">
      </form>
   </div>
</body>
</html>