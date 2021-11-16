<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<form action="/ServerProgram/join.do">
		<h1>회원가입 폼</h1>
		<label>아이디</label>
		<input type="text" name='id'>
		<label>이름</label>
		<input type="text" name='id'>
		<input type="button" value="돌아가기" onclick="location.href='history.back()'"> 
	</form>
</body>
</html>