<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/member/insert.jsp</title>
</head>
<body>
	<h1>views/member/<span style="font-size: 3em; background-color: skyblue; color:white;">π€insertπ€</span>.jsp</h1>
	
	<fieldset>
		<legend>νμ κ°μ</legend>
		
<!-- 		<form action="/member/insertPro" method="post"> -->
		<form action="/member/insert" method="post">  
								<!--       γ΄ ==> MemberController_insertPOST() λ©μλκ° νΈμΆλκ² κ΅¬λ§~~~!! -->
	<!--      action="μ»¨νΈλ‘€λ¬ μ£Όμ/μ΄λνμ΄μ§ μ£Όμ" (κΆμ₯)
	          action="./μ΄λνμ΄μ§ μ£Όμ"             (λΈ κΆμ₯)
	          action="./insertPro"                     γ΄μ΄μ : μλ μ£ΌμλΌμ,, μ ννμ§ μμ!! 
	          													μμμ²λΌ λ€ μ λ κ±Έ κΆμ₯ν©λλ°μ΄  -->
			μμ΄λ: <input type="text" name="userid"><br>
			λΉμ΄λ²: <input type="password" name="userpw"><br>
			μ΄μ΄λ¦: <input type="text" name="username"><br>
			μ΄λ©μΌ: <input type="text" name="useremail"><br>
			<input type="submit" value="νμκ°μπ">
		</form>
		
	</fieldset>


</body>
</html>