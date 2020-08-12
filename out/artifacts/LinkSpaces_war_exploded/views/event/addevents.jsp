<jsp:include page="header_events.jsp"/>
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
            Event has been uploaded
        </div>
    </div>
    <%
    } else {
    %>
    <div class="col-sm-12">
        <div class="alert alert-danger">
            Event uploading failed
        </div>
    </div>
    <%
        }
    %>
</div>
<%
    }
%>

<div id="form">
    <form action="/event_image" method="post" enctype="multipart/form-data">
        <input type="hidden" id="uidLinkSpaces" name="posterId" value="<%= uid%>">
        <div class="row" style="margin-top: 40px;text-align: center;font-size: 25px;font-weight: bold">
            <div class="col-sm-12">
                <span style="border: 1px solid #d3a308;padding: 10px;padding-left: 30px;padding-right: 30px;border-radius: 10px">Add Event</span>
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12">
                Event Name:
            </div>
            <div class="col-sm-12">
                <input type="text" class="form-control" name="eventName" required>
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-2">
                <input class="form-control" type="date" name="startDate" required>
            </div>
            <div class="col-sm-2">
                <input class="form-control" type="time" name="startTime" required>
            </div>
            <div class="col-sm-1" style="text-align: center">
                to
            </div>
            <div class="col-sm-2">
                <input class="form-control" type="date" name="endDate" required>
            </div>
            <div class="col-sm-2">
                <%--<input class="form-control" type="time" name="endTime" required>--%>
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12">
                <input type="checkbox" name="virtual" style="margin-right: 10px">This is a virtual event
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12">
                Venue Name:
            </div>
            <div class="col-sm-12">
                <input type="text" placeholder="EX.Carriegie Hall" class="form-control" name="venueName" required>
            </div>
        </div>
        <%--<div class="row" style="margin-top: 20px">--%>
            <%--<div class="col-sm-12">--%>
                <%--Location:--%>
            <%--</div>--%>
            <%--<div class="col-sm-12">--%>
                <%--<input type="text" placeholder="EX.184 Main rd Galle" class="form-control" name="location" required>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12">
                Website:
            </div>
            <div class="col-sm-12">
                <input type="text" placeholder="https://" class="form-control" name="website" required>
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12" style="margin-bottom: 10px">
                Are you attending:
            </div>
            <div class="col-sm-4"><input type="radio" name="attending" value="I'm attending" style="margin-right: 10px"><label>I'm attending</label></div>
            <div class="col-sm-4"><input type="radio" name="attending" value="I'm interested" style="margin-right: 10px"><label>I'm interested</label></div>
            <div class="col-sm-4"><input type="radio" name="attending" value="I'm not attending" style="margin-right: 10px"><label>I'm not attending</label></div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12">
                Are you Organizing?
            </div>
            <div class="col-sm-12">
                <input type="checkbox" name="organizing" style="margin-right: 10px" value="organizing">Yes, I am organizing this event
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12">
                Description:
            </div>
            <div class="col-sm-12">
                <textarea rows="10" cols="30" id="description" name="description" class="form-control" required></textarea>
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-sm-12">
                Add image:
            </div>
            <div class="col-sm-12">
                <input type="file" name="file">
            </div>
        </div>
        <div class="row" style="margin-top: 80px">
            <div class="col-sm-12">
                <button class="btn btn-warning" type="submit" style="position: relative;left: 50%;transform: translateX(-50%)">Publish Event</button>
            </div>
        </div>
    </form>
</div>
<jsp:include page="../chat/chat.jsp"/>
<script src="../../assets/js/jquery-3.3.1.min.js"></script>
<script src="../../controller/postsController.js"></script>
<script src="../../controller/chatController.js"></script>
</body>
</html>