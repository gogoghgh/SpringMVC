<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/member/info.jsp</title>
</head>
<body>
	<h1>views/member/<span style="font-size: 3em; background-color: skyblue; color:white;">πinfoπ</span>.jsp</h1>
	
	${userVO } <br>
	
	<fieldset>
		<legend>μΈ νλ μ λ³΄</legend>
		
		<form action="/member/insert" method="post">  
			μμ΄λ: <input type="text" name="userid" value="${userVO.userid }"><br>
			λΉμ΄λ²: <input type="password" name="userpw" value="${userVO.userpw }"><br>
			μ΄μ΄λ¦: <input type="text" name="username" value="${userVO.username }"><br>
			μ΄λ©μΌ: <input type="text" name="useremail" value="${userVO.useremail }"><br>
			κ°μμΌ: <input type="text" name="regdate" value="${userVO.regdate }"><br>
			μμ μΌ: <input type="text" name="updatedate" value="${userVO.updatedate }"><br>
<!-- 			<input type="submit" value="νμκ°μπ"> -->
		</form>
		
	</fieldset>
	
	<hr> 
	
		<h3> <a href="javascript:alert('λ©μΈμΌλ‘'); 
						location.href='/member/main';"> λ©μΈμΌλ‘ κ³ κ³ λ§πͺπͺ </a> </h3>


</body>
</html>