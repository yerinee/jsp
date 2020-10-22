<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(document).ready(function(){
		//initData();
		$('#zipcodeBtn').on('click', function(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            console.log(data)
		            $('#addr1').val(data.roadAddress);
		            $('#zipcode').val(data.zonecode);
		        }
		    }).open();

		})
	
		$('#regBtn').on('click', function(){
			// 안전하게 처리하기 위해 두개다 구현해야한다. _웹브라우저에서 찾으면 변경가능
			// client side (웹브라우저에서 보는화면)- validation
			// server side - validation
			// validation 로직은 일단 생략
			console.log("뭐지")
			$('#frm').submit();
	
		})
		
})

	
	
// 문서로딩시 실행	
function initData(){

		$('#userid').val('nyr');
		$('#usernm').val('예리니');
		$('#alias').val('rinee');
		$('#pass').val('1234');
		$('#addr1').val('대전 중구 중앙로 76');
		$('#addr2').val('영민빌딩 404호');
		$('#zipcode').val('34940');
	
}


	

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
				<form id ="frm" class="form-horizontal" role="form" 
					method ="POST" action="${cp }/memberUpdate" enctype="multipart/form-data">
				<!-- 1. 파일 업로드 경로를 이클립스내에 만든다.  -->
					<div class="form-group">
						<label for="realFilename" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img src="${cp }/profileImg?userid=${memberVo.userid}"/>											
							<input type="file" name="realFilename"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userid" name="userid" 
									placeholder="사용자 아이디" value="${memberVo.userid }" readonly>	
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="usernm" name="usernm" 
									placeholder="사용자 이름" value="${memberVo.usernm }">	
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias" 
									placeholder="사용자 별명" value="${memberVo.alias }">	
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass" 
									placeholder="사용자 비밀번호" value="${memberVo.pass }">	
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div  class="col-sm-10">
							<input id ="zipcodeBtn" type = "button" value="우편번호 찾기" class = "btn btn-default">
							<input type="text" class="form-control" id="zipcode" name="zipcode" 
									placeholder="사용자 우편번호" readonly value="${memberVo.zipcode }">	
						</div>
					</div>					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div  class="col-sm-10">
							<input type="text" class="form-control" id="addr1" name="addr1" 
									placeholder="사용자 주소" readonly value="${memberVo.addr1 }">	
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div  class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2" 
									placeholder="사용자 상세주소" value="${memberVo.addr2 }">	
						</div>
					</div>
					

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input id ="regBtn" type="button" class="btn btn-default" value ="수정 완료"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
