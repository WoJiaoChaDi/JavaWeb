<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%-- 用session="false" 的时候，表示该JSP页面不需要创建session对象 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>Session Page</h4>

	<%
		//手动创建session
		HttpSession session = request.getSession(true);

		//session销毁
		//1.设置过期时间
		//session.setMaxInactiveInterval(10);
		//2.调用session销毁方法
		//session.invalidate();
		//3.当前web应用被卸载（但会有session的持久化问题）
        //持久化的内容在tomcat项目的发布目录下  比如此项目是 Listener/SESSIONS.ser
	%>

</body>
</html>