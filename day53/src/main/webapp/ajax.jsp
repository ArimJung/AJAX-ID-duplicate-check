<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 실습</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous">
</script> 
</head>
<body>

<div id="box">
	<input type="text" name="mid" id="mid">
	<button class="btn" onclick="check();">중복검사</button>
	<div id="result"></div>
</div>

<script type="text/javascript">
	function check(){
		var mid=$("#mid").val(); // id=mid의 value값
		$.ajax({
			type: 'GET', //어떤 방식으로 보낼지 "get, post"
			url: '${pageContext.request.contextPath}/check.do?mid='+mid, //어떤 요청을 하는지 -> mid라는 변수만들어서 사용자가 입력한 값을 확보한 상태 > DB한테 물어볼 예정 "mid라는 값이 DB에 이미 있어?" => DAO(M)로 가야함 > 이제 C가(서블릿) 작업을 할 차례구나! 
			data: {mid:mid},
			success: function(result){ // 성공했을 때
				// result 는 String
				// JS-1 : 모든데이터가 객체
				// JS-2 : 동적타이핑 지원
				console.log("로그1 ["+result+"]");
				if(result==1){ // 중복이 아님, 사용가능
					$("#result").text("사용 가능한 아이디입니다!");
					$("#result").css("color","blue");
				}else{ // 중복, 사용불가
					$("#result").text("사용 불가능한 아이디입니다!");
					$("#result").css("color","red");
				}
			},
			error: function(request, status, error){
				console.log("code: "+request.status);
				console.log("message: "+request.responseText);
				console.log("error: "+error);
			}
		});
	}
</script>

</body>
</html>