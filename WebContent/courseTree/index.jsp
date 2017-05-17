<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="getAllCourse" method="post">
		<input type="submit" value="获取所有课程">
	</form>
	<br>
	<br>
	<form action="showTree" method="post">
		展示该课程的树：courseName: <input type="text" name="courseName" >
		<input type="submit" value="submit">
	</form>
	<br>
	<br>
	<form action="createTable" method="post">
		创建表：tableName:<input type="text" name="tableName">
		<input type="submit" value="submit">
	</form>
		<br>
		<br>
	insert into table ：
	<form action="insertChapter" method="post">
		tableName：<input type="text" name="tableName"><br>
		<!-- 待插入的章节名 -->chapterName : <input type="text" name="chapterName"><br>
		<!-- 所属的父节点 -->parentChapterName : <input type="text" name="p_chapterName"><br>
		<input type="submit" value="submit"> 
	</form>
	<br>
	<br>
	update chapter :
	<form action="updateChapter" method="post">
		tableName：<input type="text" name="tableName"><br>
		<!-- 旧章节名 -->olcChapterName : <input type="text" name="chapterName"><br>
		<!-- 新章节名 -->newChapterName : <input type="text" name="newChapterName"><br>
		<input type="submit" value="submit"> 
	</form>
	<br>
	<br>
	delete chapter：
	<form action="deleteChapter" method="post">
		tableName：<input type="text" name="tableName"><br>
		<!-- 待删除的章节名 -->chapterName : <input type="text" name="chapterName"><br>
		<input type="submit" value="submit"> 
	</form>
	<br>
	<br>
</body>
</html>