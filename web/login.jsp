
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2023/2/27
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h1> Login</h1>
<%
    if(!(request.getAttribute("message") == null)){
        out.println(request.getAttribute("message"));
    }
%>
<from method="post" action="login">
    UserName :<input type = "text" name = "username"><br>
    Password :<input type = "password" name = "password"><br>
    <input type = "submit" value="Submit"><br>
</from>
<%@include file="footer.jsp"%>
