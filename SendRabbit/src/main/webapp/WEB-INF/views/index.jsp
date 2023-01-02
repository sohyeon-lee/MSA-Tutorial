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
	<h1>SendRabbit</h1>
	<%= new Date() %><br>
	<a href="t1">링크1</a><br><br>
	
	<!-- rabbitmq start -->
	<a href="t2">문자열 전송</a><br>
	<a href="t3">객체 전송</a><br><br>
	
	<!-- rabbitmq quickstart tutorial -->
	<a href="t4">tutorial 1 - basic</a><br>
	<a href="t5">tutorial 2 - work queues</a><br>
	<a href="t6">tutorial 3 - publish/subscribe</a><br><br>
	
	<!-- rabbitmq quickstart tutorial4 : Routing -->
	tutorial 4 - routing<br>
	<a href="t71">orange</a><br>
	<a href="t72">black</a><br>
	<a href="t73">green</a><br>
	<a href="t74">all</a><br><br>

	<!-- rabbitmq quickstart tutorial5 : Topics -->
	<a href="t8">tutorial 5 - topic</a><br>
</body>
</html>