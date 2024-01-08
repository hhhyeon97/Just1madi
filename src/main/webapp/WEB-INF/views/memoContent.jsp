<%@ page import="org.springframework.format.datetime.DateFormatter" %>
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
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<title>메모 내용</title>
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
	max-width: 400px; /* 유동적인 폭을 제한하기 위해 max-width 추가 */
	width: 100%; /* 100%로 설정하여 부모의 폭에 맞추기 */
	padding: 20px;
	margin: 0 auto; /* 가운데 정렬을 위해 추가 */
	text-align: center;
	position: relative;
	margin-bottom: 50px;
}

.glassmorphism-container td {
	   white-space: pre-wrap; /* 공백은 유지하고 줄바꿈 처리 */
        word-wrap: break-word; /* 단어 단위로 줄바꿈 처리 */
	max-width: 300px; /* 원하는 최대 너비로 조절 */
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
	width: 80%; /* 100%로 설정하여 부모의 폭에 맞추기 */
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

#btn:hover {
	background-color: #a6bfe0;
	border: 1px solid #a6bfe0;
}

#mar {
	position: relative;
	bottom: 25px;
}
</style>
</head>
<body>
<div class="glassmorphism-container">
<h2>Memo Content</h2>
<table>
<tr>
<td id="mar">${time}</td>
</tr>
<tr>
<td>${content}</td>
</tr>
</table>
		<div class="form-group">
			<input type="button" id="btn" value="목록" class="btn btn-secondary"
				onclick="location='/memo/list';">
		</div>
</div>
</body>
</html>