<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-8">
				<h1>게시판 ㅇㅅㅇ</h1>
			</div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-8">
				<table class="table table-hover">
					<tr>
						<th>no.</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:choose>
						<c:when test="${empty boardPage or empty boardPage.boardList }">
							<tr>
								<td colspan="5">작성된 게시글이 없습니다</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="b" items="${boardPage.boardList }">
								<tr onclick="location.href='${ root}/board/read?bno=${b.bno }'">
									<td>${b.bno }</td>
									<td>${b.title }</td>
									<td>${b.writer }</td>
									<td>${b.writeDate }</td>
									<td>${b.readCount }</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-8 text-center">
				<c:if test="${boardPage.startPage>1 }">
					<button class="btn btn-light" onclick="location.href='${ root}/board/list?page=${boardPage.startPage - 1}'">이전</button>
				</c:if>
				<c:forEach begin="${boardPage.startPage}" end="${boardPage.endPage}" var="p">
					<button class="btn btn-light" onclick="location.href='${ root}/board/list?page=${p}'">${p}</button>	
				</c:forEach>
				<c:if test="${boardPage.endPage < boardPage.totalPage }">
					<button class="btn btn-light" onclick="location.href='${ root}/board/list?page=${boardPage.endPage + 1}'">다음</button>
				</c:if>		
			</div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-8 text-center">
				<button class="btn btn-info" id="btnWrite" onclick="location.href='${ root}/board/write'">글쓰기</button>
			</div>
		</div>	
	</div>
	
	
</body>
</html>