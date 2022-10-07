<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/doA.jsp </title>
</head>
<body>
	
	<h1> 
		WEB-INF/views/
		<span style="color: white; background-color: skyblue; font-size: 3em"> 🎇doA🎇</span>.jsp 
	</h1>
	
	<table border="1px solid black">
		<tr>
			<td>JSP request.getPara~~~</td>
			<td>name: <%=request.getParameter("name")%></td>
			<td>tel: <%=request.getParameter("tel")%></td>
		</tr>
		<tr>
			<td>EL {param.name/tel} </td>
			<td>name: ${param.name }</td>
			<td>tel: ${param.tel }</td>
		</tr>
		<tr>
			<td>EL {name/tel} 👍</td>
			<td>name: ${name }</td> 
			<td>tel: ${tel }</td> 
		</tr>
	</table>
	
	
</body>
</html>