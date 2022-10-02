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
	
	  <h2>회원 가입</h2>
	  <form action="${root}/login" method="post">
	  	<input type="hidden" name="action" value="register">
	    <div class="form-group">
	      <label>ID</label>
	      <input type="text" class="form-control" name="id" placeholder="아이디 입력">
	    </div>
	    <div class="form-group">
	      <label>PW</label>
	      <input type="password" class="form-control" name="pw" placeholder="비밀번호 입력">
	    </div>
	    <button type="submit" class="btn btn-primary">회원 가입</button>
	    <a class="btn btn-secondary" href="${root}">취소</a>
	  </form>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>