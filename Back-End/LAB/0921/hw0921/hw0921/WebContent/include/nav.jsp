<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/player?action=list">선수 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/player?action=add">신규 선수 등록</a></li>
		<c:choose>
			<c:when test="${empty sessionScope.id}">
				<li class="nav-item">
					<form action="${root}/login" method="post">
						<input type="hidden" name="action" value="loginCheck">
						<div class="form-group" style="display: inline-block">
			      			<input type="text" class="form-control-sm" name="id" placeholder="ID">
			    		</div>
			   			<div class="form-group" style="display: inline-block">
			      			<input type="password" class="form-control-sm" name="pw" placeholder="PW">
			    		</div>
			    		<div class="form-group" style="display: inline-block">
			    			<button type="submit" class="btn btn-light btn-sm">로그인</button>
			    		</div>
					</form>
				</li>
				<li class="nav-item">
					<form action="${root}/login" method="get">
						<input type="hidden" name="action" value="register">
						<div class="form-group" style="margin-left:7px; margin-top: 2px">
							<button class="btn btn-light btn-sm">회원 가입</button>											
						</div>
					</form>
				</li>
			</c:when>
			<c:otherwise>
				<li class="nav-item">
					<h3 class="nav-item" style="color:white;">${sessionScope.id}님 환영합니다.</h3>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${root}/login?action=logout">로그 아웃</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>