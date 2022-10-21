<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<title>글 작성 화면</title>
</head>
<body>
	<form class="form-control" action="write" method="post" style="width : 30%">
		<table class="table table-light table-striped">
			<tr>
			<td>제목:</td>
			<td><input class="form-control" type="text" name="title"></td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td><input class="form-control" type="text" name="writer" value="${loginInfo.name }" ></td>
			</tr>
			<tr>
			<td>내용:</td>
			<td><textarea class="form-control" rows="20" cols="30" name="content" placeholder="여기에 내용을 입력하세요"></textarea></td>
			</tr>
		</table>
		<input class="form-control" type="submit" value="제출">
	</form>
</body>
</html>