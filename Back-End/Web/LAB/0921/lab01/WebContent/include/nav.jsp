<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/product?action=list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/product?action=add">상품 정보 등록</a></li>
		<li class="nav-item">
			<c:choose>
				<c:when test="${empty sessionScope.id}">
				    <form class="form-control" style="background-color: rgba(0, 0, 0, 0); border: 0px" action="${root}/login" method="post">
				      <input type="hidden" name="action" value="loginCheck">
				      <input class="form-control" style="display: inline-block; width : 30%" type="text" placeholder="ID" name="id">
				      <input class="form-control" style="display: inline-block; width : 30%" type="password" placeholder="PW" name="pw">
				      <button class="btn btn-primary" type="submit">Login</button>
				    </form>					
				</c:when>
				<c:otherwise>
					<h6 style="color: white; display:inline-block">${sessionScope.id}님 환영합니다.</h6>
					<a class="nav-link" style="display:inline-block" href="${root}/login?action=logout">로그아웃</a>
				</c:otherwise>
			</c:choose>
  		</div>
	</ul>
</nav>