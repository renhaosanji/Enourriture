<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<form method="post" action="ucontroller?action=orderCancel" >
<body>
<tr>
		<td>orderNumber:</td>
		<td><input type="text" name="orderNumber"></td>
	</tr>
	<br>
	<tr>
		<td>userId:</td>
		<td><input type="text" name="userId"></td>
	</tr>
	<br>
	<tr>
		<td><input type="submit" value="주문취소"></td>
	</tr>
</body>
</html>