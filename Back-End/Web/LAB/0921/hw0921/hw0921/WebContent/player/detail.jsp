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
	<button class="btn btn-light" onclick="location.href='${root}/player?action=list'">돌아가기</button>
	</c:if>
	<c:if test="${!empty sessionScope.id}">
	  <h2>선수 상세 정보</h2>
	  <table class="table table-hover">
			<tr>
				<td>선수명</td>
				<td>${detailPlayer.getName()}</td>
			</tr>
			<tr>
				<td>등번호</td>
				<td>${detailPlayer.getBacknumber()}번</td>
			</tr>
			<tr>
				<td>소속팀</td>
				<td>${detailPlayer.getTeam()}</td>
			</tr>
		</table>
		<button class="btn btn-danger" onclick="location.href='player?action=delete&pid=${detailPlayer.getPid()}'">해당 선수 데이터 삭제</button>
	</c:if>	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>