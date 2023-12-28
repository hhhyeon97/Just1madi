<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 입력</title>
</head>
<body>
<form action="/memo/create_ok" method="post">
제목 <input type="text" name="title" id="title"><br><br>
내용 <textarea name="content" id="content"></textarea>
<input type="submit" value="저장">
<input type="button" value="목록" onclick="location='/memo/list';">
</form>
</body>
</html>