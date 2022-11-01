<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ${pageContext.request.contextPath} -->
<head>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	
	var cnt = 1;
	
	// 파일 업로드 버턴 클릭 시 -> 파일 입력창을 #div_file에 추가(append)하는 동작
	function addFile(){
// 		alert("클릭하셨네염🌈");
		$('#div_file').append("<br> <input type='file' name='file"+cnt+"'/>");// append()
												// name = file1, file2, file3,,,,,  
		cnt++;
		
	}// addFile()
	
$(document).ready(function(){
// 	alert("jquery 준비 완 🌈");
	
}); // jquery ready
</script>
</head>
<body>
	<h1> 
		views/
		<span style="color: white; background-color: skyblue; font-size: 2em"> 🧸🧸uploadForm🎇🌈</span>.jsp 
	</h1>

<fieldset>
	<form action="./upload" method="post" enctype="multipart/form-data">
		아이디: <input type="text" name="id"> <br>
		이메일: <input type="text" name="email"> <br>
		<hr>
		<input type="button" value="파일 업로드 추가" onclick="addFile();"><br>
		<!-- 업로드 추가 버튼 누를 때마다, 파일 업로드 되도록~~ -->
		<div id="div_file" style="border: 1px solid black;">
			<!-- <input type="file" name="file"> -->
		</div>
		
		<input type="submit" value="업로드">
	</form>


</fieldset>



</body>