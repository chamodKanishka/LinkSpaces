function validateIndustrial(){

    var org = document.forms["regform"]["org"].value;
    var orgtype = document.forms["regform"]["orgtype"].value;
    var weburl = document.forms["regform"]["weburl"].value;
    var uname  = document.forms["regform"]["uname"].value;
    var pwd = document.forms["regform"]["pwd"].value;
    var rptpwd = document.forms["regform"]["rptpwd"].value;
    var invalidChars = /[=;<>\/'"]/;
    var sqlCmnt = /--/;

    if(invalidChars.test(org) || sqlCmnt.test(org)){
        alert("Your 'Organization name' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(orgtype) || sqlCmnt.test(orgtype)){
        alert("Your 'Organization Type' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(weburl) || sqlCmnt.test(weburl)){
        alert("Your 'Website URL' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(uname) || sqlCmnt.test(uname)){
        alert("Your 'Username' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(pwd) || sqlCmnt.test(pwd)){
        alert("Your 'Password' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(!(pwd == rptpwd)){
        alert("Your Passwords do not match!");
        return false;
    }
}

function validateUniversity(){


    var uni = document.forms["regform"]["uni"].value;
    var regno = document.forms["regform"]["regno"].value;
    var weburl = document.forms["regform"]["weburl"].value;
    var uname  = document.forms["regform"]["uname"].value;
    var pwd = document.forms["regform"]["pwd"].value;
    var rptpwd = document.forms["regform"]["rptpwd"].value;
    var invalidChars = /[=;<>\/'"]/;
    var sqlCmnt = /--/;

    if(invalidChars.test(uni) || sqlCmnt.test(uni)){
        alert("Your 'University Name' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(regno) || sqlCmnt.test(regno)){
        alert("Your 'Registration Number' contains invalid characters( = ; < > \\ / ' \"  -- )");
        return false;
    }

    if(invalidChars.test(weburl) || sqlCmnt.test(weburl)){
        alert("Your 'Website URL' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(uname) || sqlCmnt.test(uname)){
        alert("Your 'Username' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(pwd) || sqlCmnt.test(pwd)) {
        alert("Your 'Password' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(!(pwd == rptpwd)){
        alert("Your Passwords do not match!");
        return false;
    }
}

function validateStudent() {

    var fname  = document.forms["regform"]["fname"].value;
    var lname  = document.forms["regform"]["lname"].value;
    var uni = document.forms["regform"]["university"].value;
    var index  = document.forms["regform"]["index"].value;
    var uname  = document.forms["regform"]["uname"].value;
    var pwd = document.forms["regform"]["pwd"].value;
    var rptpwd = document.forms["regform"]["rptpwd"].value;
    var invalidChars = /[=;<>\/'"]/;
    var sqlCmnt = /--/;

    if(invalidChars.test(fname) || sqlCmnt.test(fname)){
        alert("Your 'First Name' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(lname) || sqlCmnt.test(lname)){
        alert("Your 'Last Name' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(uni == "none"){
        alert("Please select your University from the list.")
        return false;
    }

    if(invalidChars.test(index) || sqlCmnt.test(index)){
        alert("Your 'Index Number' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(uname) || sqlCmnt.test(uname)){
        alert("Your 'Username' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(invalidChars.test(pwd) || sqlCmnt.test(pwd)) {
        alert("Your 'Password' contains invalid characters( = ; < > \\ / ' \" -- )");
        return false;
    }

    if(!(pwd == rptpwd)){
        alert("Your Passwords do not match!");
        return false;
    }
}