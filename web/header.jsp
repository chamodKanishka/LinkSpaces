<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession sessionLogin = request.getSession(false);
    if (sessionLogin != null) {
        if (sessionLogin.getAttribute("uid") == null) {
%>
<jsp:forward page="login.jsp"/>
<%
        }
    }
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/font-awesome/latest/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/main.css">
</head>
<body class="container-fluid">
<style>
    .headerText:hover {
        font-weight: bold;
    }
</style>