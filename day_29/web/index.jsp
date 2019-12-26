<%@ page import="com.atguigu.javaweb.Person" %><%--
  Created by IntelliJ IDEA.
  User: wumiao
  Date: 2019/12/26
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$

    <%
      Person person = new Person();
      System.out.println(person.Hello());
    %>
  </body>
</html>
