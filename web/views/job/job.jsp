<%@ page import="model.JobDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.db_controller.JobController" %>
<jsp:include page="header_jobs.jsp"/>

<div class="row" style="font-size: 25px;margin-top: 70px">
    <div class="col-sm-12" style="text-align: center;font-weight: bold"><span
            style="border: 1px solid #d3a308;padding: 10px;padding-left: 30px;padding-right: 30px;border-radius: 10px">Browse Jobs</span>
    </div>
</div>

<div class="row" style="margin-top: 70px">
    <div class="col-sm-9" style="padding-right: 60px;padding-left: 60px;text-align: center">Job Title</div>
</div>

<div class="row" style="margin-top: 5px">
    <div class="col-sm-9">
        <select class="form-control" id="job-title">
            <%
                {
                    JobController jobController = new JobController();
                    ArrayList<JobDTO> jobs = jobController.getJobTitles();
                    for (JobDTO jobDTO : jobs) {
            %>
            <option value="<%= jobDTO.getJobTitle()%>"><%= jobDTO.getJobTitle()%>
            </option>
            <%
                    }
                }
            %>
        </select>
    </div>
    <div class="col-sm-3">
        <button id="searchBtn" class="btn btn-warning"
                style="left: 50%;transform: translateX(-50%);position: relative;font-size: 18px;width: 100%">Search
        </button>
    </div>
</div>

<div class="row" style="margin-top: 50px">
    <div class="col-sm-12" id="jobs-div"></div>
</div>
<jsp:include page="../chat/chat.jsp"/>
<script src="../../assets/js/jquery-3.3.1.min.js"></script>
<script src="../../controller/jobsController.js"></script>
<script src="../../controller/chatController.js"></script>
</body>
</html>
