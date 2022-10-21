<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<head>
<meta charset="UTF-8">
<title> ${bno }번 글 수정하기</title>
</head>
<body>
	<form class="form-control" action="update" id="updateForm" method="post" style="width : 30%">
		<table class="table table-light table-striped">
			<tr>
			<td>제목:</td>
			<td><input class="form-control" type="text" name="title" value="${board.title }"></td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td>${board.writer }
			<input type="hidden" name="writer" value="${board.writer }"> 
			<input type="hidden" name="bno" value="${board.bno }"> 
			<input type="hidden" name="readCount" value="${board.readCount }"> 
			</td>
			</tr>
			<tr>
			<td>내용:</td>
			<td><textarea class="form-control" rows="20" cols="30" name="content" >${board.content }</textarea></td>
			</tr>
		</table>
		<button class="btn btn-warning" type="button" onclick="location.href='${ root}/board/read?bno=${board.bno }'">돌아가기</button>
		<button class="btn btn-success" type="button" id="updateBtn" onclick="location.href='${root}/board/update'">수정하기</button>
	</form>	
	<script type="text/javascript">
		document.getElementById("updateBtn").onclick= function (){
				document.getElementById("updateForm").submit();
		}
	</script>
</body>
</html>