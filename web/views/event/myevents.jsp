<jsp:include page="header_events.jsp"/>
<%
    HttpSession sessionLogin = request.getSession(false);
    String uid = "";
    String username = "";
    if (sessionLogin != null) {
        if (sessionLogin.getAttribute("username") != null) {
            username = sessionLogin.getAttribute("username").toString();
        }
        if (sessionLogin.getAttribute("uid") != null) {
            uid = sessionLogin.getAttribute("uid").toString();
        }
    }
%>

<div class="row">
    <div class="col-12" id="posts" style="padding-left: 20px;font-size: 15px;padding-right: 20px;margin-bottom: 10px"></div>
</div>
<input type="hidden" id="uidLinkSpaces" value="<%= uid%>">
<input type="hidden" id="usernameLinkSpaces" value="<%= username%>">
<jsp:include page="../chat/chat.jsp"/>
<script src="../../assets/js/jquery-3.3.1.min.js"></script>
<script src="../../controller/postsController.js"></script>
<script src="../../controller/chatController.js"></script>
</body>
</html>