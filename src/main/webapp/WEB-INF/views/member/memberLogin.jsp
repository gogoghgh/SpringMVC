<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/member/memberLogin.jsp</title>
</head>
<body>
	<h1>views/member/<span style="font-size: 3em; background-color: skyblue; color:white;">🥰memberLogin🥰</span>.jsp</h1>
	
	<fieldset>
		<legend> 로 그 인 </legend>
			<form action="/member/loginPro" method="post">
				아이디: <input type="text" name="userid"> <br>
				비이번: <input type="password" name="userpass"> <br>
				<input type="submit" value="로그인">
			</form>
	</fieldset>

</body>
</html>