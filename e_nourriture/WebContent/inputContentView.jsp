<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="mcontroller?action=inputContent">
사진>
<input type="file" name="imgfile"><br>
내용>
<input type="text" name="contents"><br>
작성자>
<input type="text" name="writer" value="<%= session.getAttribute("ID") %>" readonly>
<br>
판매물품>
<input type="text" name="product"><br>
판매처>
<input type="text" name="productStore"><br>
판매처 주소>
<input type="text" name="productStoreAddr"><br>
가격>
<input type="text" name="price"><br>
평점>
<input type="text" name="like"><br>

<input type="submit" value="등록">
</form>


</body>
</html>