<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src = "${cp }/js/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function(){

		// 이벤트 등록
		$("#makeJsonBtn").on("click", function(){

			console.log("makeJsonBtn click");
			$('#jsonString').text("");
			
			// 1. json 객체 생성
			// 2. 문자열로 변경
			var a ={userid : $('#userid').val(), usernm : $('#usernm').val()};
			
			//JSON.stringify(a)은 문자열로 변환하라는 것이다.
			$('#jsonString').text(JSON.stringify(a));

			console.log($('#jsonString').text())
		})


		$('#callAjax').on('click', function(){
			
			// makeJsonBtn 클릭이벤트 강제 발생
			$('#makeJsonBtn').trigger('click');
				
			$.ajax({
						url : "/ajax/json",
						data : JSON.stringify({
							userid : $('#userid').val(),
							usernm : $('#usernm').val()
						}),
						contentType : "application/json; charset=utf-8",
						dataType : $('#dataType').val(), // 서버로부터 받기 희망하는 데이터 타입
						method : "post",
						success : function(data) {
							//console.log(data);
							$('#respJsonString').html("");

							if($('#dataType').val()=='json'){
								$('#respJsonString').html(JSON.stringify(data));
							}else{
								$('#respJsonString').html((new XMLSerializer()).serializeToString(data));
							}
						},
						error : function(res) {
							alert("실패");
						}
			});

		})

	})
</script>

</head>
<body>
	전송 json: <div id="jsonString"></div>
	응답 json: <div id="respJsonString"></div>
	userid: <input type="text" id="userid" name="userid" value="brown"/> <br>
	usernm: <input type="text" id="usernm" name="usernm" value="브라운"/> <br>
	<select id="dataType">
		<option value="json">json</option>
		<option value="xml">xml</option>
	</select><br>
	<button type ="button" id="makeJsonBtn">json문자열 생성</button> <br>
	<button type ="button" id="callAjax">ajax 전송</button> <br>
</body>
</html>