<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="/file_up" method="post" enctype="multipart/form-data">
    <input type="hidden" value="<%= uid%>" name="poster_id">
    <div class="row" style="margin-top: 50px;text-align: center;margin-left: 250px;margin-right: 250px">
        <%
            if (request.getParameter("upload") != null) {
                if (request.getParameter("upload").equals("success")) {
        %>
        <div class="col-sm-12">
            <div class="alert alert-success">
                Resume has been uploaded
            </div>
        </div>
        <%
        } else {
        %>
        <div class="col-sm-12">
            <div class="alert alert-danger">
                Resume uploading failed
            </div>
        </div>
        <%
            }
        } else {
        %>
        <div class="col-sm-12">
            <div class="alert alert-warning">
                Upload your resume
            </div>
        </div>
        <%
            }
        %>
    </div>
    <div class="row" style="margin-top: 50px">
        <div class="col-sm-12">
            <div style="position: absolute;left: 50%;transform: translateX(-50%);padding: 50px;<%= request.getParameter("upload") != null ? request.getParameter("upload").equals("success") ? "border: 2px solid green" : "border: 2px solid red" : "border: 2px solid #E0A800"%>">
                <input type="file" name="file">
                <button class="btn btn-<%= request.getParameter("upload") != null ? request.getParameter("upload").equals("success") ? "success" : "danger" : "warning"%>">
                    Upload
                </button>
            </div>
        </div>
    </div>
</form>
<jsp:include page="../chat/chat.jsp"/>
<script src="../../assets/js/jquery-3.3.1.min.js"></script>
<script src="../../controller/chatController.js"></script>
</body>
</html>