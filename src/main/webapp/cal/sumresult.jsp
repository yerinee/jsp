<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= session.getAttribute("start") %> 와
	<%= session.getAttribute("end") %> 사이값의 합: &nbsp;
	<%= session.getAttribute("sumResult") %>
</body>
</html>