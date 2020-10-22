<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

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

<script>
 $(document).ready(function(){
		$('#memberlist tr').on('click', function(){

// 			console.log("memberlist tr click");
			// data-userid --> data의 속성 이름  data의 값을 가져오기위해 사용하는 함수 data()
			var userid = $(this).data("userid")
			console.log("userid : " + userid);

			document.location ="/member?userid=" + userid;
			

		})

 })
</script>

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
		
						<tbody id = "memberlist"> <!-- tr태그를 전부 보내지 않고 tbody안에있는 내용만 나릴때 주로 사용 -->
							<c:forEach items="${memberList }" var="member">
								<tr data-userid="${member.userid }">	<!-- data는 userId의 값을 잠깐 저장을 해둘수 있다. -->
								
									<td>${member.userid }</td> 
									<td>${member.usernm }</td>
									<td>${member.alias }</td>
									
									<td><fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd"/></td>
	<%-- 								<td>${member.reg_dt }</td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<a href="${cp }/memberRegist" class="btn btn-default pull-right">사용자 등록</a>
				page : ${page }
				pages : ${pages }
				pageSize : ${pageSize }
											
				<div class="text-center">
					<ul class="pagination">	
						<c:forEach var="i" begin="1" end ="${pages }">
							<c:choose>
								<c:when test="${i == page}">
									<li class="active"><span>${i }</span></li>
								</c:when>
								<c:otherwise>                                                                                                                                                                                                                                                                                                                                   
<!-- 									<select id = "lines"> -->
<%-- 										<option value ="5" selected>${pageSize}</option> --%>
<!-- 										<option value ="7"> </option> -->
										
<!-- 										<option value ="10">10줄 보기</option> -->
<!-- 										<option value ="15">15줄 보기</option>								 -->
<!-- 									</select> -->
									<li><a href="${pageContext.request.contextPath }/MemberListServlet?page=${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>			
<%-- 						<li><a href="${pageContext.request.contextPath }/MemberListServlet?page=2">2</a></li> --%>
<%-- 						<li><a href="${pageContext.request.contextPath }/MemberListServlet?page=3">3</a></li> --%>
<!-- 						<li><a href="#">4</a></li> -->
<!-- 						<li><a href="#">5</a></li> -->
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>
