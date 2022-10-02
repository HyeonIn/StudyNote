<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="loginHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<meta charset="UTF-8">
<title>ssafy 도서 관리 사이트</title>
</head>
<body>
<div class="row">
	<div class="col-6">
	<table class="table table-light table-striped">
		
		<tr>
			<th>책번호</th>
			<th>가격</th>
			<th>제목</th>
			<th>출판사</th>
			<th>저자</th>
			<th>삭제여부</th>
		</tr>
		<c:choose>
			<c:when test="${requestScope.bookList == null}">
				<tr>
					<td colspan="5">책이 없습니다. 책을 추가해보세요.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="b" items="${requestScope.bookList}">
					<tr>
						<td>${b.getNo()}</td>
						<td>${b.getPrice()}</td>
						<td><a href="book?action=detail&no=${b.getNo()}">${b.getTitle()}</a></td>
						<td>${b.getPublisher()}</td>
						<td>${b.getWriter()}</td>
						<td><input type="checkbox" name="deleteBook"></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>	
	</table>
	</div>
	<div>
		<button class="btn btn-light">체크한 모든 도서 삭제</button>
		<button class="btn btn-light" onclick="location.href='bookAdd.jsp'">도서 추가</button>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>