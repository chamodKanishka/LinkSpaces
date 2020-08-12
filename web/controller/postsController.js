var type = '';

$(window).ready(function () {
    type = 'event';
    if (window.location.pathname == '/views/event/events.jsp') {
        setEventsDataToPostsEvents();
    } else if (window.location.pathname == '/views/event/myevents.jsp') {
        setEventsDataToPostsMyEvents();
    } else {
        setEventsDataToPosts();
    }
})

$('#btnEvents').click(function () {
    type = 'event';
    setEventsDataToPosts();
    $('#btnJobs').css('color', '#b48b07');
    $(this).css('color', 'black');
})

$('#btnJobs').click(function () {
    type = 'job';
    setJobsDataToPosts();
    $('#btnEvents').css('color', '#b48b07');
    $(this).css('color', 'black');
})

$('.date_radio').click(function () {
    setEventsDataToPostsEvents();
})

$(document).on('click', '.btnViewComments', function () {
    if ($(this).text() == 'View Comments') {
        $(this).text('Hide Comments');
        $(this).parent().parent().parent().children('div.comments').html(setComments($(this).parent().parent().parent().parent().children('input[type=hidden]').val()))
        $(this).parent().parent().parent().children('div.comments').show();
        $(this).parent().parent().parent().children('div.rowBtnComment').show();
    } else {
        $(this).text('View Comments');
        $(this).parent().parent().parent().children('div.comments').hide();
        $(this).parent().parent().parent().children('div.rowBtnComment').hide();
    }
})

$(document).on('click', '.btnComment', function () {
    var date = new Date();
    var commentBox = '' +
        '<div class="row" style="border: 1px solid rgba(38,38,38,0.09);padding: 10px;margin: 10px;border-radius: 20px">\n' +
        '<input type="hidden" value="">' +
        '<div class="col-sm-12" style="font-weight: bold">\n' +
        $('#usernameLinkSpaces').val() +
        '</div>\n' +
        '<div class="col-sm-11">\n' +
        '<textarea class="form-control"></textarea>' +
        '</div>\n' +
        '<div class="col-sm-1">\n' +
        '<i class="fa fa-check" style="font-size: 20px;color: rgba(2,123,2,0.77);cursor: pointer"></i>\n' +
        '<i class="fa fa-times" style="font-size: 20px;color: rgb(193,9,11);cursor: pointer;padding-top: 10px"></i>\n' +
        '</div>\n' +
        '<div class="col-sm-12" style="color: #838383">[ ' + date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' / ' + date.getHours() + ':' + date.getMinutes() + ' ]</div> \n' +
        '</div>';
    $(this).parent().parent().parent().children('div.comments').append(commentBox);
    var divComments = $(this).parent().parent().parent().children('div.comments');
    divComments.animate({scrollTop: divComments[0].scrollHeight}, 1000);
})

$(document).on('click', '.fa-pencil', function () {
    var buttons = '' +
        '<i class="fa fa-check" style="font-size: 20px;color: rgba(2,123,2,0.77);cursor: pointer"></i>\n' +
        '<i class="fa fa-times" style="font-size: 20px;color: rgb(193,9,11);cursor: pointer;padding-top: 10px"></i>';

    var comment = '' +
        '<textarea class="form-control">' +
        $(this).parent().parent().children('div.col-sm-11').text() +
        '</textarea>';
    $(this).parent().parent().children('div.col-sm-11').html(comment)
    $(this).parent().parent().children('div.col-sm-1').html(buttons)
});

$(document).on('click', '.fa-check', function () {
    var comment = $(this).parent().parent().children('div.col-sm-11').children().val();
    var that = this;
    $.ajax(
        {
            type: "post",
            url: "http://" + window.location.hostname + ":" + window.location.port + "/add_comment",
            data: {
                commentId: $(this).parent().parent().children('input[type=hidden]').val(),
                posterId: $('#uidLinkSpaces').val(),
                eventId: $(this).parent().parent().parent().parent().parent().children('input[type=hidden]').val(),
                comment: comment,
                type: type
            },
            success: function () {
                $(that).parent().parent().parent().html(setComments($(that).parent().parent().parent().parent().parent().children('input[type=hidden]').val()))
            },
            error: function () {

            }
        }
    );
});

$(document).on('click', '.fa-times', function () {
    var that = this;
    $.ajax(
        {
            type: "post",
            url: "http://" + window.location.hostname + ":" + window.location.port + "/delete_comment",
            data: {
                commentId: $(this).parent().parent().children('input[type=hidden]').val(),
                type: type
            },
            success: function (response) {
                $(that).parent().parent().remove()
            },
            error: function () {

            }
        }
    );
});

function setEventsDataToPosts() {
    $.ajax(
        {
            type: "post",
            url: "http://" + window.location.hostname + ":" + window.location.port + "/load_events",
            success: function (response) {
                var obj = JSON.parse(response);
                setEventsPosts(obj.Posts);
            },
            error: function () {

            }
        }
    );
}

function setJobsDataToPosts() {
    $.ajax(
        {
            type: "post",
            url: "http://" + window.location.hostname + ":" + window.location.port + "/load_jobs",
            success: function (response) {
                var obj = JSON.parse(response);
                setJobsPosts(obj.Posts);
            },
            error: function () {

            }
        }
    );
}

function setEventsPosts(postsData) {
    var posts = '<div class="row" style="margin-top: 20px"><div class="col-sm-12" style="text-align: center;font-weight: bold;font-size: 20px"><span style="border: 1px solid #d3a308;padding: 10px;padding-left: 30px;padding-right: 30px;border-radius: 10px">Posts</span></div></div>';

    for (var i = 0; i < postsData.length; i++) {
        posts += '' +
            '<div class="row" style="border: 1px solid rgba(249,192,9,0.49);margin-top: 20px;margin-left: 70px;margin-right: 70px;padding-top: 10px">\n' +
            '           <input type="hidden" value="' + postsData[i].Id + '">' +
            '           <div class="col-sm-12">\n' +
            '           <img height="10" src="http://' + window.location.hostname + ':' + window.location.port + '/files/images/' + postsData[i].Image + '">' +
            '           </div>\n' +
            '           <div class="col-sm-12">\n' +
            '                <div class="row">\n' +
            '                    <div class="col-sm-12"><b>Title: </b>' + postsData[i].Title + '</div>' +
            '                    <div class="col-sm-4"><b>Start Date: </b>' + postsData[i].StartDate + '</div>' +
            '                    <div class="col-sm-4"><b>End Date: </b>' + postsData[i].EndDate + '</div>' +
            '                    <div class="col-sm-4"><b>Start Time: </b>' + postsData[i].StartTime + '</div>' +
            '                    <div class="col-sm-8"><b>Venue: </b>' + postsData[i].Venue + '</div>' +
            '                    <div class="col-sm-4"><b>Category: </b>' + postsData[i].Category + '</div>' +
            '                    <div class="col-sm-6"><b>Website: </b><a target="_blank">' + postsData[i].Website + '</a></div>' +
            '                    <div class="col-sm-12" style="margin-top: 10px">' + postsData[i].Description + '</div>\n' +
            '                </div>\n' +
            '                <hr>\n' +
            '                <div class="row" style="padding-bottom: 10px">\n' +
            '                    <div class="col-sm-12">\n' +
            '                        <button class="btn btn-outline-warning btnViewComments" style="font-size: 13px;float: right">View Comments</button>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            <div class="comments" style="font-size: 14px;display: none;height: 300px;overflow-y: scroll">\n';

        posts += '' +
            '            </div>\n' +
            '                <div class="row rowBtnComment" style="display: none">\n' +
            '                    <hr>\n' +
            '                    <div class="col-sm-12" style="margin-top: 10px;margin-bottom: 30px">\n' +
            '                        <button class="btn btnComment"\n' +
            '                                style="background-color: rgba(249,192,9,0.49);position: relative;left: 50%;transform: translateX(-50%);font-size: 14px">\n' +
            '                            Comment\n' +
            '                        </button>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </div>\n'
    }

    $('#posts').html(posts)
}

function setJobsPosts(postsData) {
    var posts = '<div class="row" style="margin-top: 20px"><div class="col-sm-12" style="text-align: center;font-weight: bold;font-size: 20px"><span style="border: 1px solid #d3a308;padding: 10px;padding-left: 30px;padding-right: 30px;border-radius: 10px">Posts</span></div></div>';

    for (var i = 0; i < postsData.length; i++) {
        posts += '' +
            '<div class="row" style="border: 1px solid rgba(249,192,9,0.49);margin-top: 20px;margin-left: 70px;margin-right: 70px;padding-top: 10px">\n' +
            '           <input type="hidden" value="' + postsData[i].Id + '">' +
            '           <div class="col-sm-12">\n' +
            '                <div class="row">\n' +
            '                    <div class="col-sm-12"><b>Date: </b>' + postsData[i].PostDate + '</div>' +
            '                    <div class="col-sm-4"><b>Job Title: </b>' + postsData[i].Title + '</div>' +
            '                    <div class="col-sm-4"><b>Offered By: </b>' + postsData[i].OfferedBy + '</div>' +
            '                    <div class="col-sm-4"><b>Job Type: </b>' + postsData[i].Type + '</div>' +
            '                    <div class="col-sm-12" style="margin-top: 10px">' + postsData[i].Description + '</div>\n' +
            '                </div>\n' +
            '                <hr>\n' +
            '                <div class="row" style="padding-bottom: 10px">\n' +
            '                    <div class="col-sm-12">\n' +
            '                        <button class="btn btn-outline-warning btnViewComments" style="font-size: 13px;float: right">View Comments</button>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            <div class="comments" style="font-size: 14px;display: none;height: 300px;overflow-y: scroll">\n';

        posts += '' +
            '            </div>\n' +
            '                <div class="row rowBtnComment" style="display: none">\n' +
            '                    <hr>\n' +
            '                    <div class="col-sm-12" style="margin-top: 10px;margin-bottom: 30px">\n' +
            '                        <button class="btn btnComment"\n' +
            '                                style="background-color: rgba(249,192,9,0.49);position: relative;left: 50%;transform: translateX(-50%);font-size: 14px">\n' +
            '                            Comment\n' +
            '                        </button>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </div>\n'
    }
    $('#posts').html(posts)
}

function setComments(eventId) {
    var comments = '';
    $.ajax(
        {
            async: false,
            type: "post",
            url: "http://" + window.location.hostname + ":" + window.location.port + "/load_comments",
            data: {
                eventId: eventId,
                type: type
            },
            success: function (response) {
                console.log(response)
                var commentsData = JSON.parse(response);
                for (var j = 0; j < commentsData.Comments.length; j++) {
                    comments += '' +
                        '               <div class="row" style="border: 1px solid rgba(38,38,38,0.09);padding: 10px;margin: 10px;border-radius: 20px">\n' +
                        '                   <input type="hidden" value="' + commentsData.Comments[j].CommentId + '">' +
                        '                   <div class="col-sm-12" style="font-weight: bold">' + commentsData.Comments[j].PosterName + '</div> \n' +
                        '                   <div class="col-sm-11">' + commentsData.Comments[j].Comment + '</div>\n' +
                        '                   <div class="col-sm-1">\n';

                    if (commentsData.Comments[j].PosterId == $('#uidLinkSpaces').val()) {
                        comments += '' +
                            '                       <i class="fa fa-pencil"\n' +
                            '                           style="font-size: 20px;color: rgba(152,117,5,0.77);cursor: pointer"></i>\n';
                    }

                    comments += '' +
                        '                   </div>\n' +
                        '                   <div class="col-sm-12" style="color: #838383">[ ' + commentsData.Comments[j].PostDate + ' / ' + commentsData.Comments[j].PostTime + ' ]</div> \n' +
                        '               </div>\n';
                }
            },
            error: function () {

            }
        }
    );
    return comments;
}

function setEventsDataToPostsEvents() {
    $.ajax(
        {
            type: "post",
            url: "http://" + window.location.hostname + ":" + window.location.port + "/load_events",
            data: {
                eventYear: $('input[name=date]:checked').val().split('-')[0],
                eventStartMonth: $('input[name=date]:checked').val().split('-')[1],
                eventEndMonth: $('input[name=date]:checked').val().split('-')[2],
                eventDay: 1
            },
            success: function (response) {
                var obj = JSON.parse(response);
                setEventsPosts(obj.Posts);
            },
            error: function () {

            }
        }
    );
}

function setEventsDataToPostsMyEvents() {
    $.ajax(
        {
            type: "post",
            url: "http://" + window.location.hostname + ":" + window.location.port + "/load_events",
            data: {
                uid: $('#uidLinkSpaces').val()
            },
            success: function (response) {
                var obj = JSON.parse(response);
                setEventsPosts(obj.Posts);
            },
            error: function () {

            }
        }
    );
}