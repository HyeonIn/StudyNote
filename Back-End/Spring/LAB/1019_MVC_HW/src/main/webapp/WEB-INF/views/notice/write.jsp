<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
</head>
<body>
	<form action="${root }/notice/write" method="post">
		제목 : <input type="text" name="subject"><br>
		내용 : <textarea rows="10" cols="10" name = "content"></textarea><br>
		작성자 : <input type="text" name="userId"><br>
		<input type="submit" value="작성완료.">
	</form>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</html>