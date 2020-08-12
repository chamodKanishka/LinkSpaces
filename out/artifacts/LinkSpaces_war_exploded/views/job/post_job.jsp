<%@ page import="model.JobDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.db_controller.JobController" %>
<jsp:include page="header_jobs.jsp"/>
<%
    HttpSession sessionLogin = request.getSession(false);
    String uid = "";
    if (sessionLogin != null) {
        if (sessionLogin.getAttribute("uid") != null) {
            uid = sessionLogin.getAttribute("uid").toString();
        }
    }
%>
<%
    if (request.getParameter("upload") != null) {
%>
<div class="row" style="margin-top: 50px;text-align: center;margin-left: 250px;margin-right: 250px">
    <%
        if (request.getParameter("upload").equals("success")) {
    %>
    <div class="col-sm-12">
        <div class="alert alert-success">
            Job has been uploaded
        </div>
    </div>
    <%
    } else {
    %>
    <div class="col-sm-12">
        <div class="alert alert-danger">
            Job uploading failed
        </div>
    </div>
    <%
        }
    %>
</div>
<%
    }
%>

<div class="row" style="font-size: 25px;margin-top: 70px">
    <div class="col-sm-12" style="text-align: center;font-weight: bold"><span
            style="border: 1px solid #d3a308;padding: 10px;padding-left: 30px;padding-right: 30px;border-radius: 10px">Post Job</span>
    </div>
</div>

<form action="/post_job" method="post" style="margin-top: 50px">
    <input type="hidden" value="<%= uid%>" name="poster_id">
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-12">Job Title</div>
        <div class="col-sm-12">
            <select class="form-control" name="job_title">
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
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-12">Offered By</div>
        <div class="col-sm-12">
            <select class="form-control" name="offered_by">
                <%
                    {
                        JobController jobController = new JobController();
                        ArrayList<JobDTO> jobs = jobController.getCompanies();
                        for (JobDTO jobDTO : jobs) {
                %>
                <option value="<%= jobDTO.getOfferedBy()%>"><%= jobDTO.getOfferedBy()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-12">Job Type</div>
        <div class="col-sm-12">
            <select class="form-control" name="job_type">
                <%
                    {
                        JobController jobController = new JobController();
                        ArrayList<JobDTO> jobs = jobController.getJobTypes();
                        for (JobDTO jobDTO : jobs) {
                %>
                <option value="<%= jobDTO.getJobType()%>"><%= jobDTO.getJobType()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-12">Description</div>
        <div class="col-sm-12"><textarea class="form-control" placeholder="Add Description"
                                         name="description" required></textarea></div>
    </div>
    <div class="row" style="margin-top: 50px">
        <div class="col-sm-12">
            <button type="submit" class="btn btn-warning"
                    style="position: relative;left: 50%;transform: translateX(-50%)">Submit
            </button>
        </div>
    </div>
</form>
<jsp:include page="../chat/chat.jsp"/>
<script src="../../assets/js/jquery-3.3.1.min.js"></script>
<script src="../../controller/jobsController.js"></script>
<script src="../../controller/chatController.js"></script>
</body>
</html>