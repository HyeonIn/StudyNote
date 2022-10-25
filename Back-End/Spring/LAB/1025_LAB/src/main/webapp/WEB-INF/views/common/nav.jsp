<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


<button class="btn btn-light" onclick="location.href='${root}/board/list'">목록</button>
<button class="btn btn-light" onclick="location.href='${root}/board/write'">글작성</button>

<div class="nav">
	<c:choose>
		<c:when test="${empty sessionScope.loginInfo }">
			<form action="${root }/member/login" method="post">
				ID : <input type="text" name="userId">
				PW : <input type="password" name="userPw">
				<input type="submit" value="LOGIN">
			</form>
		</c:when>
		<c:otherwise>
			안녕하세요. <b>${loginInfo.name }</b> (${loginInfo.id })님
			<a href="${root }/member/logout">[로그 아웃]</a>
		</c:otherwise>
	</c:choose>
</div>
<hr>