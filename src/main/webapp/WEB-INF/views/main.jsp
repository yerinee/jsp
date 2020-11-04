<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

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
<%@include file ="/WEB-INF/views/layout/commonLib.jsp" %>

<style>
	td {
		border : 1px solid black;
		width : 200px;
		padding: 5px;
	}
	th{
		font-weight: bold;
		font-size: 1.2em;
		width : 200px;
		padding: 5px;
	}

</style>


</head>

<body>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>	
<!-- <nav class="navbar navbar-inverse navbar-fixed-top"> -->
<!-- 	<div class="container-fluid"> -->
	
<!-- 		<div class="navbar-header"> -->
<!-- 			<button type="button" class="navbar-toggle collapsed" data-toggle="co -->
<!-- 			llapse" data-target="#navbar" aria-expanded="false" -->
<!-- 				aria-controls="navbar"> -->
<!-- 				<span class="sr-only">Toggle navigation</span> <span -->
<!-- 					class="icon-bar"></span> <span class="icon-bar"></span> <span -->
<!-- 					class="icon-bar"></span> -->
<!-- 			</button> -->
<%-- 			<% --%>
<%-- 				MemberVO memberVo = (MemberVO)session.getAttribute("S_MEMBER"); -->
	

<!-- 			<a class="navbar-brand" href="#">JSP/SPRING -->
<%-- <%-- 				<c:if test= "${S_MEMBER != null} "> --%> 
<%-- <%-- 					[${S_MEMBER.userId}] --%>
<%-- <%-- 				</c:if> --%> 
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${S_MEMBER != null}">[${S_MEMBER.userId}]</c:when>			 --%>
<%-- 					<c:otherwise></c:otherwise> --%>
			
<%-- 				</c:choose> --%>
<%-- <%-- 			<a class="navbar-brand" href="#">JSP/SPRING [${S_MEMBER.userId}]</a> --%> 
<!-- 			</a> -->
		
<!-- 		</div> -->
<!-- 		<div id="navbar" class="navbar-collapse collapse"> -->
<!-- 			<ul class="nav navbar-nav navbar-right"> -->
<!-- 				<li><a href="#">Dashboard</a></li> -->
<!-- 				<li><a href="#">Settings</a></li> -->
<!-- 				<li><a href="#">Profile</a></li> -->
<!-- 				<li><a href="#">Help</a></li> -->
<!-- 			</ul> -->
<!-- 			<form class="navbar-form navbar-right"> -->
<!-- 				<input type="text" class="form-control" placeholder="Search..."> -->
<!-- 			</form> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </nav> -->
<div class="container-fluid">
	<div class="row">
			
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/WEB-INF/views/layout/left.jsp" %>	
		</div>

		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

			<div class="blog-header">
				<h1 class="blog-title">Main</h1>
				<p class="lead blog-description">Jsp / Spring.</p>
			</div>

			<div class="row">
			
				<div class="col-sm-8 blog-main">
			
					<div class="blog-post">
						<h2 class="blog-post-title">JSP</h2>
						<p class="blog-post-meta">
							2017.10.30, room 201
						</p>
			
						<p>jsp를 통한 웹 프로그래밍 학습</p>
					
						<hr>
						
						<h3>상세내역</h3>
						<p>JSP과정에서는 다음과 같은 내용을 학습한다.</p>
						<ul>
							<li>servlet 동작원리</li>
							<li>jsp와 servlet의 관계</li>
						
							<li>jsp 스크립틀릿 요소</li>
							<li>jsp action tag (standard)</li>
							<li>jstl</li>
							<li>db pooling</li>
							<li>페이지 모듈화</li>
						</ul>
					</div>
				</div>
				<!-- /.blog-main -->
			</div>	
		</div>
		
	</div>
</div>

</body>
</html>
