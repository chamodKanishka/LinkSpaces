<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="col-3" style="padding-right: 20px">
        <div class="row" style="padding-top: 10px">
            <div class="col-sm-12">
                Search Panel
            </div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-sm-12">
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-sm-12">
                <button class="btn btn-warning" style="position: relative;left: 50%;transform: translateX(-50%)">
                    Search
                </button>
            </div>
        </div>
        <div class="message">
            <div id="sidebar">
                <hr color="white">
                <ul id="Cats" class="container" type="none">
                    <b>Date:</b>
                    <b>2019</b>
                    <li><input class="date_radio" type="radio" name="date" checked value="2019-2-3"><label
                            style="padding-left: 10px">Feb-March
                        20</label></li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-3-4"><label
                            style="padding-left: 10px">March-April
                        20</label></li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-4-5"><label
                            style="padding-left: 10px">April-May
                        20</label></li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-5-6"><label
                            style="padding-left: 10px">May-June
                        20</label></li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-6-7"><label
                            style="padding-left: 10px">June-July
                        20</label></li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-7-8"><label
                            style="padding-left: 10px">July-August
                        20</label></li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-8-9"><label
                            style="padding-left: 10px">August-September
                        20</label>
                    </li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-9-10"><label
                            style="padding-left: 10px">September-October
                        20</label>
                    </li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-10-11"><label
                            style="padding-left: 10px">October-November
                        20</label>
                    </li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-11-12"><label
                            style="padding-left: 10px">November-December
                        20</label>
                    </li>
                    <li><input class="date_radio" type="radio" name="date" value="2019-12-1"><label
                            style="padding-left: 10px">December-January
                        20</label>
                    </li>
                    <hr>
                    <b>2020</b>
                    <li><input class="date_radio" type="radio" name="date" value="2020-1-2"><label
                            style="padding-left: 10px">January-February
                        20</label>
                    </li>
                    <li><input class="date_radio" type="radio" name="date" value="2020-2-3"><label
                            style="padding-left: 10px">February-March
                        20</label></li>
                    <hr color="white">
                    <b>Location:</b>
                    <br/>
                    <li><input class="date_radio" type="radio" name="venue"><label
                            style="padding-left: 10px">NSBM</label>
                        <div class="check"></div>
                    </li>
                    <li><input class="date_radio" type="radio" name="venue"><label style="padding-left: 10px">Microsoft
                        Sri Lanka</label>
                    </li>
                    <li><input class="date_radio" type="radio" name="venue"><label style="padding-left: 10px">IBM Sri
                        Lanka</label></li>
                    <li><input class="date_radio" type="radio" name="venue"><label
                            style="padding-left: 10px">WSO2</label></li>
                    <li><input class="date_radio" type="radio" name="venue"><label
                            style="padding-left: 10px">SLIIT</label></li>
                </ul>
            </div>
        </div>

    </div>
    <input type="hidden" id="uidLinkSpaces" value="<%= uid%>">
    <input type="hidden" id="usernameLinkSpaces" value="<%= username%>">
    <div class="col-9" id="posts" style="padding-left: 20px;font-size: 15px;padding-right: 20px;margin-bottom: 10px"></div>
    <%--<div id="btnChat" style="position: fixed;right: 0px;background-color: #03a2d4;color: #063866;border-radius: 28px;padding: 12px;margin-top: 10px;margin-right: 10px;cursor: pointer"><i class="fa fa-comment fa-2x"></i></div>--%>
</div>
<jsp:include page="../chat/chat.jsp"/>
<script src="../../assets/js/jquery-3.3.1.min.js"></script>
<script src="../../controller/postsController.js"></script>
<script src="../../controller/chatController.js"></script>
</body>
</html>