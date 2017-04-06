<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<form method="post" action="ucontroller?action=order" >
<body>

	<br>
	<tr>
		<td>userId:</td>
		<td><input type="text" name="userId"></td>
	</tr>
	<br>
	<tr>
		<td>productName:</td>
		<td><input type="text" name="productName"></td>
	</tr>
	<br>
	<tr>
		<td>orderCount:</td>
		<td><input type="text" name="orderCount"></td>
	</tr>
	<br>
	<tr>
		<td>Address:</td>
		<td><input type="text" name="address"></td>
	</tr>
	<br>
	<tr>
		<td>orderTime:</td>
		<td><input type="text" name="orderTime"></td>
	</tr>
	<br>
	<tr>
		<td><input type="submit" value="주문이야"></td>
	</tr>
	<br>
	<tr>
		<td colspan=2><input type="button" value="모르겠다" onclick="location.href='joinView.jsp'"></td>
	</tr>
</body>
</html>