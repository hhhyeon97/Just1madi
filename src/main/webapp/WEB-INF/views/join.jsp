<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, 
  maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>  
<title>회원가입</title>
<style>

.glassmorphism-container {
	background-color: rgba(255, 255, 255, 0.6); /* 0.85*/
	border-radius: 12px;
	backdrop-filter: blur(10px);
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 400px;
	height: 450px;
	text-align: center;
	top: 30px;
	position: relative;
}

.glassmorphism-container h2 {
	/*color: #343a40;*/
	color: #a6bfe0;	
	letter-spacing: 5px;
	font-family: 'yg-jalnan';
	margin-bottom : 30px;
}

.login-form {
	margin-top: 10px;
}

.form-group {
	margin-bottom: 10px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
}

.form-group input {
	width: 70%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid rgba(206, 212, 218, 0.5);
	border-radius: 4px;
	background-color: rgba(255, 255, 255, 0.1);
	color: #495057;
}

#logotitle {
	font-family: 'yg-jalnan';
	text-align: center;
	font-size: 35px;
	top: 20px;
	position: fixed;
	height: 40px;
	margin-bottom: 20px;
}
#logotitle a {
	text-decoration: none;
	color: inherit;
}
#buttondiv {
	margin-top: 50px;
}


#btn1,#btn2{
	border : 1px solid lightgray;
	border-radius: 5px;
	background-color:#fff;
	padding :5px 10px;
}
/*
#btn1:hover{
	background-color:#a6bfe0;
}
#btn2:hover{
	background-color:#a6bfe0;
}
*/
</style>
</head>
<script>
function check() {
    if (m.username.value == 0) {
        alert("닉네임을 입력하세요!");
        m.username.focus();
        return false;
    } else if (m.password.value == 0) {
        alert("비밀번호를 입력하세요!");
        m.password.focus();
        return false;
    }
    else if {
		if ($("#idcheck").text() === '사용 가능한 닉네임입니다.') {
			/*alert("회원가입에 성공하였습니다!");*/
			return false;
		} else {
			alert("닉네임 중복검사를 먼저 진행해주세요.");
			return false;
		}
		
	}
}

function id_check(){
	$("#idcheck").hide();
	$username=$.trim($("#username").val());
	if($username.length < 4){
		$newtext='<font color="red" size="3"><b>닉네임은 4자 이상이어야 합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#username").val('').focus();
		return false;
	};
	if($username.length > 12){
		$newtext='<font color="red" size="3"><b>닉네임은 12자 이하이어야 합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#username").val('').focus();
		return false;
	};
	if(!(validate_userid($username))){
		$newtext='<font color="red" size="3"><b>닉네임은 영문소문자,숫자,_조합만 가능합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#username").val('').focus();
		return false;
	};
    $.ajax({
        type:"POST",   
        url:"idCheck", 
        data: {"username":$username},
        datatype:"int",
        success: function (data) {
      	  if(data==1){//중복 아이디가 있다면
      		$newtext='<font color="red" size="3"><b>중복 닉네임입니다.</b></font>';
      		$("#idcheck").text('');
        	$("#idcheck").show();
        	$("#idcheck").append($newtext);          		
          	$("#username").val('').focus();
          	 console.log("중복 닉네임 입니다!");
          	return false;
      	  }else{//중복 아이디가 아니면
      		$newtext='<font color="blue" size="3"><b>사용 가능한 닉네임입니다.</b></font>';
      		$("#idcheck").text('');
      		$("#idcheck").show();
      		$("#idcheck").append($newtext);
      		$("#password").focus();
      		console.log("중복 닉네임이 아닙니다!");
      	  }  	    	  
        },
    	  error:function(){
    		  alert("data error");
    	  }
      });//$.ajax
}




//정규표현식
function validate_userid($username)
{
var pattern= new RegExp(/^[a-z0-9_]+$/);//닉네임을 영문소문자와 숫자 와 _조합으로 처리
return pattern.test($username);
};



</script>
<body>


  <c:if test="${not empty message}">
        <div class="alert alert-success">
            <p>${message}</p>
        </div>
    </c:if>
    
    
	<!--<span id="logotitle"><a href="/">just1madi</a></span>-->
	<div class="glassmorphism-container">
		<form name="m" method="post" action="join">
			<h2>회 원 가 입</h2>
			<div class="form-group">
				<label for="username">닉네임</label> <input type="text" id="username" name="username" required>
			<input type="button" value="닉네임중복체크"
						id="checkbtn" class="btn btn-dark" onclick="id_check();">
			<br>
			<span id="idcheck"></span>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password" id="password"
					name="password" required>
			</div>
			<div id="buttondiv">
			<label for="btn1"></label>
			<input type="submit" value="가입" id="btn1" class="cusbtn"  onclick="check()" />&nbsp;&nbsp;&nbsp;
			<label for="btn2"></label>
			 <input type="reset" value="취소" id="btn2" class="cusbtn" onclick="document.m.reset(); m.username.focus();"/>
		</div>
		</form>
	</div>
</body>
</html>