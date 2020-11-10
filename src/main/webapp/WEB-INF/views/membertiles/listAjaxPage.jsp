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
	//해당 html이 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
	 $(document).ready(function(){
		// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다.
		memberListAjaxHTML(1);
		
			
		$('#memberlist').on('click','tr' , function(){
				// data-userid --> data의 속성 이름  data의 값을 가져오기위해 사용하는 함수 data()
				var userid = $(this).data("userid")
				console.log("userid : " + userid);

				document.location ="${cp}/member/memberAjaxPage?userid=" + userid;
				
		})			
		

 	})
 	
 	function memberAjax(){
		 	
		 $.ajax({url :"/member/memberAjaxPage",
				 data :{userid : userid},
				 method : "get",
				 success :function(data){				
					}
		 })
	}
 	
 	function memberListAjax(p){

		 $.ajax({url :"/member/listAjax",
				data :{page :p, pageSize :5},
				//data :"page=1&pageSize=5",
				//data :JSON.stringify({page :1, pageSize :5}), 
				//   --> 컨트롤러에서 @requestBody로 써야한다.   JSON <========> JAVA OBJECT
				method : "get",
				success :function(data){
//					alert(data)
					// memberList tbody 영역에 들어갈 html 문자열 생성
					var html = "";
					for(var i=0; i<data.memberList.length; i++){
	
	
						var member = data.memberList[i];
					
						html += "<tr data-userid='"+member.userid+"'>"
						html += "<td>" +member.userid+ "</td>"
						html += "<td>" +member.usernm+ "</td>"
						html += "<td>" +member.alias+ "</td>"

						// 클라이언트의 결과는 서버쪽에 할당하는 것이 가능한데 반대로는 불가능하다.
						html += "<td> "+ member.fmt_reg_dt +"</td>"
						html += "</tr>"
	
	
					}
	
					$('#memberlist').html(html);

					var html2 = "";
					for(var i=1; i<=data.pages; i++){

						if(i == data.pageVO.page){
							html2 += "<li class=\"active\"><span>"+i+"</span></li>"
						}else{
							html2 += "<li><a href=\"javascript:memberListAjax("+i+");\">"+i+"</a></li>";
						}
					}

// 					alert(html2)
					$('ul.pagination').html(html2);
					
				}
		 

		})


	}



 	function memberListAjaxHTML(p){

		 $.ajax({url :"/member/listAjaxHTML",
				data :{page :p, pageSize :5},
				//data :"page=1&pageSize=5",
				//data :JSON.stringify({page :1, pageSize :5}), 
				//   --> 컨트롤러에서 @requestBody로 써야한다.   JSON <========> JAVA OBJECT
				method : "get",
				success :function(data){					
					var html = data.split("$$$$$SEPERATOR$$$$$");
					$('#memberlist').html(html[0]);
	
					$('ul.pagination').html(html[1]);
					
				}
		 

		})


	}
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
						
					</tbody>
				</table>
			</div>
			
			<a href="${cp }/member/memberRegist" class="btn btn-default pull-right">사용자 등록</a>
			page : ${page }
			pages : ${pages }
			pageSize : ${pageSize }
										
			<div class="text-center">
				<ul class="pagination" >	
						

				</ul>
			</div>
			
			
		</div>
	</div>

</body>
</html>
