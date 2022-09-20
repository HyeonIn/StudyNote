<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="loginHeader.jsp" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>"${requestScope.bookFind.getTitle()}"</title>
</head>
<body>
	<div class="row ">
		<div class="col-6">
			<form class="form-control" action="board" method="post">
				<table class="table table-light table-striped">
					<tr>
						<td>제목:</td>
						<td>${requestScope.bookFind.getTitle()}</td>
					</tr>
					<tr>
						<td>가격:</td>
						<td>${requestScope.bookFind.getPrice()}</td>
					</tr>
					<tr>
						<td>출판사:</td>
						<td>${requestScope.bookFind.getPublisher()}</td>
					</tr>
					<tr>
						<td>저자:</td>
						<td>${requestScope.bookFind.getWriter()}</td>
					</tr>
				</table>
				<button class="btn btn-danger" type="button" onclick="location.href='book?action=delete&no=${requestScope.bookFind.getNo()}'">삭제</button>
			</form>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>