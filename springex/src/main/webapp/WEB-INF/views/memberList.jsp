<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member List</title>
</head>
<body>
	<h2>Member List</h2>
	<table border = "1">
		<tr>
			<th>NO</th>
			<th>ID</th>
			<th>NAME</th>
		</tr>
		<c:forEach var="member" items="${mlist}">
			<tr>
				<td>${member.memberNo}</td>
				<td>${member.memberId}</td>
				<td>${member.memberName}</td>
			</tr>	
		</c:forEach>	
	</table>
</body>
</html>