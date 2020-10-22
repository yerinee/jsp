<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="<%= request.getContextPath()%>/el" method ="post">
		
		<%  
			String requestParam = "";
			String sessionParam = "";
			String applicationParam ="";
			
			if( request.getParameter("scope") != null){
	 			String scope = request.getParameter("scope");
			
				if(scope.equals("requestValue")){
					requestParam = "checked";					
				}else if(scope.equals("sessionValue")){
					sessionParam = "checked";
					
				}else if(scope.equals("applicatonValue")){
					applicationParam = "checked";
					
				}
			}
			
		%>

		request(request) 	: 
		<input type ="radio" name="scope" value ="requestValue" <%=requestParam %>/><br>
		
		session(request, session) 	: 
		<input type ="radio" name="scope" value ="sessionValue" <%=sessionParam %>/><br>
		
		application(request, session, application) : 
		<input type ="radio" name="scope" value ="applicatonValue" <%=applicationParam %>/><br>
		
		<button type ="submit">전송</button>
	</form>
	
	attr : ${attr } (page -> request -> session -> application ) <br>
	requestScope : ${requestScope.attr } <br>
	sessionScope: ${sessionScope.attr } <br>
	applicationScope: ${applicationScope.attr } <br><br>
	
	scope parameter : <%=request.getParameter("scope") %> <br>
	scope parameter : ${param.scope } <br>
	
	cookie : <%=request.getCookies() %> <br>
	cookie : ${cookie.userid.value } <br>
	
	rangers.brown : ${rangers.brown } <br>
	rangers.sally : ${rangers.sally } <br>
	
	list[인덱스] => MemberVO, list[인덱스].필드 <br>
	rangersList[0].userid : ${rangersList[0].userid } <br>
	rangersList[1] : ${rangersList[1] } <br>
	
	
</body>
</html>