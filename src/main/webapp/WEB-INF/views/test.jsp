<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/test.jsp </title>
</head>
<body>
	
	<h1> 
		WEB-INF/views/
		<span style="color: white; background-color: skyblue; font-size: 3em"> 🍇test🍇</span>.jsp 
	</h1>
	
	<table border="1px solid black">
		<tr>
			<td>JSP request.getPara~~~</td>
			<td><%=request.getParameter("email")%></td>
		</tr>
		<tr>
			<td>EL {param.email} </td>
			<td>${param.email }</td>
		</tr>
		<tr>
			<td>EL {email} 👍 </td>
			<td>${email }</td> 
		</tr>
	</table>
	
	<br> <hr> <br>
	
	<table border="1px solid black">
		<tr>
			<td>EL {MemberVO} </td>
			<td>${MemberVO }</td>
			<td>대문자 ㄴㄴ</td> 
		</tr>
		<tr>
			<td>EL {memberVO} </td>
			<td>${memberVO }</td>
			<td>소문자 ㅇㅇ</td> 
		</tr>
		<tr>
			<td>EL {memberVO.userid} </td>
			<td>${memberVO.userid }</td> 
			<td></td>
		</tr>
		<tr>
			<td>EL {DBVO} </td>
			<td>${DBVO }</td> 
			<td></td>
		</tr>
		<tr>
			<td>EL {DBVO.userid} </td>
			<td>${DBVO.userid }</td> 
			<td></td>
		</tr>
	</table>
	
	
	
</body>
</html>