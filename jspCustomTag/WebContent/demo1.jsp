<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="custom" uri="/custom-tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- http://localhost:8081/jspCustomTag/demo1.jsp?name=weineng -->
	<custom:skipBodyOrEvalBodyIncludeTag>
		<h3>中国</h3>
	</custom:skipBodyOrEvalBodyIncludeTag>
</body>
</html>