<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 화면</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<div class="row justify-content-center">
		<div class="col-8">
	      	<form class="form-control" action="board" method="post">
				<table class="table table-light table-striped">
					<tr>
						<td>제목:</td>
						<td><input class="form-control" type="text" name="title"></td>
					</tr>
					<tr>
						<td>작성자:</td>
						<td><input class="form-control" type="text" name="writer"></td>
					</tr>
						<tr>
						<td>내용:</td>
					<td><textarea class="form-control" rows="20" cols="30" name="content" placeholder="여기에 내용을 입력하세요"></textarea></td>
					</tr>
				</table>
				<input class="form-control" type="submit" value="제출">
				<input type="hidden" name="action" value="write">
			</form>
	    </div>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>