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
		${requestScope.resultMsg}
		<div>
			<a href="${root}">메인 화면으로 이동</a>
		</div>
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>