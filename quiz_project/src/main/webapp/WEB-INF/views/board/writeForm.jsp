<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/img_view.js"></script>
</head>
<body>
   <%@ include file="../default/header.jsp" %>
   <div align="center">
      <h1>글쓰기</h1>
      <form action="writeSave" method="post" enctype="multipart/form-data">
         <table>
            <tr>
               <td>
                  <b>작성자</b><br>
                  <input type="text" name="id" value="${ user_id }" readonly>
               </td>
            </tr>
            <tr>
               <td>
                  <b>제목</b><br>
                  <input type="text" name="title"> 
               </td>
            </tr>
            <tr>
               <td>
                  <b>내용</b><br>
                  <textarea name="content"></textarea>
               </td>
            </tr>
            <tr>
               <td>
                  <b>이미지파일 첨부</b>
                  <input type="file" name="image_file_name" onchange="readURL(this);">
                  <div><img id="preview"  width=100 height=100 alt="선택된 이미지가 없습니다." /></div>

               </td>
            </tr>
            <tr>
               <td>
                  <button type="submit">글쓰기</button>
                  <button type="button" onclick="window.history.back();">목록보기</button>
               </td>
            </tr>
         </table>
      </form>
   </div>
      <%@ include file="../default/footer.jsp" %>
   
</body>
</html>