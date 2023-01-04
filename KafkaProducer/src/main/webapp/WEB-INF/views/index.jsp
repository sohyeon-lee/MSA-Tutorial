<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h1>물류 관리</h1>
	
	<table border=1px solid; width: 100px; style="text-align:center;">
        <thead>
            <tr>
                <th width="10%">물류 번호</th>
                <th width="10%">물류 명</th>
                <th width="10%">가격</th>
                <th width="10%">수량</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach var="list" items="${products}">
			<tr>
	            <td>${list.pid}&nbsp;</td>
	            <td>${list.pname}</td>
	            <td>${list.price}</td>
	            <td>${list.stock}</td>
			</tr>
			</c:forEach>
	 	</tbody> 
 	</table>
 	<br>
	<input type="button" onClick="location.href='/products'" value = "조회"/>
	<br/><br/>

	<h1>물류 주문</h1>
	<form method = "post" action="order">
		번호 : <input type="text" name="pid" value=""/>
		제품이름 : <input type="text" name = "pname" value = ""/>
		수량 : <input type="text" name = "stock" value = ""/>
		<input type="submit" value = "주문"/><br/><br/>
	</form>

	<h1>물류 추가</h1>
	<form method = "post" action="product/insert">
		제품이름 : <input type="text" name = "pname" value = ""/>
		가격 : <input type="text" name="price" value=""/>
		수량 : <input type="text" name = "stock" value = ""/>
		<input type="submit" value = "추가"/><br/><br/>
	</form>
	
</body>
</html>