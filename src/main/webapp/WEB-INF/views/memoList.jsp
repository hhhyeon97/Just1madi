<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 목록</title>
</head>
<body>
	<h2>Memo List</h2>

	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<!-- 메모 목록 순회 -->
			<c:forEach var="memo" items="${memoList}">
				<tr>
					<td>${memo.title}</td>
					<td>${memo.content}</td>
				<td>
					<!-- 수정 버튼 -->
					 <a href="<c:url value='/memo/edit/${memo.memoId}' />">Edit</a>
				  <!-- 삭제 폼 -->
            <form method="post" action="<c:url value='/memo/delete/${memo.memoId}' />" style="display: inline;">
                <input type="submit" value="Delete" onclick="return confirm('정말 삭제하시나요?');"/>
            </form>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" value="메모" onclick="location='/memo/create';">
</body>
</html>