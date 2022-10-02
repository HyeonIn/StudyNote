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
<title><%=title%></title>
</head>
<body>
	<form action="board" method="post">
		<table border="1">
			<tr>
			<td>제목:</td>
			<td><%=title%></td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td><%=writer%></td>
			</tr>
			<tr>
			<td>내용:</td>
			<td><%=content%></td>
			</tr>
		</table>
		<button type="button" onclick="location.href='board?action=list'">목록</button>
		<button type="button" onclick="location.href='board?action=editContent&bno=<%=tempBoard.getBno()%>'">수정</button>
		<button type="button" onclick="location.href='board?action=delete&bno=<%=tempBoard.getBno()%>'">삭제</button>
	</form>
</body>
</html>