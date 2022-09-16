<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Write</title>
</head>
<body>
책 추가를 위한 화면입니다.
<form action="<%=request.getContextPath()%>/book" method="post">
	<input type="hidden" name="action" value="add">
	<table border="1">
		<tr>
			<td>제목:</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>저자:</td>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>출판사:</td>
			<td><input type="text" name="publisher"></td>
		</tr>
		<tr>
			<td>가격:</td>
			<td><input type="number" name="price"></td>
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