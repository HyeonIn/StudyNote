<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	BoardDTO tempBoard = (BoardDTO) request.getAttribute("selectedBoard");
	
	String title = tempBoard.getTitle();
	String writer = tempBoard.getWriter();
	String content = tempBoard.getContent();
	
%>
<head>
<meta charset="UTF-8">
<title>수정 하기</title>
</head>
<body>
	<form action="board" method="post">
		<table border="1">
			<tr>
			<td>제목:</td>
			<td><input type="text" name="title" value=<%=title%>></td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td><a name="writer"><%=writer%></a></td>
			</tr>
			<tr>
			<td>내용:</td>
			<td><textarea rows="20" cols="30" name="content"><%=content%></textarea></td>
			</tr>
		</table>
		<input type="submit" value="수정">
		<input type="hidden" name="action" value="edit">
	</form>
</body>
</html>