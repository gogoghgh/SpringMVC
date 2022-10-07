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
		<span style="color: white; background-color: skyblue; font-size: 3em"> 💾itwill📺</span>.jsp 
	</h1>
	
	<!-- // =====  http://localhost:8080/web/doC?msg=helloBusanITWILL  이렇게 주소줄에 써보내도 되넴~~ -->
	
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
			<td>EL {msg} 👍 </td>
			<td>: ${msg }</td> 
		<!-- 
			@ModelAttribute("msg") String msg 얘 없었을 때는 ,, 출력 X 였는데?!?! (영역 객체 뒤져서, 있는 애 가져와서 출력하는 거니까)
			얘 쓰니까 출력되네????  -->
		</tr>
	</table>
</body>
</html>