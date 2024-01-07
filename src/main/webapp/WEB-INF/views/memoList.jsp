<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, 
  maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<title>메모 리스트</title>
<style>
h2,h3 {
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
    max-width: 500px; /* 최대 너비 설정 */
    width: 100%; /* 100%로 설정하여 부모 컨테이너에 맞게 유동적으로 변경 */
    min-height: 300px; /* 최소 높이 설정 */
    text-align: center;
    position: relative;
    overflow-y: auto; /* 내용이 많아지면 스크롤이 생기도록 설정 */
}
.glassmorphism-container h2,h3 {
	color: #a6bfe0;	
	margin-bottom: 15px;
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

.form-group input, textarea {
	width: 80%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid rgba(206, 212, 218, 0.5);
	border-radius: 4px;
	background-color: rgba(255, 255, 255, 0.1);
	color: #495057;
}

#memobtn {
	letter-spacing : 3px;
	position: relative;
	top: 20px;
	margin-top: 20px;
	cursor: pointer;
	margin-bottom: 30px;
}

#memobtn:hover{
	background-color:#a6bfe0;
	border:1px solid #a6bfe0;
}

a {
	text-decoration: none;
	color: inherit;
}

table {
	width: 100%;
	margin-bottom: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 15px;
}

td {
	padding: 20px;
	text-align: left;
}

#cusbtn {
	background-color: white;
	border: 1px solid lightgray;
	border-radius: 7px;
}
#cusbtn2 {
	background-color: white;
	border: 1px solid lightgray;
	border-radius: 7px;
}

#menuicon {
	position: relative;
	left: 210px;
	bottom: 80px;
	color: #a6bfe0;
	font-size: 24px;
}

#menuContainer {
	display: none;
	position: absolute;
	top: 62px; /* 메뉴가 위치할 상대적인 높이 조절 */
	right: 0;
	background-color: #fff; /* 메뉴 배경 색상 */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
	padding: 10px;
	border-radius: 10px;
}

#menuContainer a {
	display: block;
	margin-bottom: 2px;
	text-decoration: none;
	color: #333; /* 메뉴 텍스트 색상 */
	
	transition: color 0.4s; /* 색상 변경 시 부드러운 전환 효과 */
    padding: 8px; /* 링크의 내부 여백 설정 */

    /* 배경색과 마우스를 올렸을 때의 스타일 변경 */
    &:hover {
        color: #fff; /* 마우스를 올렸을 때의 텍스트 색상 */
        background-color: #a6bfe0; /* 마우스를 올렸을 때의 배경색 */
    }
}
/*
#menuContainer a:hover {
	background-color: lightgray;
}
*/
</style>
</head>
<body>

	<script>
document.addEventListener("DOMContentLoaded", function () {
    var menuContainer = document.getElementById("menuContainer");
    var menuButton = document.getElementById("menuButton");

    menuButton.addEventListener("click", function () {
        if (menuContainer.style.display === "none" || menuContainer.style.display === "") {
            menuContainer.style.display = "block";
        } else {
            menuContainer.style.display = "none";
        }
    });
});
</script>
	<div class="glassmorphism-container">
		<!--<h3><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAARxJREFUSEvVlNENwjAMRN1NYBOYBJgEmAQ2oZvAJtAnxVIanFxU1A8i5aOJes++2B5s5TWsrG+9gI2Z3cxsZ2avtK/T96gC7AEck3ipBehuZoCqSwGI+JH+viQxsjlMZ3wDObUyUQBsIQMXzyP1zLBpX0tBAZ6TDUS8TdHmOpxzTxbch+sXAILvpFrVUQD85x0ii87pnIfmHRZlkNvgFZM/MqL4Xy1XlQECHmkUIZEDXlym/uOqjaaatXmvLMIeHpldLh8Z+F/t5hoAQZoMa3pWtaMjQD4eWqMAONuzDCsqAnj3Nus7S6ucTbOuLgFd8yXwLK+yWVOWAB9usr4DiFs7G34loDXc1GOHw68EyOElKF//qz5QUcv7/wd8AKJNRBl0Vm5MAAAAAElFTkSuQmCC"/> ${pageContext.request.userPrincipal.name}</h3>-->
		<h2>Memo List</h2>
		<!--<span id="username">${loggedInUsername}</span>-->
		<!--<span id="username">${sessionScope.loggedInUsername}</span>-->
		<!--<a href="<c:url value='/logout' />">로그아웃테스트1</a>-->
		<div id="menuContainer">
			<a href="/memo/myProfile">정보수정</a> <a href="/custom-logout">logout</a>
		</div>
		<a href="javascript:void(0);" id="menuButton"> 
		<!--<img id="menuicon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAFtJREFUSEtjZKAxYKSx+QyjFhAM4QEJov9QZ8Esh/EJuhZNH5iLzQc0t4BYlxKlbkDigCiXEatoQOJgNJJRomdAUhHN44DmFhCbxIlSNyBxQJTLiFU06gOCIQUAArwMGUsaCXEAAAAASUVORK5CYII=" />
		-->
		<i id="menuicon" class='bx bx-menu'></i>
		</a>
		<table>
			<tbody>
				<!-- 메모 목록 순회 -->
				<c:forEach var="memo" items="${memoList}" varStatus="status">
					<tr>
						<td>
							<!--<a href="<c:url value='/memo/detail/${memo.memoId}'/>">${memo.content}</a>-->
							<a href="<c:url value='/memo/detail/${memo.memoId}'/>">${memo.shortContent}<hr></a>
							 <!-- <a href="#" class="memo-preview" data-memo-id="${memo.memoId}" data-toggle="modal" data-target="#memoModal">${memo.shortContent}</a> -->
						</td>
						<td><input type="button" id="cusbtn2" class="btn btn-white" value="Edit"
							onclick="location='/memo/edit/${memo.memoId}';"></td>
						<td>
							<form method="post"
								action="<c:url value='/memo/delete/${memo.memoId}' />"
								style="display: inline;">
								<input type="submit" id="cusbtn" class="btn btn-white" value="Delete"
									onclick="return confirm('정말 삭제하시나요?');" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="form-group">
			<input type="button" id="memobtn" value="memo" class="btn btn-secondary"
				onclick="location='/memo/create';">
		</div>
	</div>
</body>
</html>