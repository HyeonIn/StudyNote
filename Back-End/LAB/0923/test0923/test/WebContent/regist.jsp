<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#registForm>label {
	display: inline-block;
	width: 100px;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h2>상품 등록</h2>
	<form method="post" action="${root }/product" id="registForm">
		<input type="hidden" name="act" value="regist">
		<input type="hidden" id="check">
		<label for="code">상품코드:</label>
		<input type="text" name="code" id="code">
		<span id="codeError" class="error"></span><br>
		<label for="name">상품명:</label>
		<input type="text" name="name" id="name">
		<br>
		<label for="quantity">수량:</label>
		<input type="number" name="quantity" id="quantity">
		<br>
		<input type="submit" value="상품등록" id="regist">
	</form>
</body>
<script>
// 	let codeInput = document.getElementById("code");
// 	codeInput.onblur = async function(){
// 		let code = codeInput.value;
// 		console.log(code);
// 		let resp = await fetch("product?act=check&pcode="+code);
// 		document.getElementById("codeError").innerHTML = "이미 사용중인 코드입니다";		
// 	};
</script>
</html>
