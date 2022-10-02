<%@page import="model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<h2>게시글 목록</h2>
<table class="table table-light table-striped">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일시</th>
		<th>조회수</th>
	</tr>
	<c:choose>
		<c:when test="${boardPage == null || boardPage.boardList == null || boardPage.boardList.size() == 0 }">
			<tr>
				<td colspan="5">작성된 게시글이 없습니다. 게시글을 작성해보세요.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="b" items="${boardPage.boardList}">
				<tr>
					<td>${b.getBno()}</td>
					<td><a href="board?action=content&bno=${b.getBno()}">${b.getTitle()}</a></td>
					<td>${b.getWriter()}</td>
					<td>${b.getWriteDate()}</td>
					<td>${b.getReadCount()}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>	
</table>
<c:if test="${boardPage.startPage>1 }">
	<button class="btn btn-light" onclick="location.href='board?action=list&page=${boardPage.startPage - 1}'">이전</button>
</c:if>
<c:forEach begin="${boardPage.startPage}" end="${boardPage.endPage}" var="p">
	<button class="btn btn-light" onclick="location.href='board?action=list&page=${p}'">${p}</button>	
</c:forEach>
<c:if test="${boardPage.endPage < boardPage.totalPage }">
	<button class="btn btn-light" onclick="location.href='board?action=list&page=${boardPage.endPage + 1}'">다음</button>
</c:if>

<button class="btn btn-info" id="btnWrite">글쓰기</button>
<script type = "text/javascript">
	let btnWrite = document.getElementById("btnWrite");
	btnWrite.onclick = function(){
		location.href="board?action=write";
	}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>

