<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/member/insert.jsp</title>
</head>
<body>
	<h1>views/member/<span style="font-size: 3em; background-color: skyblue; color:white;">🤗insert🤗</span>.jsp</h1>
	
	<fieldset>
		<legend>회원 가입</legend>
		
<!-- 		<form action="/member/insertPro" method="post"> -->
		<form action="/member/insert" method="post">  
								<!--       ㄴ ==> MemberController_insertPOST() 메서드가 호출되겠구만~~~!! -->
	<!--      action="컨트롤러 주소/이동페이지 주소" (권장)
	          action="./이동페이지 주소"             (노 권장)
	          action="./insertPro"                     ㄴ이유: 상대 주소라서,, 정확하지 않음!! 
	          													위에처럼 다 적는 걸 권장합니데이  -->
			아이디: <input type="text" name="userid"><br>
			비이번: <input type="password" name="userpw"><br>
			이이름: <input type="text" name="username"><br>
			이메일: <input type="text" name="useremail"><br>
			<input type="submit" value="회원가입💝">
		</form>
		
	</fieldset>


</body>
</html>