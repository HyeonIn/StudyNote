<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<h2>상품목록</h2>
	<table>
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>재고수량</th>
		</tr>
		<c:forEach var="p" items="${productList}">
			<tr>
			<td>${p.pcode}</td>
			<td>${p.pname}</td>
			<td>${p.pquantity}</td>
		</tr>		
		</c:forEach>
	</table>
</body>
</html>