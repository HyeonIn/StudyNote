<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="sendForm" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목:</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>작성자:</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>내용:</td>
				<td><textarea rows="10" cols="10" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="addFile">파일 추가</button>
					<div id="addFileList">
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="btn-send" value="작성완료"></td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
		document.getElementById("btn-send").onclick = async function () {
			let sendForm = document.getElementById('sendForm');

			let formData = new FormData(sendForm);
			
			let url = '${root}/board';

			let resp = await fetch(url, {
				method : 'POST',
				body : formData
			});
			let result = await resp.text();
			
			alert(result); // success or error
			
			location.href='${root}/view/boardList'
		}
		
		document.getElementById('addFile').onclick = function(){
            document.getElementById('addFileList').innerHTML 
                            += '<input type="file" name="uploadFile"><br>';
            return false; // 파일 추가 버튼 클릭 이벤트가 form에 전달되지 않도록.
    	}
	</script>
</body>
</html>