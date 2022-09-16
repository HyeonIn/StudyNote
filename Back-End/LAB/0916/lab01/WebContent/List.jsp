<%@page import="model.Book"%>
<%@page import="model.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>List</title>
</head>
<body>
	<%
		List<Book> bookList = (List<Book>)request.getAttribute("bookList");
	%>
	<table border="1">
		<tr>
			<th>no.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
	<%for(Book b: bookList) {%>
		<tr> <!-- Book Import 안 하냐? -->
			<td><%=b.getBno()%></td>
			<td><%=b.getTitle()%></td>
			<td><%=b.getWriter()%></td>
			<td><%=b.getPublisher()%></td>
			<td><%=b.getPrice()%></td>
		</tr>
	<%}%>	
	</table>
</body>
</html>






