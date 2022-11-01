<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../common/header.jsp" %>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-8">
				<table border="1">
							
				</table>
			</div>		
		</div>
		<div class="row justify-content-md-center">
			<div class="col-8">
				<button class="btn btn-success" type="button" onclick="location.href='${root}/view/boardList'">목록</button>
				<button class="btn btn-warning" type="button" onclick="location.href='${root}/board/update?bno=${board.bno }'">수정</button>
				<button class="btn btn-danger" type="button" onclick="location.href='${root}/board/delete?bno=${board.bno }&writer=${board.writer }'">삭제</button>
			</div>		
		</div>	
		
	</div>
	<script type="text/javascript">
	async function getDetail(){
		let resp = await fetch('${root}/board/${bno}');
		let data = await resp.json();

		let boardNum = document.createElement('tr');
		let boardNum_1 = document.createElement('td');
		boardNum_1.innerText = "No : ";
		let boardNum_2 = document.createElement('td');
		boardNum_2.innerText = data.board.bno;
		boardNum.appendChild(boardNum_1);
		boardNum.appendChild(boardNum_2);
		
		let title = document.createElement('tr');
		let title_1 = document.createElement('td');
		title_1.innerText = "제목 : ";
		let title_2 = document.createElement('td');
		title_2.innerText = data.board.title;
		title.appendChild(title_1);
		title.appendChild(title_2);
		
		let writer = document.createElement('tr');
		let writer_1 = document.createElement('td');
		writer_1.innerText = "작성자 : ";
		let writer_2 = document.createElement('td');
		writer_2.innerText = data.board.writer;
		writer.appendChild(writer_1);
		writer.appendChild(writer_2);
		
		let content = document.createElement('tr');
		let content_1 = document.createElement('td');
		content_1.innerText = "내용 : ";
		let content_2 = document.createElement('td');
		content_2.innerText = data.board.content;
		content.appendChild(content_1);
		content.appendChild(content_2);
		
		document.querySelector('table').appendChild(boardNum);
		document.querySelector('table').appendChild(title);
		document.querySelector('table').appendChild(writer);
		document.querySelector('table').appendChild(content);
		
		for(let i=0; i<data.flieList.length; i++){
			let file = data.fileList[i];
			let file_tr = document.createElement('tr');
			
			let fileName = document.createElement('td');
			fileName.setAttribute("onclick", "#");
			file_tr.appendChild(fileName);
			document.querySelector('table').appendChild(file_tr);
		}
		
	}
	getDetail();
	</script>
</body>
</html>