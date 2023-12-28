<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>just1madi</title>
<style>
@font-face {
	font-family: 'Cafe24Ohsquare';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Cafe24Ohsquare.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
@font-face {
    font-family: 'yg-jalnan';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
	font-family: 'NanumSquareRound';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: 'NanumSquareRound';
	background-image: url("/resources/images/img04.jpg");
	background-position: 50% 50%;
	background-repeat: no-repeat;
	background-size: cover;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

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
	color: #343a40;
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
		   alert("로그인 아이디를 입력하세요!");
	      	m.username.focus();
	       return false;
	 }
	 else if(m.password.value==""){
		   alert("비밀번호를 입력하세요!");
	      	m.password.focus();
	       return false;
	 }
 }
</script>

<div class="glassmorphism-container">
		<form method="post" name="m" action="login_ok">
			<h2>welcome just1madi !</h2>
			<div class="form-group">
				<label for="username">닉네임</label> <input type="text" id="username" name="username">
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password" id="password" name="password">
			</div>
		<div class="form-group">
			<button type="submit" class="btn btn-dark" onclick="login_check()">로그인</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-dark"
				onclick="location='/join';">회원가입</button>
		</div>
		</form>
</div>


</body>
</html>