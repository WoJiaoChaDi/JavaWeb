<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>AAA PAGE</h4>
	<!--  静态包含（源码级包含）：servlet生成的时候，只有一个jsp文件  -->
	<!-- 在a.jsp中包含b.jsp -->
	<%
		String str = "abcdefg";
	%>
	<%@include file="b.jsp"%>
</body>
</html>