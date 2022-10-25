<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert('${msg}');
		location.href="${root}/board/list";
	</script>
</body>
</html>