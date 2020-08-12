<%--
  Created by IntelliJ IDEA.
  User: tungsten242
  Date: 3/25/19
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../assets/css/main1.css" rel="stylesheet" type="text/css"/>
    <script src="../../controller/validate.js"></script>
    <title>Register</title>
</head>
<body>
    <div id="container">
    <div id="contentbox">
    <p class="contenthead">Register as an Industrial Entity</p>
    <form id="regform" action="/register" method="POST" onsubmit="return validateIndustrial()">
        
        <hr/>
        <p class="inputlabel">Organization Name:</p>
        <input class="inputfield" type="text" name="org" id="org" required/>
        
        <p class="inputlabel">Organization Type:</p>
        <input class="inputfield" type="text" name="orgtype" id="orgtype" required/>
        
        <p class="inputlabel">Website URL:</p>
        <input class="inputfield" type="text" name="weburl" id="weburl" required/>

        <hr/>
        <p class="inputlabel">Username:</p>
        <input class="inputfield" type="text" name="uname" id="uname" required/>

        <p class="inputlabel">E-mail:</p>
        <input class="inputfield" type="email" name="email" id="email" required/>

        <p class="inputlabel">Password:</p>
        <input class="inputfield" type="password" name="pwd" id="pwd" required/>
        
        <p class="inputlabel">Repeat Password:</p>
        <input class="inputfield" type="password" name="rptpwd" id="rptpwd" required/>
        
        <input class="inputfield" type="hidden" name="type" value="industrial"/>
        <hr/>
        <!--<input class="btntype2" type="reset" value="Reset"/>-->
        <input class="btntype2" type="submit" value="Register"/>
        
    </form>
    </div>
    </div>
</body>
</html>
