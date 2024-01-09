<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript" src="resources/js/join.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>회원가입</title>
<style>
.glassmorphism-container {
	background-color: rgba(255, 255, 255, 0.6);
	border-radius: 12px;
	backdrop-filter: blur(1px);
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	padding: 20px;
	max-width: 400px;
	width: 100%;
	text-align: center;
	top: 30px;
	position: relative;
}
.glassmorphism-container h2 {
	letter-spacing: 5px;
	margin-bottom: 30px;
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
#buttondiv {
	margin-top: 50px;
	text-align: center
}
#btn1, #btn2 {
	border: 1px solid lightgray;
	border-radius: 5px;
	background-color: #fff;
	padding: 5px 10px;
	display: inline-block;
}
#checkbtn:hover {
	background-color: #a6bfe0;
	border: 1px solid #a6bfe0;
}
#goLogin {
	margin-top: 25px;
}
#goLogin a {
	color: #a6bfe0;
	text-underline-offset: 5px;
}
</style>
</head>
<body>
	<div class="glassmorphism-container">
		<form name="m" method="post" action="join">
			<h2>회 원 가 입</h2>
			<div class="form-group">
				<label for="username">닉네임</label> <input type="text" id="username"
					name="username" required> <input type="button"
					value="닉네임체크" id="checkbtn" class="btn btn-dark"
					onclick="id_check();"> <br> <span id="idcheck"></span>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div id="buttondiv">
				<label for="btn1"></label> <input type="submit" value="가입" id="btn1"
					class="cusbtn" onclick="check()" />&nbsp;&nbsp;&nbsp; <label
					for="btn2"></label> <input type="reset" value="취소" id="btn2"
					class="cusbtn" onclick="document.m.reset(); m.username.focus();" />
			</div>
		</form>
		<div id="goLogin">
			<a href="/login">이미 회원이신가요 ?</a>
		</div>
	</div>
</body>
</html>