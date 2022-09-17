<%@page import="model.Player"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<%
		List<Player> playerList = (List<Player>)request.getAttribute("playerList");
	%>
	<table border="1">
		<tr>
			<th>no.</th>
			<th></th>
			<th>ۼ</th>
			<th>ǻ</th>
			<th></th>
		</tr>
	<%for(Player p: playerList) {%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getBacknumber()%></td>
			<td><%=p.getTeam()%></td>
		</tr>
	<%}%>	
	</table>
</body>
</html>

