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
		<input type="button" value="상품등록" id="regist">
	</form>
</body>
<script>
	let button = document.getElementById("regist");
	
	
	let check = true; //pcode가 사용중인 코드인가, false : 사용중이지 않음, true : 사용중
	
	button.onclick = function(){		
		if (check) {
			alert("상품코드를 확인하세요")
		}
		else{
			let form = document.getElementById("registForm");
			form.submit();
		}
	}
	
	let pcode = document.getElementById("code");
	let errorSpan = document.getElementById("codeError");
	pcode.onblur = async function() {
		let resp = await fetch("product?act=check&code="+pcode.value);
		let data = await resp.text();

		if (data == 0) {
			errorSpan.innerHTML = "";
			check=false; //사용중이지 않은 pcode
		}
		else{
			errorSpan.innerHTML = "이미 사용중인 코드입니다.";	
			check=true;
		}
	}
</script>
</html>
