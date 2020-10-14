<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		border : 1px solid black;
		width: 80px;
		height: 30px;
		text-align: center;
	}
</style>

</head>
<body>
	<table >		
		<c:forEach var="i" begin="1" end="9" step="1" >
			<tr>	
				<c:forEach var="j" begin="2" end="9" step="1" >
			
					<td>${j } * ${i } = ${i*j} </td> 
				
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>