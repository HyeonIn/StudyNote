<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>"${selectedBoard.getTitle()}"</title>
</head>
<body>
	<form class="form-control" action="board" method="post" style="width : 30%">
		<table class="table table-light table-striped">
			<tr>
			<td>제목:</td>
			<td>${selectedBoard.getTitle()}</td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td>${selectedBoard.getWriter()}</td>
			</tr>
			<tr>
			<td>내용:</td>
			<td>${selectedBoard.getContent()}</td>
			</tr>
		</table>
		<button class="btn btn-success" type="button" onclick="location.href='board?action=list'">목록</button>
		<button class="btn btn-warning" type="button" onclick="location.href='board?action=editContent&bno=${selectedBoard.getBno()}'">수정</button>
		<button class="btn btn-danger" type="button" onclick="location.href='board?action=delete&bno=${selectedBoard.getBno()}'">삭제</button>
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>