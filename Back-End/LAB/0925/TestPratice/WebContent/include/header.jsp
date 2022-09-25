<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  
<c:set var="root" value="${pageContext.request.contextPath}" />
<style>
#title {
	text-align: center;
}

#loginInfo {
	text-align: right;
}

#menu>li {
	display: inline-block;
	width: 150px;
}
.error{
	color: red;
}
table{
	width: 100%;
	border-collapse: collapse;
}
table td, table th{
	border:1px solid black;
}
</style>

<h1 id="title">SSAFY Shop</h1>
<div id="loginInfo">
	<c:if test="${empty loginUser }">
		<form method="post" action="${root }/user">
			<input type="hidden" name="act" value="login">
			<input type="text" name="id" placeholder="아이디">
			<input type="password" name="pass" placeholder="비밀번호">
			<input type="submit" value="login">
		</form>
	</c:if>
	<c:if test="${!empty loginUser }">
		<span>${loginUser.mname}님 반갑습니다. <a href="user?act=logout">로그아웃</a></span>
	</c:if>
</div>
<ul id="menu">
	<li><a href="${root }/product?act=list">상품 목록</a></li>
	<li><a href="${root }/product?act=registForm">상품 등록</a></li>
</ul>
<hr>
<script>
	// request.setAttribute("msg", "id 또는 pass를 확인하세요") 형태로 attribute를 넘겨주면 alert을 확인할 수 있다.
	let msg = "${msg}";
	if (msg) {
		alert(msg);
	}
</script>