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
����>
<input type="file" name="imgfile"><br>
����>
<input type="text" name="contents"><br>
�ۼ���>
<input type="text" name="writer" value="<%= session.getAttribute("ID") %>" readonly>
<br>
�ǸŹ�ǰ>
<input type="text" name="product"><br>
�Ǹ�ó>
<input type="text" name="productStore"><br>
�Ǹ�ó �ּ�>
<input type="text" name="productStoreAddr"><br>
����>
<input type="text" name="price"><br>
����>
<input type="text" name="like"><br>

<input type="submit" value="���">
</form>


</body>
</html>