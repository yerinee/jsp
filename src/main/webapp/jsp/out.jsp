<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<String> rangerlist = (List<String>)request.getAttribute("rangerlist");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for(String list : rangerlist){
			out.write(list);
			
// 		for(int i = 0; i<rangerlist.size();i++){	
	
// 		out.write(rangerlist.get(i));
	%>
		<br>
	<%
		}
	%>
</body>
</html>