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
<title>memoong</title>
<style>
h2 {
	font-family: 'yg-jalnan';
	letter-spacing: 5px;
	margin-bottom: 20ppx;
}

.glassmorphism-container {
	background-color: rgba(255, 255, 255, 0.6);
	border-radius: 12px;
	backdrop-filter: blur(10px);
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 400px;
	height: 400px;
	text-align: center;
	position: relative;
}

.glassmorphism-container h2 {
	color: #a6bfe0;
}

.login-form {
	margin-top: 20px;
}

.form-group {
	margin-top: 20px;
	margin-bottom: 15px;
}

.form-group label {
	
	display: block;
	margin-bottom: 5px;
}

.form-group input {
	
	width: 80%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid rgba(206, 212, 218, 0.5);
	border-radius: 4px;
	background-color: rgba(255, 255, 255, 0.1);
	color: #495057;
}
.form-group button {
	margin-top: 20px;
}
</style>
</head>
<body>
<script>
 function login_check(){
	 if(m.username.value==""){
		   alert("닉네임을 입력하세요!");
	      	m.username.focus();
	       return false;
	 }
	 else if(m.password.value==""){
		   alert("비밀번호를 입력하세요!");
	      	m.password.focus();
	       return false;
	 }
	 else {
		alert("어서오세요 ⌯'▾'⌯")	;
		document.m.submit();
		return true;
	 }
 }
 
 
//알림 메시지를 띄우는 함수
 function showAlert(message) {
     alert(message);
 }

 // 서버에서 전달한 errorMessage가 비어있지 않다면 알림창 띄우기
 $(document).ready(function() {
     var errorMessage = "${errorMessage}";

     if (errorMessage) {
         showAlert(errorMessage);
     }
 });
</script>
<div class="glassmorphism-container">
		<form method="post" name="m" action="/login">
			<h2>welcome memoong</h2>
			<div class="form-group">
				<label for="username">닉네임</label> <input type="text" id="username" name="username" required>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password" id="password" name="password" required>
			</div>
		<div class="form-group">
			<button type="submit" class="btn btn-dark" onclick="showAlert()">로그인</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-dark"
				onclick="location='/join';">회원가입</button>
		</div>
		</form>
</div>


</body>
</html>