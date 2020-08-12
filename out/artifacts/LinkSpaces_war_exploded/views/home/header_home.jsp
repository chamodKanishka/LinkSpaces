<jsp:include page="../../header.jsp"/>

<div class="row" style="background-color: #d3a308;color: #795d04;font-size: 20px;padding: 10px;text-align: center">
    <div class="col-sm-3" style="text-align: left;font-weight: bold"><span
            style="border-right: 2px solid #795d04;padding-right: 50px;padding-left: 20px">Home</span></div>
    <div class="col-sm-4"></div>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("events") ? "style=\"font-weight: bold\"" : "" : ""%>>
        <a href="/views/event/events.jsp?path=events" style="text-decoration: none;color: black"><span
                class="headerText">Events</span></a></div>
    <div class="col-sm-2" <%= request.getParameter("path") != null ? request.getParameter("path").equals("search_job") ? "style=\"font-weight: bold\"" : "" : ""%>>
        <a href="/views/job/job.jsp?path=search_job" style="text-decoration: none;color: black"><span
                class="headerText">Jobs</span></a></div>
    <div class="col-sm-1">
        <form action="/logout" method="post" style="margin-bottom: 0px">
            <button class="btn btn-outline-warning">Logout</button>
        </form>
    </div>
</div>
<div id="btnChat" style="position: fixed;right: 0px;background-color: #03a2d4;color: #063866;border-radius: 28px;padding: 12px;margin-top: 20px;margin-right: 10px;cursor: pointer;z-index: 999999"><i class="fa fa-comment fa-2x"></i></div>