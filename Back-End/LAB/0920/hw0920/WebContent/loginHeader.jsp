<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<title>login header</title>
</head>
<body>
<header>
	<h3>SSAFY 도서 관리 사이트</h3>
</header>
<div class="row">
	<c:choose>
		<c:when test="${sessionScope.loginInfo == null}">
			<form action="login" method="post">
				<div>
				ID: <input type="ID: " name="userid">
				PW: <input type="PW: " name="userpw">
				<input type="submit" value="login"><br>
				</div>
			</form>	
		</c:when>
		<c:otherwise>
			<div>
			<h4>${sessionScope.loginInfo.name} 님 환영합니다! <button class="btn btn-light" onclick="location.href='login?action=logout'">로그 아웃</button></h4>
			
			</div>
		</c:otherwise>
	</c:choose>
</div>
<button class="btn btn-light" onclick="location.href='book?action=list'">도서 목록 보러가기</button>
<button class="btn btn-light" onclick="location.href='bookAdd.jsp'">도서 추가 하러가기</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>