<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 수정</title>
</head>
<body>
<h2>Edit Memo</h2>

<form method="post"  action="${pageContext.request.contextPath}/memo/edit/${memoId}">
    <label>Title: </label>
    <input type="text" name="title" value="${memo.title}" /><br/>

    <label>Content: </label>
    <textarea name="content">${memo.content}</textarea><br/>

    <input type="submit" value="Save" />
</form>
</body>
</html>