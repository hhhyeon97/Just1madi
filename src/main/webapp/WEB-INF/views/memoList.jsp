<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <!-- 기타 필요한 컬럼들 -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>