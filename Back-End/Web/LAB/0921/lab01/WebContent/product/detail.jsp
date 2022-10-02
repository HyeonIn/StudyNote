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
	  <table class="table">
	  	<tr>
	  		<td scope="col">상품 코드</td>
	  		<td>${selectedProduct.getCode()}</td>
	  	</tr>
	  	<tr>
	  		<td scope="col">모델명</td>
	  		<td>${selectedProduct.getModel()}</td>
	  	</tr>
	  	<tr>
	  		<td scope="col">가격</td>
	  		<td>${selectedProduct.getPrice()}원</td>
	  	</tr>	  	
	  </table>
	  <button class="btn btn-danger" onclick="location.href='product?action=delete&code=${selectedProduct.getCode()}'">모델 삭제</button>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>