<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>home</h1>
	<%= new Date() %><br>
	<a href="t1">링크1</a><br><br>
	<a href="app1">RestTemplate 사용</a><br>
	
	<a href="app2">Feign 사용 (ex01, ex02, ex03)</a><br>
	<!-- hystrix(ex04) -->
	<a href="app3/20">Feign 사용 (성공)</a><br>
	<a href="app3/2000">Feign 사용 (실패)</a><br>
</body>
</html>