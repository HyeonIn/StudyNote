<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Write</title>
</head>
<body>
å �߰��� ���� ȭ���Դϴ�.
<form action="<%=request.getContextPath()%>/book" method="post">
	<input type="hidden" name="action" value="add">
	<table border="1">
		<tr>
			<td>����:</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>����:</td>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>���ǻ�:</td>
			<td><input type="text" name="publisher"></td>
		</tr>
		<tr>
			<td>����:</td>
			<td><input type="number" name="price"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="����">
			</td>
		</tr>
	</table>
</form>
</body>
</html>