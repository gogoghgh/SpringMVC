<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/member/info.jsp</title>
</head>
<body>
	<h1>views/member/<span style="font-size: 3em; background-color: skyblue; color:white;">🌞info🌞</span>.jsp</h1>
	
	${userVO } <br>
	
	<fieldset>
		<legend>울 횐님 정보</legend>
		
		<form action="/member/insert" method="post">  
			아이디: <input type="text" name="userid" value="${userVO.userid }"><br>
			비이번: <input type="password" name="userpw" value="${userVO.userpw }"><br>
			이이름: <input type="text" name="username" value="${userVO.username }"><br>
			이메일: <input type="text" name="useremail" value="${userVO.useremail }"><br>
			가입일: <input type="text" name="regdate" value="${userVO.regdate }"><br>
			수정일: <input type="text" name="updatedate" value="${userVO.updatedate }"><br>
<!-- 			<input type="submit" value="회원가입💝"> -->
		</form>
		
	</fieldset>
	
	<hr> 
	
		<h3> <a href="javascript:alert('메인으로'); 
						location.href='/member/main';"> 메인으로 고고링🪂🪂 </a> </h3>


</body>
</html>