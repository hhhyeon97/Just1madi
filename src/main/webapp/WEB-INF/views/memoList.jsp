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
<title>메모 목록</title>
<style>
a {
	text-decoration: none;
	color: inherit;
}
#memobtn{
	margin-top: 100px;
}
</style>
</head>
<body>
	<div class="glassmorphism-container">
		<h2>Memo List</h2>
			<table>
				<thead>
					<tr>
						<!--<th>제목</th>-->
						<!--<th>내용</th>-->
					</tr>
				</thead>
				<tbody>
					<!-- 메모 목록 순회 -->
					<c:forEach var="memo" items="${memoList}">
						<tr>
							<td>${memo.title}</td>
							<!--<td>${memo.content}</td>-->
							<td>
								<!-- 수정 버튼 -->
								<!-- <a href="<c:url value='/memo/edit/${memo.memoId}' />">Edit</a>-->
								<input type="button" value="Edit" class="btn btn-dark"
								onclick="location='/memo/edit/${memo.memoId}';"> 
								</td>
								<td>
								<!-- 삭제 폼 -->
								<form method="post"
									action="<c:url value='/memo/delete/${memo.memoId}' />"
									style="display: inline;">
									<input type="submit" value="Delete" class="btn btn-dark"
										onclick="return confirm('정말 삭제하시나요?');" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" id="memobtn" value="메모" class="btn btn-dark"
				onclick="location='/memo/create';">
		</div>
</body>
</html>