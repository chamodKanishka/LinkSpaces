<jsp:include page="../../header.jsp"/>
<%
    HttpSession sessionLogin = request.getSession(false);
    String usertype = "";
    if (sessionLogin != null) {
        if (sessionLogin.getAttribute("usertype") != null) {
            usertype = sessionLogin.getAttribute("usertype").toString();
        }
    }
%>

<div class="row" style="background-color: #d3a308;color: #795d04;font-size: 20px;padding: 10px;text-align: center">
    <div class="col-sm-5" style="text-align: left;font-weight: bold"><span style="border-right: 2px solid #795d04;padding-right: 50px;padding-left: 20px">JOB OPPORTUNITIES</span></div>
    <div class="col-sm-2"><a href="/views/home/home.jsp?path=home" style="text-decoration: none;color: black"><span class="headerText">Home</span></a></div>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("search_job") ? "style=\"font-weight: bold\"" : "" : ""%>><a href="job.jsp?path=search_job" style="text-decoration: none;color: black"><span class="headerText">Search Job</span></a></div>
    <%
    if(usertype.equals("industrial")){
    %>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("post_job") ? "style=\"font-weight: bold\"" : "" : ""%>><a href="post_job.jsp?path=post_job" style="text-decoration: none;color: black"><span class="headerText">Post Job</span></a></div>
    <%
    }else if(usertype.equals("student")){
    %>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("resume") ? "style=\"font-weight: bold\"" : "" : ""%>><a href="file.jsp?path=resume" style="text-decoration: none;color: black"><span class="headerText">Post Resume</span></a></div>
    <%
        }
    %>
    <div class="col-sm-1">
        <form action="/logout" method="post" style="margin-bottom: 0px">
            <button class="btn btn-outline-warning">Logout</button>
        </form>
    </div>
</div>
<div id="btnChat" style="position: fixed;right: 0px;background-color: #03a2d4;color: #063866;border-radius: 28px;padding: 12px;margin-top: 10px;margin-right: 10px;cursor: pointer;z-index: 999999"><i class="fa fa-comment fa-2x"></i></div>