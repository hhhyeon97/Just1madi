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
<title>회원가입</title>
<style>
@font-face {
	font-family: 'NanumSquareRound';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff')
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

body {
	font-family: 'NanumSquareRound';
	/* background: rgb(174,205,238);
			background: radial-gradient(circle, rgba(174,205,238,1) 0%, rgba(182,184,246,1) 100%);
            */
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
	color: #343a40;
	letter-spacing: 5px;
	font-family: 'yg-jalnan';
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

.form-group button {
	position: relative;
	top: 165px;
	margin-bottom: 5px;
	z-index: 2;
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
	margin-top: 30px;
}
</style>
</head>
<body>
	<!--<span id="logotitle"><a href="/">just1madi</a></span>-->
	<div class="glassmorphism-container">
		<form name="m" method="post" action="join_ok">
			<h2>회원가입</h2>
			<div class="form-group">
				<label for="username">닉네임</label> <input type="text" id="username" name="username"
					required> <input type="button" value="닉네임중복체크"
					id="checkbtn" class="btn btn-dark" onclick="id_check();"> <br>
				<span id="idcheck"></span>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password" id="password"
					name="password" required>
			</div>
			<div id="buttondiv">
			<input type="submit" value="가입" class="btn btn-dark" />&nbsp;&nbsp;&nbsp;
			 <input type="reset" value="취소" class="btn btn-dark"/>
		</div>
		</form>
	</div>
</body>
</html>