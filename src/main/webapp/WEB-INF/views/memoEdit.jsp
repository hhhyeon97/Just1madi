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
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<title>메모 수정</title>
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

.form-group {
	margin-top: 20px;
	margin-bottom: 15px;
}

.form-group label {
	
	display: block;
	margin-bottom: 5px;
}

.form-group input,textarea {
	
	width: 80%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid rgba(206, 212, 218, 0.5);
	border-radius: 4px;
	background-color: rgba(255, 255, 255, 0.1);
	color: #495057;
	
	margin-bottom: 20px;
}
#savebtn, #listbtn{
	margin-right:10px;
}
#listbtn{
	width: 62px;
}
</style>
</head>
<body>
<div class="glassmorphism-container">
<h2>Edit Memo</h2>
<form method="post"  action="${pageContext.request.contextPath}/memo/edit/${memoId}">
	<div class="form-group">
    <label></label>
    <textarea name="content" rows="7">${memo.content}</textarea><br/>
	</div>
    <input type="submit" id="savebtn" class="btn btn-secondary" value="저장" />
    <input type="button" id="listbtn" class="btn btn-secondary" value="목록" onclick="location='/memo/list';"/>
</form>
</div>
</body>
</html>