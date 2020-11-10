<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

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
	
	// client side에서는 서버사이드 변수나 값을 사용가능
	userid = "${param.userid}";
	memberAjax(userid);

	
	$('#editbtn').on('click', function(){
		a = $('#userId').text()
		console.log(a);		
		//document.location="/memberUpdate?userid=${memberVo.userid}"
	})

	$('#profileDownBtn').on('click', function(){
		document.location="${cp}/profileDownload?userid=${memberVo.userid}"
	})
	
});

function memberAjax(userid){
 	
	 $.ajax({url :"/member/memberAjaxhtml",
			 data :{userid : userid},
// 			 data :"userid?"+userid,
			 method : "get",
			 success :function(data){	

				 $("form.form-horizontal").html(data);	
			 }
	 })
}

</script>


<body>

		<form class="form-horizontal" role="form">

		</form>

</body>
</html>
