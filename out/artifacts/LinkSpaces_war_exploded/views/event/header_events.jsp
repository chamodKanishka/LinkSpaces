<jsp:include page="../../header.jsp"/>

<div class="row" style="background-color: #d3a308;color: #795d04;font-size: 20px;padding: 10px;text-align: center">
    <div class="col-sm-3" style="text-align: left;font-weight: bold"><span
            style="border-right: 2px solid #795d04;padding-right: 50px;padding-left: 20px">Events</span></div>
    <div class="col-sm-2"><a href="../../index.jsp" style="text-decoration: none;color: black">
        <a href="/views/home/home.jsp?path=home" style="text-decoration: none;color: black"><span
                class="headerText">Home</span></a></div>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("events") ? "style=\"font-weight: bold\"" : "" : ""%>>
        <a href="events.jsp?path=events" style="text-decoration: none;color: black"><span
                class="headerText">Find Event</span></a></div>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("myevents") ? "style=\"font-weight: bold\"" : "" : ""%>>
        <a href="myevents.jsp?path=myevents" style="text-decoration: none;color: black"><span class="headerText">My Events</span></a>
    </div>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("addevents") ? "style=\"font-weight: bold\"" : "" : ""%>>
        <a href="addevents.jsp?path=addevents" style="text-decoration: none;color: black"><span class="headerText">Add Event</span></a>
    </div>
    <div class="col-sm-1">
        <form action="/logout" method="post" style="margin-bottom: 0px">
            <button class="btn btn-outline-warning">Logout</button>
        </form>
    </div>
</div>
<div id="btnChat" style="position: fixed;right: 0px;background-color: #03a2d4;color: #063866;border-radius: 28px;padding: 12px;margin-top: 20px;margin-right: 10px;cursor: pointer;z-index: 999999"><i class="fa fa-comment fa-2x"></i></div>
<%--<html>--%>
<%--<link rel="stylesheet" href="assets/css/bootstrap.min.css">--%>
<%--<head>--%>
<%--<title>Events</title>--%>
<%--<link rel="stylesheet" href="assets/css/csss/mainn.css" media="all"/>--%>
<%--<link rel="stylesheet" href="assets/css/csss/main.css"/>--%>
<%--<link rel="stylesheet" href="assets/css/csss/hello.css"/>--%>
<%--<link rel="stylesheet" href="assets/css/csss/mainnnn.css"/>--%>
<%--<link rel="stylesheet" href="assets/css/csss/hideshow.css"/>--%>
<%--<link rel="stylesheet" href="assets/css/csss/navButton.css">--%>


<%--<script src="assets/js/jquery-3.3.1.min.js"></script>--%>
<%--<script src="assets/js/jss/Search.js"></script>--%>
<%--</head>--%>
<%--<body class="container-fluid">--%>
<%--<div class="row">--%>
<%--<div class="col-12 menubar container red topBotomBordersOut">--%>
<%--<h1 align="center">Events</h1>--%>
<%--<a href="events.jsp"><button>Find Event</button></a>--%>
<%--<a href="myevents.jsp"><button>My Events</button></a>--%>
<%--<a href="addevents.jsp"><button>Add Event</button></a>--%>
<%--</div>--%>


<%--</div>--%>
<%--</body>--%>
<%--</html>--%>