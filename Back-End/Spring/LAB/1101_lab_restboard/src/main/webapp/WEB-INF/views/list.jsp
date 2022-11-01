<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text">
	<a href="${root }/view/boardWrite">[글쓰기]</a>
	<table border="1">
		<tr>
			<th>no.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td colspan="5">게시글이 없습니다.. 진짜일까요 ? </td>
		</tr>
	</table>
	<div id="div-page"></div>
	
	<script type="text/javascript">
	async function getPage(page){
		if(!page)
			page = 1;
		let resp = await fetch('${root}/board?page='+page);
		let data = await resp.json();
		
		
		// 맨 위 tr 빼고 그아래 싹 지운다음에 새로운 목록 보여주기
		document.querySelectorAll('tr:not(:first-child)').forEach(e=>e.remove());

		for(let i=0; i<data.boardList.length; i++){
			let board = data.boardList[i];
			let tr = document.createElement('tr');
			tr.setAttribute('onclick', "location.href='${root}/view/boardRead/"+board.bno+"'")
			let no = document.createElement('td');
			no.innerText = board.bno;
			let title = document.createElement('td');
			title.innerText = board.title;
			let writer = document.createElement('td');
			writer.innerText = board.writer;
			let writeDate = document.createElement('td');
			writeDate.innerText = board.writeDate;
			let readCount = document.createElement('td');
			readCount.innerText = board.readCount;
			
			tr.appendChild(no);
			tr.appendChild(title);
			tr.appendChild(writer);
			tr.appendChild(writeDate);
			tr.appendChild(readCount);
			document.querySelector('table').appendChild(tr);
		}
		
		let divPage = document.getElementById('div-page');
		divPage.innerHTML = ''; // 페이지 영역 청소
		if(data.startPage > 1){
			let before = document.createElement('a');
			before.innerText = '[이전]';
			before.setAttribute('href', '#')
			before.setAttribute('id', 'a-before');
			before.setAttribute('onclick', 'getPage('+(data.startPage-1)+')');
			divPage.appendChild(before);
		}
		
		for(let i=data.startPage; i<=data.endPage; i++){
			let page = document.createElement('a');
			page.innerText = '['+i+']';
			page.setAttribute('href', '#')
			page.setAttribute('id', 'a-page');
			page.setAttribute('onclick', 'getPage('+i+')');
			divPage.appendChild(page);
		}
		
		if(data.endPage < data.totalPage){
			let after = document.createElement('a');
			after.innerText = '[다음]';
			after.setAttribute('href', '#');
			after.setAttribute('id', 'a-after');
			after.setAttribute('onclick', 'getPage('+(data.endPage+1)+')');
			divPage.appendChild(after);
		}
		
	}
	getPage();
	</script>
</body>
</html>



