
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2023/2/27
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h1><%= "Hello World!!!" %></h1><br>
<a href="hello-servlet">Hello Servlet</a>
<from>
    <span>New User Registration</span><br><br>
    UserName :<input type = "text" name = "name" required = "true"><br><br>
    Password :<input type = "password" name = "password" required = "true"><br><br>
    Email :<input type = "email" name = "email" required = "true"><br><br>
    <span>Gender</span>
    Male<input type = "radio" name = "password">
    Female<input type = "radio" name = "password"><br><br>
    Date of birth<input type = "date" pattern="yyyy-mm-dd" name = "Date of birth" required = "true"><br><br>
    <input type = "submit" value="register"><br><br>
</from>
<%@include file="footer.jsp"%>
