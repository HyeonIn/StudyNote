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
<h2>이곳은 게시판 목록입니다.</h2>
<table border="1">
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
	<a href="board?action=list&page=<%=startPage-1%>">[이전]</a>
<%} %>
<%for(int p = startPage; p <= endPage; p++) { %>
	<a href="board?action=list&page=<%=p%>">[<%=p%>]</a>
<%} %>
<%if(endPage<totalPage){%>
	<a href="board?action=list&page=<%=endPage+1%>">[다음]</a>
<%} %>

<button id="btnWrite">글쓰기</button>
<script type = "text/javascript">
	let btnWrite = document.getElementById("btnWrite");
	btnWrite.onclick = function(){
		location.href="board?action=write";
	}
</script>
</body>
</html>

