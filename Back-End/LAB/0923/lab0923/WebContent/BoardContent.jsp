<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%
	BoardDTO tempBoard = (BoardDTO) request.getAttribute("selectedBoard");
	
	String title = tempBoard.getTitle();
	String writer = tempBoard.getWriter();
	String content = tempBoard.getContent();
	
%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>
<body>
	<form class="form-control" action="board" method="post" style="width : 30%">
		<table class="table table-light table-striped">
			<tr>
			<td>제목:</td>
			<td><%=title%></td>
			</tr>
			<tr>
			<td>작성자:</td>
			<td><%=writer%></td>
			</tr>
			<tr>
			<td>내용:</td>
			<td><%=content%></td>
			</tr>
		</table>
		<button class="btn btn-success" type="button" onclick="location.href='board?action=list'">목록</button>
		<button class="btn btn-warning" type="button" onclick="location.href='board?action=editContent&bno=<%=tempBoard.getBno()%>'">수정</button>
		<button class="btn btn-danger" type="button" onclick="location.href='board?action=delete&bno=<%=tempBoard.getBno()%>'">삭제</button>
	</form>
	<h5>댓글 창</h5>
	
	<table class="table" id="commentTable">
		<tr>
			<th>작성자</th>
			<th>댓글내용</th>
		</tr>
		<c:forEach var="comment" items="${requesScope.comentList}">
			<tr>
				<td>${comment.getCwriter()}
				<td>${comment.getCcontent()}
			</tr>
		</c:forEach>
	</table>
	
	댓글 작성자 : <input type="text" id="cwriter"><br>
	댓글 내용 : <input type="text" id="ccontent"><br>
	<button class="btn btn-primary" id="btnComment">댓글 쓰기</button>
	
	
	<script type="text/javascript">
		let cmtTable = document.getElementById("commentTable");
		
		
		
		async function getComments(){
			let resp = await fetch("coment?action=list&bno=${selectedBoard.bno}");
			let data = await resp.json();
			
			if (!data || data.length==0) {
				let tmp = "<tr><td>작성된 댓글이 없습니다. 댓글을 작성해주세요.</td></tr>"
				document.getElementById("commentTable").innerHTML = tmp;
			}else{
				let tmp ="";
				for(let i=0; i<data.length; i++){
					tmp += "<tr>";
					tmp += "<td>"+data[i].cwriter+"</td>";
					tmp += "<td>"+data[i].ccontent+"</td>";
					tmp += "<td><button class='btn btn-primary' onclick='delete()'>삭제</button></td>"
					tmp += "</tr>";
				}
				document.getElementById("commentTable").innerHTML = tmp;
			}
			let btnComment = document.getElementById("btnComment");
			btnComment.onclick = async function(){
				let cwriter = document.getElementById("cwriter").value;
				let ccontent = document.getElementById("ccontent").value;
				
				let resp = await fetch("coment?action=add&bno=${selectedBoard.bno}&cwriter="+cwriter+"&ccontent="+ccontent, {
					method:'POST'
				});
				let result = await resp.text();
				getComments();
			}
		};
		
		getComments();
				
	</script>	
	
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>