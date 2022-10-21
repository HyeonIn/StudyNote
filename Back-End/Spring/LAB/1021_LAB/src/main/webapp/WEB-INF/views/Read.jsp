<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<head>
<meta charset="UTF-8">
<title> ${board.title }</title>
</head>
<body>
	<form class="form-control" action="board" method="post" style="width : 30%">
		<table class="table table-light table-striped">
			<tr>
			<td>제목:</td>
			<td>${board.title }</td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td>${board.writer }</td>
			</tr>
			<tr>
			<td>내용:</td>
			<td>${board.content }</td>
			</tr>
		</table>
		<button class="btn btn-success" type="button" onclick="location.href='${root}/board/list'">목록</button>
		<button class="btn btn-warning" type="button" onclick="location.href='${root}/board/update?bno=${board.bno }'">수정</button>
		<button class="btn btn-danger" type="button" onclick="location.href='${root}/board/delete?bno=${board.bno }&writer=${board.writer }'">삭제</button>
	</form>	
</body>
</html>