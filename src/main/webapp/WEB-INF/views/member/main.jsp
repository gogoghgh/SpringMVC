<%@page import="com.itwillbs.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/member/main.jsp</title>
</head>
<body>
	<h1>views/member/<span style="font-size: 3em; background-color: salmon; color:white;">πmainπ</span>.jsp</h1>
	
	<c:if test="${loginVO == null }">
	<!-- μ¬μ©μ μ λ³΄ μλ€λ©΄~~ λ‘κ·ΈμΈ νμ΄μ§λ‘ λ³΄λ΄κΈ° -->
		<c:redirect url="/member/login" />
	</c:if>
	
	
	<h3>πβ¨πβ¨ ${loginVO.username } ( ${loginVO.userid } )λ νμν©λλ€ π»π»  </h3>
	<h3>${sessionScope.loginVO.userid }λ νμν©λλ€ π»  </h3>
	
 	<%
		MemberVO vo = (MemberVO) session.getAttribute("loginVO");
	%>
	<%=vo.getUserid() %> λ νμ΄λ£¨ (JSP) 
	
	<hr>
	 
	<!-- λ‘κ·Έμμ λ²ν΄ -->
	<input type="button" value="λ‘κ·Έμμ" onclick="location.href='/member/logout';"> <br>
	
	<a href="/member/logout"> λ‘κ·Έμμππ </a> <br>
	
	<a href="javascript:alert('λ°μ΄λ°μ΄ππ'); 
						location.href='/member/logout';"> (js)λ‘κ·Έμμππ </a>
	
	<hr>
	
	<a href="javascript:alert('μ‘°ννλ¬ κ°κ²μ₯'); 
						location.href='/member/info';"> νμ μ λ³΄ μ‘°ν </a>
	


</body>
</html>