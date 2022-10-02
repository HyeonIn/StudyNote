<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아파트 매매 실거래 자료 검색
	<input type="text" id="lawd" />
	<input type="text" id="deal" />
	<button id="btnSearch">검색</button>
	
	<table border="1" id="resultSearch">
			<tr>
				<th>법정동</th>
				<th>아파트</th>
				<th>지역코드</th>
				<th>거래금액</th>
			</tr>
	</table>
	
	<script type="text/javascript">
		let btn = document.getElementById("btnSearch");
		btn.onclick = async function() {
			let lawd = document.getElementById('lawd').value;
			let deal = document.getElementById('deal').value;
			
			let url = '<%=request.getContextPath()%>/api?lawd='+ lawd + '&deal='+deal;
			let response = await fetch(url);
			
			
			let data = await response.text();
			
			console.log(data);
			
			let parseXML = new DOMParser();
			let xmlDoc = parseXML.parseFromString(data, "text/xml");
			
			let items = xmlDoc.querySelectorAll("item");
			
			let result = '';
			items.forEach(function(item){
				result += '<tr>';
				result += '<td>'+item.querySelector("법정동").textContent+'</td>'
				result += '<td>'+item.querySelector("아파트").textContent+'</td>'
				result += '<td>'+item.querySelector("지역코드").textContent+'</td>'
				result += '<td>'+item.querySelector("거래금액").textContent+'</td>'
				result += '</tr>';
			})
			
			document.getElementById('resultSearch').innerHTML += result;
		}
	</script>

	
</body>
</html>