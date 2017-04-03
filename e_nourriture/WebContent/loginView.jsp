<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="controller?action=login" >
<table>
	<tr>
		<td>ID:</td>
		<td><input type="text" name="ID"></td>
	</tr>
	<tr>
		<td>password:</td>
		<td><input type="text" name="password"></td>
	</tr>
	<tr>
		<td colspan=2><input type="submit" value="submit"></td>
	</tr>
	<tr>
		<td colspan=2><input type="button" value="회원가입" onclick="location.href='joinView.jsp'"></td>
	</tr>
</table>
</form>
</body>
</html>