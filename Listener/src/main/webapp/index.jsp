<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Index Page</h4>

	<%--通过链接跳转的是两个request请求，所以第二个页面无法获取到request请求中的参数--%>
	<a href="test.jsp">To Test Page</a>
	
	<%--<%--%>
		<%--//通过生命周期可以发现，用forward是在同一个request请求中，所以request请求中的参数才可以通用--%>
		<%--request.setAttribute("requestKey", "requestValue");--%>
	<%--%>--%>
		<%--<jsp:forward page="/test.jsp"></jsp:forward>--%>

	<br><br>

	<%--通过监听器看到，从头到尾只有一个请求，所以第二个页面可以获取request内的参数--%>
	<a href="TestServlet">TestServlet</a>
	
	
</body>
</html>