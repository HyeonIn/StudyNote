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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>수정 하기</title>
</head>
<body>
	<form class="form-control" action="board" method="post" style="width : 30%">
		<table class="table table-light table-striped">
			<tr>
			<td>제목:</td>
			<td><input class="form-control" type="text" name="title" value=<%=title%>></td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td><a name="writer"><%=writer%></a></td>
			</tr>
			<tr>
			<td>내용:</td>
			<td><textarea class="form-control" rows="20" cols="30" name="content"><%=content%></textarea></td>
			</tr>
		</table>
		<input class="form-control" type="submit" value="수정">
		<input class="form-control" type="button" onclick="location.href='board?action=list'" value="목록">
		<input type="hidden" name="bno" value=<%=tempBoard.getBno()%>>
		<input type="hidden" name="action" value="edit">
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>