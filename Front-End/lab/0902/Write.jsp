<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
</head>
<body>
선수 추가를 위한 화면입니다.
<form action="<%=request.getContextPath()%>/player" method="post">
	<input type="hidden" name="action" value="add">
	<table border="1">
		<tr>
			<td>ID:</td>
			<td><input type="number" name="id"></td>
		</tr>
		<tr>
			<td>이름:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>등번호:</td>
			<td><input type="number" name="backnumber"></td>
		</tr>
		<tr>
			<td>소속팀:</td>
			<td><input type="text" name="team"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="제출">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
