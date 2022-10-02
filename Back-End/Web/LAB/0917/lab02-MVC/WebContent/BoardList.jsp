<%@page import="model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<%
	HashMap<String, Object> boardPage = 
		(HashMap<String, Object>)request.getAttribute("boardPage");
	
	int currPage = (int)boardPage.get("currPage");
	int startPage = (int)boardPage.get("startPage");
	int endPage = (int)boardPage.get("endPage");
	int totalPage = (int)boardPage.get("totalPage");
	
	List<BoardDTO> boardList = (List<BoardDTO>) boardPage.get("boardList");
%>
<h2>게시글 목록</h2>
<table class="table table-light table-striped">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일시</th>
		<th>조회수</th>
	</tr>
	<%if(boardPage==null || boardList==null || boardList.size()==0){ %>
	<tr>
		<td colspan="5">작성된 게시글이 없습니다. 게시글을 작성해보세요.</td>
	</tr>
	<%}else{%>
	<%		for(BoardDTO b: boardList){ %>
	<tr>
		<td><%=b.getBno()%></td>
		<td><a href="board?action=content&bno=<%=b.getBno()%>"><%=b.getTitle()%></a></td>
		<td><%=b.getWriter()%></td>
		<td><%=b.getWriteDate()%></td>
		<td><%=b.getReadCount()%></td>
	</tr>	
	<%		} %>
	<%} %>
	
</table>
<%if(startPage>1){%>
	<button class="btn btn-light" onclick="href='board?action=list&page=<%=startPage-1%>'">이전</button>
<%} %>
<%for(int p = startPage; p <= endPage; p++) { %>
	<button class="btn btn-light" onclick="href='board?action=list&page=<%=p%>'"><%=p%></button>
<%} %>
<%if(endPage<totalPage){%>
	<button class="btn btn-light" onclick="href='board?action=list&page=<%=endPage+1%>'">다음</button>
<%} %>

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

