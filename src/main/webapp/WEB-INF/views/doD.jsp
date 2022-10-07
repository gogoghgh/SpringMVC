<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/doD.jsp </title>
</head>
<body>
	
	<h1> 
		WEB-INF/views/
		<span style="color: white; background-color: skyblue; font-size: 3em"> 🎇🎃doD🎃🎇</span>.jsp 
	</h1>
	
	<table border="1px solid black">
		<tr>
			<td>JSP request.getPara~~~</td>
			<td><%=request.getParameter("id")%></td>
<%-- 			<td>tel: <%=request.getParameter("tel")%></td> --%>
		</tr>
		<tr>
			<td>EL {param.id} </td>
			<td>${param.id }</td>
<%-- 			<td>tel: ${param.tel }</td> --%>
		</tr>
		<tr>
			<td>EL {id} 👍 </td>
			<td>${id }</td> 
<%-- 			<td>tel: ${tel }</td>  --%>
		</tr>
	</table>
	
	
</body>
</html>