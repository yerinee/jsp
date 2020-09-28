<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
		
	<%String str = "message"; %>	
	<%String str2 = ""; %>	
	<%String str3 = "hello"; %>	
<script>
	/* 서버 사이드 변수에 클라이언트 사이드 값을 대입하는 경우(X)
	   서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 안된다. */
	<%=str%> ='test';
<%-- 	<%=str2%> ='test'; --%>
// 	message = 'test';

	/* 클라이언트 사이드 변수에 서버 사이드 변수 값을 대입 
		서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 된다. */
	//	자바 스크립트에서는 <%=str3%>처럼 ""가 없는 상태로 들어오면 변수명으로 인식을 하기때문에 에러가 난다. 
	//	따라서 "<%=str3%>"처럼 ""를 붙여준다. 
	var msg = "<%=str3%>"
</script>


</body>
</html>