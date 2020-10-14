<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	List<MemberVO> memlist = (List<MemberVO>)request.getAttribute("memlist");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@include file ="/layout/commonLib.jsp" %>
</head>

<body>

<%@ include file="/layout/header.jsp" %>
<div class="container-fluid">
	<div class="row">
			
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>	
		</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

		<div class="row">
			<div class="col-sm-8 blog-main">
				<h2 class="sub-header">사용자</h2>
				<div class="table-responsive">
					<table class="table table-striped">		
						<tr>
							<th>사용자 아이디</th>
							<th>사용자 이름</th>
							<th>사용자 별명</th>
							<th>등록일시</th>
						</tr>
		<%-- 				<%for(int i =0; i<memlist.size();i++){ %> --%>
		<!-- 					<tr> -->
		<%-- 						<td><%=memlist.get(i).getUserId() %></td> --%>
		<%-- 						<td><%=memlist.get(i).getUsernm() %></td> --%>
		<%-- 						<td><%=memlist.get(i).getAlias() %></td> --%>
		<%-- 						<td><%=memlist.get(i).getReg_dt() %></td> --%>
								
		<!-- 					</tr> -->
		<%-- 				<%} %> --%>
						<c:forEach items="${memlist }" var="member">
							<tr>	
								<td>${member.userId }</td> 
								<td>${member.usernm }</td>
								<td>${member.alias }</td>
								<td>${member.reg_dt }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
		
				<a class="btn btn-default pull-right">사용자 등록</a>
		
				<div class="text-center">
					<ul class="pagination">
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
					</ul>
				</div>
			</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
