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

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>


<script>
 $(document).ready(function(){
		$('#memberlist tr').on('click', function(){

// 			console.log("memberlist tr click");
			// data-userid --> data의 속성 이름  data의 값을 가져오기위해 사용하는 함수 data()
			var userid = $(this).data("userid")
			console.log("userid : " + userid);

			document.location ="${cp}/member/member?userid=" + userid;
			

		})

 })
</script>


<body>
	
	<div class="row">
	tiles : memberlistContents.jsp
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
	
					<tbody id = "memberlist"> <!-- tr태그를 전부 보내지 않고 tbody안에있는 내용만 나릴때 주로 사용 -->
						<c:forEach items="${memberList }" var="member">
							<tr data-userid="${member.userid }">	<!-- data는 userId의 값을 잠깐 저장을 해둘수 있다. -->
							
								<td>${member.userid }</td> 
								<td>${member.usernm }</td>
								<td>${member.alias }</td>
								
								<td><fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<a href="${cp }/member/memberRegist" class="btn btn-default pull-right">사용자 등록</a>
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
								<li><a href="${pageContext.request.contextPath }/member/memberlist?page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>			

				</ul>
			</div>
		</div>
	</div>

</body>
</html>
