<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>메모 리스트</title>
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
	height: 500px;
	text-align: center;
	position: relative;
}

.glassmorphism-container h2 {
	color: #343a40;
	margin-bottom: 30px;
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

.form-group input,textarea {
	
	width: 80%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid rgba(206, 212, 218, 0.5);
	border-radius: 4px;
	background-color: rgba(255, 255, 255, 0.1);
	color: #495057;
}
#memobtn{
	position: relative;
	top : 20px;	
	margin-top: 30px;
}

a {
	text-decoration: none;
	color: inherit;
}

table {
    width: 100%;
    margin-bottom: 20px; /* Adjust margin-bottom as needed */
    display:flex;
    justify-content: center;
    align-items: center;
  }
td {
    padding: 20px; /* Add padding for better spacing */
    text-align: left;
  }
#cusbtn{
	background-color: white;
	border : 1px solid lightgray;
	border-radius: 7px;
}
#cusbtn:hover{
	background-color: black;
	color: white;
}
</style>
</head>
<body>
	<div class="glassmorphism-container">
		<h2>Memo List</h2>
		<!--<span id="username">${loggedInUsername}</span>-->
		<!--<span id="username">${sessionScope.loggedInUsername}</span>-->
		<a href="<c:url value='/logout' />">로그아웃테스트1</a>
		<a href="/custom-logout">로그아웃테스트2</a>
		<!-- 메모가 없는 경우 -->
		<!--<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAFRJREFUSEtjZKAxYKSx+QzEWvAfh0MI6ieoAGrwqAUEo3o0iMBBhCsYCIYfviSMnExHLUAPKXDoDK8gwpdaRjMawbw0GkQDH0QEXYBLAbF1MtkWAAC++BQZuFCLQQAAAABJRU5ErkJggg=="/>-->
			<table>
				<tbody>
					<!-- 메모 목록 순회 -->
					<c:forEach var="memo" items="${memoList}">
						<tr>
							<td>${memo.title}</td>
							<!--<td>${memo.content}</td>-->
							<td>
								<!-- 수정 버튼 -->
								<!-- <a href="<c:url value='/memo/edit/${memo.memoId}' />">Edit</a>-->
								<input type="button" id="cusbtn"  value="Edit" 
								onclick="location='/memo/edit/${memo.memoId}';"> 
								</td>
								<td>
								<!-- 삭제 폼 -->
								<form method="post"
									action="<c:url value='/memo/delete/${memo.memoId}' />"
									style="display: inline;">
									
									<input type="submit" id="cusbtn"  value="Delete"
										onclick="return confirm('정말 삭제하시나요?');" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="form-group">
			<input type="button" id="memobtn" value="memo" class="btn btn-dark"
				onclick="location='/memo/create';">
		</div>
</div>		
</body>
</html>