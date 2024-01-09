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
<!-- 사용자가 확대/축소를 할 수 있도록 허용 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 확대/축소 제어
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"> -->
<script type="text/javascript" src="resources/js/login.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>memoong</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/resources/images/favicon.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/images/favicon.png"
	type="image/x-icon">
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
	position: relative;
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
.cusbtn {
	border: 1px solid lightgray;
	border-radius: 5px;
	background-color: #fff;
	padding: 5px 10px;
	display: inline-block;
}
</style>
</head>
<body>
	<div class="glassmorphism-container">
		<form method="post" name="m" action="/login_ok">
			<h2>welcome memoong</h2>
			<%-- 실패 메시지가 있는 경우에만 표시 --%>
			<c:if test="${param.error == 'true'}">
				<div class="alert alert-danger">닉네임이나 비밀번호가 틀립니다!
				</div>
			</c:if>
			<div class="form-group">
				<label for="username">닉네임</label> <input type="text" id="username"
					name="username" required>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="form-group">
				<button type="submit" class="cusbtn" onclick="login_check()">로그인</button>
				&nbsp;&nbsp;&nbsp;
				<button type="button" class="cusbtn" onclick="location='/join';">회원가입</button>
			</div>
		</form>
	</div>
</body>
</html>