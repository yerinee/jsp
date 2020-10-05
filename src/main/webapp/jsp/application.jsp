<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("getSereverInfo() :" + application.getServerInfo() + "<br>");
		out.println("application.getContextPath() :" + application.getContextPath() + "<br>");
		out.println("application.getMajorVersion() :" + application.getMajorVersion() + "<br>");
		out.println("application.getMinorVersion() :" + application.getMinorVersion() + "<br>");
		
		out.print("<br>");
		out.print("web.xml에 설정 정보(초기화 파라미터 - initParameter)를 불러 올 수도 있다 <br>");
		String abUserId = application.getInitParameter("abUserId");
		out.println("abUserId : " + abUserId);
	%>
</body>
</html>