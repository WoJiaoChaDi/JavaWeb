<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>	<!-- 如果为false，则不立即创建session -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		HttpSession session = request.getSession(true);	//手动创建session
		out.println(session);
		out.print("<br>");
		
		//获取 Session 的最大时效, 默认为 30 分钟. 
		out.print(session.getMaxInactiveInterval());
		session.setMaxInactiveInterval(1800);
		session.invalidate();
	%>
	
</body>
</html>