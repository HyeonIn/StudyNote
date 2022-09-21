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
	
		<h2>선수 목록</h2>
		<table class="table table-hover">
			<tr>
				<th>선수명</th>
				<th>등번호</th>
				<th>소속팀</th>
			</tr>
			<c:forEach var="p" items="${playerList}">
				<tr onclick="location.href='player?action=detail&pid=${p.getPid()}'">
					<td>${p.getName()}</td>
					<td>${p.getBacknumber()}</td>
					<td>${p.getTeam()}</td>
				</tr>
			</c:forEach>
			
		</table>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>