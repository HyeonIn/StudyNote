<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>상품 목록</h2>
	  <table class="table table-hover">
	  	<tr>
	  		<th scope="col">상품 코드</th>
	  		<th scope="col">모델명</th>
	  		<th scope="col">가격</th>
	  	</tr>
	  	<c:forEach var="p" items="${productList}">
		  	<tr onclick="location.href='${root}/product?action=detail&code=${p.getCode()}'">
	  			<td>${p.getCode()}</td>
	  			<td>${p.getModel()}</td>
	  			<td>${p.getPrice()}원</td>
		  	</tr>
	  		
	  	</c:forEach>
	  	
	  </table>
	  
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>