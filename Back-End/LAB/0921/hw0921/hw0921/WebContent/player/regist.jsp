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
	<c:if test="${empty sessionScope.id}">
	로그인이 필요합니다.
	<button class="btn btn-light" onclick="location.href='${root}/'">돌아가기</button>
	</c:if>
	<c:if test="${!empty sessionScope.id}">
	  <h2>신규 선수 등록</h2>
	  <form id="registForm" action="${root}/player" method="post">
	  	<input type="hidden" name="action" value="add">
	    <div class="form-group">
	      <label >선수명</label>
	      <input type="text" class="form-control" name="name" placeholder="선수명 입력">
	    </div>
	    <div class="form-group">
	      <label>등번호</label>
	      <input type="number" class="form-control" name="backnumber" placeholder="등번호 입력">
	    </div>
	    <div class="form-group">
	      <label>소속팀</label>
	      <input type="text" class="form-control" name="team" placeholder="소속팀 입력" >
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	</c:if>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>