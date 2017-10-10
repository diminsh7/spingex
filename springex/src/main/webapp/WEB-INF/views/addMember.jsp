<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addMember</title>
</head>
<body>
	<h1>addMember</h1>
	<form action="./addMember" method="post"> <!-- 이 페이지 자체가 요청될 때는 get방식으로 sumit으로 값을 넘기면 같은 메소드 이름이지만 post방식으로 지정한 다른 메소드가 실행 된다 -->
		<table border="1">
			<tr>
				<td>Member ID</td>
				<td><input name="memberId" type="text"></td>
			</tr>
			<tr>
				<td>Member PW</td>
				<td><input name="memberPw" type="text"></td>
			</tr>
			<tr>
				<td>Member Name</td>
				<td><input name="memberName" type="text"></td>
			</tr>
		</table>
		<input type="submit" value="addMember">
	</form>
</body>
</html>