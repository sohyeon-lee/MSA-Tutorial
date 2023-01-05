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

	<a href="app1">리본사용(X): >> 8082</a><br>
	<a href="app2">리본사용(O): >> 8083, 8084</a><br>
</body>
</html>