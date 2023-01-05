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
	
	<a href="t1">링크1</a><br>
	<a href="app1/300">RestTemplate 사용 1(성공) </a><br>
	<a href="app1/2000">RestTemplate 사용 2(실패) </a><br>
</body>
</html>