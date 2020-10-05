<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method ="POST" action ="<%=request.getContextPath()%>/MulServlet">
		<label>Start : </label>
		<input type = "text" name = "start" id ="start" value =""><br>
		<label>End : </label>
		<input type = "text" name = "end" id ="end" value =""><br>
		<input type ="submit" value = "계산">
	</form>
</body>
</html>