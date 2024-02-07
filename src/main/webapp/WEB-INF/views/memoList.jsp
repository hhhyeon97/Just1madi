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
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="icon"
	href="<%=request.getContextPath()%>/resources/images/favicon.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/images/favicon.png"
	type="image/x-icon">
<title>메모 리스트</title>
<style>
body{
	background-color: white;
	background-image: none;
}
.glassmorphism-container {
    background-color: rgba(255, 255, 255, 0.6);
    border-radius: 12px;
    backdrop-filter: blur(1px);
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    padding: 20px;
    max-width: 500px; /* 최대 너비 설정 */
    width: 100%; /* 100%로 설정하여 부모 컨테이너에 맞게 유동적으로 변경 */
    /*min-height: 300px;*/ /* 최소 높이 설정 */
    text-align: center;
    position: relative;
    overflow-y: auto; /* 내용이 많아지면 스크롤이 생기도록 설정 */
    margin-top: 30px;
    margin-bottom: 30px;
    max-height:500px;
    
}
.glassmorphism-container h2{
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
	margin-top: 35px;
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

@media screen and (max-width: 768px){

#menuContainer {
	padding: 8px;
}

}
#menuicon {
	position: relative;
	left: 150px;
	bottom: 45px;
	color: #a6bfe0;
	font-size: 27px;
}
#menuContainer {
	display: none;
	position: absolute;
	top: 45px; /* 메뉴가 위치할 상대적인 높이 조절 */
	right: 10px;
	background-color: #fff; /* 메뉴 배경 색상 */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
	padding: 15px;
	border-radius: 10px;
}
#menuContainer a {
	display: block;
	margin-bottom: 2px;
	text-decoration: none;
	color: #333; /* 메뉴 텍스트 색상 */
	
	transition: color 0.3s; /* 색상 변경 시 부드러운 전환 효과 */
    padding: 8px; /* 링크의 내부 여백 설정 */

    /* 배경색과 마우스를 올렸을 때의 스타일 변경 */
    &:hover {
        color: #fff; /* 마우스를 올렸을 때의 텍스트 색상 */
        background-color: #a6bfe0; /* 마우스를 올렸을 때의 배경색 */
        border-radius: 4px;
    }
}

/* 아이콘과 텍스트 사이에 간격 추가 */
#menuContainer a:first-child {
	margin-top: 10px;
}
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
		<h2>Memo List</h2>
		<div id="menuContainer">
			<a href="/memo/myProfile">정보수정</a> <a href="/custom-logout">logout</a>
		</div>
		<a href="javascript:void(0);" id="menuButton"><i id="menuicon"
			class='bx bx-menu'></i>
		</a>
		<table>
			<tbody>
				<c:if test="${empty memoList}"> <!-- 메모리스트가 없을 때  -->
						<p style="color:gray;">memoong에 접속했습니다<br>‧˚⋆﻿⁽ '-' ⁾⋆﻿˚‧</p>
				</c:if>
				<c:if test="${not empty memoList}">
	
    <!-- 검색 폼
    <form method="get" action="/memo/search" class="form-inline mb-2">
        <div class="form-group">
            <input type="text" name="keyword" class="form-control" placeholder="검색어를 입력하세요">
        </div>
        <button type="submit" class="btn btn-secondary">검색</button>
    </form>
    <form method="get" action="">

    <c:if test="${not empty message}">
        <p style="color: gray;">${message}</p>
    </c:if>
  </form>
    <div class="form-group">
        <a href="/memo/list" class="btn btn-primary">전체 목록으로 돌아가기</a>
    </div>
  -->		
  
<!-- 전체 삭제 버튼 추가 -->
<div class="form-group">
    <form method="post" action="/memo/deleteAll">
        <input type="submit" class="btn btn-danger" value="전체 삭제" 
        onclick="return confirm('정말 모든 메모를 삭제하시겠습니까?');">
    </form>
</div>
  
  				
				<!-- 메모 목록 순회 -->
				<c:forEach var="memo" items="${memoList}" varStatus="status">
					<tr>
						<td><a href="<c:url value='/memo/detail/${memo.memoId}'/>">${memo.shortContent}</a>
						<hr>
						</td>
						<td><input type="button" id="cusbtn2" class="btn btn-white"
							value="Edit" onclick="location='/memo/edit/${memo.memoId}';"></td>
						<td>
							<form method="post"
								action="<c:url value='/memo/delete/${memo.memoId}' />"
								style="display: inline;">
								<input type="submit" id="cusbtn" class="btn btn-white"
									value="Delete" onclick="return confirm('정말 삭제하시나요?');" />
							</form>
						</td>
					</tr>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="form-group">
			<input type="button" id="memobtn" value="memo"
				class="btn btn-secondary" onclick="location='/memo/create';">
		</div>
	</div>
</body>
</body>
</html>