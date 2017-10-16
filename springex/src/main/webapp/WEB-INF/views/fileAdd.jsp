<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>FileUpload Form</h2>
	<form method="post" enctype="multipart/form-data">
		<div>File Name : </div>
		<div><input name="fileTitle" type="text"></div>
		<div><input name="file" type="file"></div>
		<input type="submit" value="upload">
	</form>
</body>
</html>