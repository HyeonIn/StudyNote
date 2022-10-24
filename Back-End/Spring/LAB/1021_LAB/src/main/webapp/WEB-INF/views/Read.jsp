<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<head>
<meta charset="UTF-8">
<title> ${board.title }</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-8">
				<table class="table table-light table-striped">
					<tr>
					<td>제목:</td>
					<td>${board.title }</td>
					</tr>
					<tr>
					<td>작성자:</td>
					<td>${board.writer }</td>
					</tr>
					<tr>
					<td>내용:</td>
					<td>${board.content }</td>
					</tr>
				</table>
			</div>		
		</div>
		<div class="row justify-content-md-center">
			<div class="col-8">
				<button class="btn btn-success" type="button" onclick="location.href='${root}/board/list'">목록</button>
				<button class="btn btn-warning" type="button" onclick="location.href='${root}/board/update?bno=${board.bno }'">수정</button>
				<button class="btn btn-danger" type="button" onclick="location.href='${root}/board/delete?bno=${board.bno }&writer=${board.writer }'">삭제</button>
			</div>		
		</div>
		<br>
		<div class="row justify-content-md-center">
			<div class="col-8">
				<h4>댓글</h4>
				<table class="table" id="ctable">
					<thead>
						<tr>						
							<th>작성자</th>
							<th>내용</th>
						</tr>
					</thead>
				</table>
			</div>		
		</div>
		<br>
		<div class="row justify-content-md-center">
			<div class="col-8">
				<h4>댓글 작성</h4>
				
				<input class="form-control" type="text" id="cwriter" placeholder="댓글 작성자"/>
				<input class="form-control" type="text" id="ccontent" placeholder="댓글 내용"/>
				<input class="form-control" type="submit" id="sendComment" value="댓글 작성">
		
			</div>		
		</div>
	</div>
	<script type="text/javascript">
		async function getComments(){
			let url = '${root}/comment/list?bno=${board.bno}';
			let response = await fetch(url);
			let data = await response.json();
			console.log(data);
			
			if (data.length > 0){
				let comments = '';
				for (let i = 0; i < data.length; i++) {
					comments += '<tr>';
					comments += '<td>'+ data[i].cwriter+'</td>';
					comments += '<td>'+ data[i].ccontent+'</td>';
					comments += '</tr>';
					
				} 
				document.getElementById("ctable").innerHTML += comments;
			}
			
		}
		getComments();
		document.getElementById('sendComment').onclick = async function(){
			let url = '${root}/comment/write';
			let cwriter = document.getElementById("cwriter").value;
			let ccontent = document.getElementById("ccontent").value;
			
			let response = await fetch(url, {
				method:'POST',
				header:{
					'Accept' : 'application/json, text/plain, */*',
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify({'bno' : '${board.bno}', 'cwriter' : cwriter, 'ccontent': ccontent })
			});
			let result = await response.text();
			console.log('댓글 쓰기 결과' , result);
			getComments();
		}	
		
	</script>
</body>
</html>