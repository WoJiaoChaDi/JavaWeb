<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" errorPage="/WEB-INF/Test_Error.jsp" %><!-- 如果当前页面出错，则自动会把这个页面当做相应页面：并且是转发的形式跳转 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int i = 10 / 0 ; %>
</body>
</html>