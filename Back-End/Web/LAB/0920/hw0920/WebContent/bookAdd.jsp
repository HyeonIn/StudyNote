<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="loginHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<meta charset="UTF-8">
<title>책 추가 페이지</title>
</head>
<body>
	<div class="row">
		<div class="col-6">
	      	<form class="form-control" action="book" method="post">
				<table class="table table-light table-striped">
					<tr>
						<td>제목:</td>
						<td><input class="form-control" type="text" name="title"></td>
					</tr>
					<tr>
						<td>가격:</td>
						<td><input class="form-control" type="text" name="price"></td>
					</tr>
					<tr>
						<td>출판사:</td>
						<td><input class="form-control" type="text" name="publisher"></td>
					</tr>
					<tr>
						<td>저자:</td>
						<td><input class="form-control" type="text" name="writer"></td>
					</tr>
				</table>
				<input class="form-control" type="submit" value="제출">
				<input type="hidden" name="action" value="add">
			</form>
	    </div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>