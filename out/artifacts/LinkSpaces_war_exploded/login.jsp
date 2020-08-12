<%--
  Created by IntelliJ IDEA.
  User: Moraaa
  Date: 4/5/2019
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession sessionLogin = request.getSession(false);
    if (sessionLogin != null) {
        if (sessionLogin.getAttribute("uid") != null) {
%>
<jsp:forward page="views/home/home.jsp"/>
<%
        }
    }

    String error = "";
    if (request.getParameter("error") != null) {
        error = request.getParameter("error");
    }
%>
<html>
<head>
    <title>Log into LinkSpaces</title>
    <link href="/assets/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="login">
    <form class="box" action="/login" method="post">
        <h1>Login</h1>
        <input type="text" name="username" placeholder="Username">
        <input type="password" name="password" placeholder="Password">
        <input type="submit" name="" value="Login">
        <a href="/views/register/register.jsp"><input type="button" name="" value="Register Here"></a>
        <%
            if (error.equals("error")) {
        %>
        <div style="border: 1px solid red;border-radius: 20px;padding: 10px;color: red">Invalid username or password
        </div>
        <%
            }
        %>
    </form>
</div>


</body>
</html>
