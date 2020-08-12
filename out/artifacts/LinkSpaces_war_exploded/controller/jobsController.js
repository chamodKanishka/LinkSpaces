$('#searchBtn').click(function () {
    console.log(window.location.origin)
    $.ajax(
        {
            type: "post",
            url: window.location.origin + "/load_jobs",
            data: {
                job_title: $('#job-title').val(),
                job_location: $('#job-location').val(),
                job_exp: $('#job-exp').val()
            },
            success: function (response) {
                var obj = JSON.parse(response);
                var resText = '' +
                    '<div style="text-align: center;font-size: 22px;margin-bottom: 20px">Details</div>' +
                    '<table border="1px" style="width: 100%;margin-bottom: 20px">' +
                    '<tr style="text-align: center;font-size: 16px">' +
                    '<th width="40%" style="padding: 8px">Description</th>' +
                    '<th width="30%" style="padding: 8px">Offered By</th>' +
                    '<th width="30%" style="padding: 8px">Job Type</th>' +
                    '</tr>'
                ;
                for (var i = 0; i < obj.Data.length; i++) {
                    resText += '<tr>'
                    resText += '<td style="padding-left: 5px">' + obj.Data[i].Description + '</td>';
                    resText += '<td style="padding-left: 5px">' + obj.Data[i].Offered_By + '</td>';
                    resText += '<td style="padding-left: 5px">' + obj.Data[i].Job_Type + '</td>';
                    resText += '</tr>'
                }
                resText += '</table>';
                console.log(resText)
                $('#jobs-div').html(resText);
            },
            error: function () {

            }
        }
    );
})