<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="custom" uri="/custom-tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标签属性</title>
</head>
<body>
	<!-- http://localhost:8081/jspCustomTag/demo3.jsp -->
	<custom:dbConnection password="root" url="jdbc:mysql://localhost:3306/sakila" driver="com.mysql.jdbc.Driver" sql="select * from user where id = ?" username="root" />
</body>
</html>