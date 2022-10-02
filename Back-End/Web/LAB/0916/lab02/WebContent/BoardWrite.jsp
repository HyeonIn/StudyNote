<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 화면</title>
</head>
<body>
	<form action="board" method="post">
		<table border="1">
			<tr>
			<td>제목:</td>
			<td><input type="text" name="title"></td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td><input type="text" name="writer"></td>
			</tr>
			<tr>
			<td>내용:</td>
			<td><textarea rows="20" cols="30" name="content" placeholder="여기에 내용을 입력하세요"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="제출">
		<input type="hidden" name="action" value="write">
	</form>
</body>
</html>