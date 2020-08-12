<%--
  Created by IntelliJ IDEA.
  User: Moraaa
  Date: 4/1/2019
  Time: 11:08 PM
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
%>
<html>
<head>
    <title>LinkSpaces: Connecting Individuals</title>
    <link rel="stylesheet" type="text/css" href="assets/css/landing.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

</head>
<body>
<div class="intro">
    <div class="inner">
        <div class="content" style="position: relative;left: 50%;transform: translateX(-50%)">
            <div class="row" style="margin-top: 300px">
                <div class="col-sm-12">
                    <h1 align="center">LinkSpaces</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="btns">
                        <button type="submit" class="btn1"><a href="/login.jsp" style="text-decoration: none;color: inherit">Log In</a></button>
                        <button type="submit" class="btn2"><a href="/views/register/register.jsp" style="text-decoration: none;color: inherit">Register</a></button>
                        <button type="submit" class="btn3" href="#">Visitor</button>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>


</body>
</html>
