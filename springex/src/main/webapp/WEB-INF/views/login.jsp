<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Form</h2>
	<form action="./login" method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input name="memberId" type="text"></td>
				
			</tr>
			<tr>
				<td>PW</td>
				<td><input name="memberPw" type="password"></td>
			</tr>
		</table>
		<input type="submit" value="login">
	</form>
</body>
</html>