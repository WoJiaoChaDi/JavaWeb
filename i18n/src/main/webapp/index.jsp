<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--获取浏览器当前的语言--%>
	<%= request.getLocale()%>
	<br>

	<%
		Date date = new Date();
		request.setAttribute("date", date);
		request.setAttribute("salary", 12345.67);
	%>
	<%--Date: <%= new Date() %>， Salary：12345.67--%>

	<%--这种方式必须在fmt:bundle标签内--%>
	<fmt:bundle basename="i18n">
		<fmt:message key="date"/>：
		<fmt:formatDate value="${date}"></fmt:formatDate>，
		<fmt:message key="salary"/>：
		<fmt:formatNumber value="${salary}"></fmt:formatNumber>
	</fmt:bundle>
	<br>

	<%
		String code = request.getParameter("code");

		if(code != null){
			if("en".equals(code)){
				session.setAttribute("locale", Locale.US);
			}else if("zh".equals(code)){
				session.setAttribute("locale", Locale.CHINA);
			}
		}
	%>

	<c:if test="${sessionScope.locale != null }">
		<fmt:setLocale value="${sessionScope.locale }"/>
	</c:if>

	<%--这种方式，只要设置了，后面跟随的标签都是--%>
	<fmt:setBundle basename="i18n"/>
	<fmt:message key="date"/>：
	<fmt:formatDate value="${date}" dateStyle="LONG"></fmt:formatDate>，
	<fmt:message key="salary"/>：
	<fmt:formatNumber value="${salary}" type="currency"></fmt:formatNumber>

	<br><br>
	<a href="index.jsp?code=en">English</a>
	<a href="index.jsp?code=zh">中文</a>
</body>
</html>