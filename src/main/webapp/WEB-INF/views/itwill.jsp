<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/itwill.jsp </title>
</head>
<body>
	<h1> 
		WEB-INF/views/
		<span style="color: white; background-color: skyblue; font-size: 3em"> πΎitwillπΊ</span>.jsp 
	</h1>
	
	<!-- // =====  http://localhost:8080/web/doC?msg=helloBusanITWILL  μ΄λ κ² μ£Όμμ€μ μ¨λ³΄λ΄λ λλ΄~~ -->
	
	<table>
		<tr>
			<td>JSP</td>
			<td>: <%=request.getParameter("msg")%></td>
		</tr>
		<tr>
			<td>EL {param.msg} </td>
			<td>: ${param.msg }</td>
		</tr>
		<tr>
			<td>EL {msg} π </td>
			<td>: ${msg }</td> 
		<!-- 
			@ModelAttribute("msg") String msg μ μμμ λλ ,, μΆλ ₯ X μλλ°?!?! (μμ­ κ°μ²΄ λ€μ Έμ, μλ μ  κ°μ Έμμ μΆλ ₯νλ κ±°λκΉ)
			μ μ°λκΉ μΆλ ₯λλ€????  -->
		</tr>
	</table>
</body>
</html>