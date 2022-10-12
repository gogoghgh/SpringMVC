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
	<h1>views/member/<span style="font-size: 3em; background-color: salmon; color:white;">💐main💐</span>.jsp</h1>
	
	<c:if test="${loginVO == null }">
	<!-- 사용자 정보 없다면~~ 로그인 페이지로 보내기 -->
		<c:redirect url="/member/login" />
	</c:if>
	
	
	<h3>💝✨💝✨ ${loginVO.username } ( ${loginVO.userid } )님 환영합니다 🌻🌻  </h3>
	<h3>${sessionScope.loginVO.userid }님 환영합니다 🌻  </h3>
	
 	<%
		MemberVO vo = (MemberVO) session.getAttribute("loginVO");
	%>
	<%=vo.getUserid() %> 님 하이루 (JSP) 
	
	<hr>
	 
	<!-- 로그아웃 버턴 -->
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';"> <br>
	
	<a href="/member/logout"> 로그아웃🚀🚀 </a> <br>
	
	<a href="javascript:alert('바이바이👋👋'); 
						location.href='/member/logout';"> (js)로그아웃🚀🚀 </a>
	
	<hr>
	
	<a href="javascript:alert('조회하러 갈게욥'); 
						location.href='/member/info';"> 회원 정보 조회 </a>
	


</body>
</html>