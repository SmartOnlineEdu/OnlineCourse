<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>file upload page</title>
</head>
<body>
<h2>file upload page</h2>
<form action="upload.action" method="post" enctype="multipart/form-data">
	<input type="file" name="upload"><br>
	<input type="submit" value="submit">
</form>

</body>
</html>