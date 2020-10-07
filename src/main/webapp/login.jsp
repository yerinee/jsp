<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <% Cookie[] cookies = request.getCookies(); --%>
<!--  	for(Cookie cookie : cookies){ 		
 				out.print(cookie.getName() + ": " + cookie.getValue() +"<br>");
 			}-->
		
<%-- %> --%>
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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">

  </head>
  <script type = "text/javascript" src="<%=request.getContextPath() %>/js/js.cookie-2.2.1.min.js"></script>
  <script src = "<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
  
  <script>	
	// 1. REMEMBERME 쿠키 값이 Y로 설정 되어있는지 확인
	// 2. 1번 조건 충족시
	// 	 2-1 Remember Me 체크박스를 체크 상태로 변경
	//	 2-2 USERNM 쿠키값을 확인하여 INPUT태그중
	// 	 	 inputEmail아이디 값을 쿠키값으로 설정
	// 3. 1번 미 충족시 => 별도의 처리 없음
	
	
	// singin 버튼이 클릭되었을 때 
	// 1. Remember Me 체크박스가 체크 되어 있으면
	//		2. REMEMBER 쿠키를 Y로 설정
	// 		3. USERNM 쿠키를 inputMail input태그에 입력된 값으로 설정
	//		4. form 태그에 대한 submit처리
	// 5. Remember Me 체크박스가 체크되어 있으면 
	//		6. REMEMBERME, USERNM 쿠키를 삭제

  
	$(function(){
		
		$('#button').on('click',function(){
			if($('input[type=checkbox]').prop("checked")){
				val = $('#inputEmail').val()		
				setCookie("REMEMBERME","Y")
				setCookie("USERNM",val)
			}else{
				deleteCookieValue("REMEMBERME")
				deleteCookieValue("USERNM")
			}

		 	$('form').submit();
			
// 			if(getCookieValue("REMEMBERME") == "Y"){
// 				console.log("remember")
// 				$('input[type=checkbox]').attr("checked","checked")
// 				$('#inputEmail').val(getCookieValue("USERNM"))
// 			}	
		})
		
		
		if($('input[type=checkbox]').prop("checked")){
			console.log("체크")
		}else{
			console.log("노체크")
		}
		  
	})
  	// 쿠키 확인
  	function getCookieValue(cookieName){

  		var cookies = document.cookie.split("; ")
  		var cookiess;
		res = "";

		
		for(i = 0; i < cookies.length;i++){

			cookiess = cookies[i].split("=");
			
			if(cookiess[0] == cookieName) {
				res = cookiess[1];
			}
		}
		
		return res;
		
  	}


	// 쿠키설정
	function setCookie(cookieName, cookieValue , expires){

		var today = new Date();
		
		// 현재날짜에서 미래로 + expires만큼 한 날짜 구하기
		today.setDate(today.getDate() + expires); //오늘 날짜에서 expires일을 더한것
						
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
		
		console.log(document.cookie);
	}

	// 쿠키 삭제 _ 해당쿠키의 expires속성을 과거날짜로 변경
	function deleteCookieValue(cookieName){

		setCookie(cookieName, "", -1);	
		
	}

	

  	
  </script>

  <body>



    <div class="container">

      <form+ class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name = "userId" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name ="password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="button">Sign in</button>
      </form>

    </div> <!-- /container -->
	
	
	
	
	
  </body>
</html>