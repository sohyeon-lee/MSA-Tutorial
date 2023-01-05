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
	<h1>RestTemplate03</h1>
	<%= new Date() %><br><br>
	<!-- ex01 -->
	<!-- <a href="app1">RestTemplate 사용</a> -->

	<!-- ex02, ex03, ex04, ex05 -->
	<!-- <a href="app2/12">RestTemplate 사용</a> -->

	<a href="app3">WebClient 사용</a>
</body>
</html>