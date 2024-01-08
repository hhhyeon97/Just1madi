<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, 
  maximum-scale=1.0, minimum-scale=1.0">
  <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<title>회원 정보 수정</title>
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
	max-width: 400px; /* 유동적인 폭을 제한하기 위해 max-width 추가 */
    width: 100%; 
	text-align: center;
	position: relative;
}
.glassmorphism-container h2 {
	color: #a6bfe0;	
	margin-bottom: 30px;
}
.form-group {
	margin-top: 20px;
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
}

.form-group input, textarea {
	width: 80%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid rgba(206, 212, 218, 0.5);
	border-radius: 4px;
	background-color: rgba(255, 255, 255, 0.1);
	color: #495057;
}
table {
	width: 100%;
	margin-bottom: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 15px;
}

th {
	text-align: left;
	color: gray;
}

#btn1, #btn2 {
	background-color: white;
	border: 1px solid lightgray;
	border-radius: 7px;
}

#btn1:hover{
	background-color:#a6bfe0;
	border:1px solid #a6bfe0;
}
#btn2:hover{
	background-color:#a6bfe0;
	border:1px solid #a6bfe0;
}
</style>
</head>
<body>
<div class="glassmorphism-container">
<h2>비밀번호 변경</h2>
<form name="frm" method="post" action="/memo/myProfile_ok"
			onsubmit="return edit_check();">
			<table>
				<tr>
					<th>닉네임</th>
					<td>${username}</td>
				</tr>
				
				
				<tr>
					<th>새 비밀번호</th>
					<td><div class="form-group"><input type="password" name="password" id="password" size="14"/></div></td>
				</tr>
			
				<tr>
					<th>비밀번호 재확인</th>
					<td><div class="form-group"><input type="password" name="password2" id="password2"
						size="14"/>	</div></td>
				</tr>
			</table>
			<div>
				<input type="submit" id="btn1" class="btn btn-white" value="수정"/>
				 <input type="reset" id="btn2" class="btn btn-white" value="취소" onclick="location='/memo/list';" />
			</div>
		</form>
</div>

<script>
//userEdit.jsp 유효성 검증
function edit_check(){
	$password=$.trim($("#password").val());
	$password2=$.trim($("#password2").val());
	if($password == ""){
		alert("비밀번호를 입력하세요!");
		$("#password").val("").focus();
		return false;
	}
	if($password2 == ""){
		alert("비밀번호 확인을 입력하세요!");
		$("#password2").val("").focus();
		return false;
	}
	if($password != $password2){
		alert("비밀번호가 다릅니다!");
		$("#password").val("");//비번 입력박스를 초기화
		$("#password2").val("");
		$("#password").focus();
		return false;
	}
	
	 // 수정에 성공했을 때 알림창 추가
    alert("정보 수정이 완료되었습니다!\n새로운 비밀번호로 다시 로그인해주세요.");
	 
}//edit_check()

</script>
</body>
</html>