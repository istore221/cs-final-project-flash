﻿<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Project Allocation to Students</title>

    <link href="Content/css/bootstrap.min.css" rel="stylesheet">

    <script src="Content/js/jquery.min.js"></script>
    <script src="Content/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="Content/js/bootstrap-filestyle.min.js"></script>

</head>
<body>

<div style="margin-top: 5px;">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><font size="5" color="#08298A" face="Agency FB"><b>Project Allocation to Students</b></font></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <!-- <li><a href="#">Link</a></li> -->
                </ul>
            </div>
        </div>
    </nav>
</div>

<div class="container">
    <center>
        <div style="width: 80%;">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form enctype="multipart/form-data" id="fileUploadForm">
                        <input type="file" class="filestyle" data-buttonname="btn-primary" id="fileUp" name="fileUp">
                        <br />
                        <div class="row">

                            <div class="col-md-6">
                                <input type="text" class="form-control" id="no_OfProjects" placeholder="Number Of Preferences For One Student" name="no_OfProjects">
                            </div>
                            <div class="col-md-3">
                                <button type="button" class="btn btn-primary" style="width: 100%;" id="btnUpload">Upload File & Continue</button>
                            </div>
                            <div class="col-md-3">
                                <button type="button" class="btn btn-danger" style="width: 100%;" id="btnRemove">Remove</button>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </center>

    <div id="part-1">
        <center>
            <div class="panel panel-info" style="width: 80%;">
                <div class="panel-heading">
                    <h3 class="panel-title"><b><font size="4" color="#08298A" face="Agency FB">Select Algorithm</font></b></h3>
                </div>
                <div class="panel-body">
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="options_sa" value="options_sa">
                            <b>Simulated Annealing (SA)</b>
                        </label>
                        <label></label>
                        <label>
                            <input type="radio" name="optionsRadios" id="options_ga" value="options_ga">
                            <b>Genetic Algorithm (GA)</b>
                        </label>
                    </div>
                </div>
            </div>
        </center>
    </div>

    <div class="row">
        <center>
            <img id="LoadingGif" src="Content/img/loader02.gif" style="display: none"></img>
        </center>
    </div>

    <br />

    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-info" style="margin-left: 5px;">
                <div class="panel-heading">
                    <h3 class="panel-title"><b><font size="4" color="#08298A" face="Agency FB">Simulated Annealing (SA)</font></b></h3>
                </div>
                <div class="panel-body">
                    <form>
                        <div class="form-group">
                            <input type="text" class="form-control" id="sa_no_OfTime" placeholder="Number Of Times Algorithm Should Run ">
                        </div>
                        <button type="button" class="btn btn-primary" style="width: 100%;" id="btnSA" data-loading-text="Calculating..." autocomplete="off">Calculate</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-info" style="margin-right: 5px;">
                <div class="panel-heading">
                    <h3 class="panel-title"><b><font size="4" color="#08298A" face="Agency FB">Genetic Algorithm (GA)</font></b></h3>
                </div>
                <div class="panel-body">
                    <form>
                        <div class="form-group">
                            <input type="text" class="form-control" id="ga_no_OfTime" placeholder="Number Of Initial Population">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="ga_no_OfGen" placeholder="Number Of Genarations">
                        </div>
                        <button type="button" class="btn btn-primary" style="width: 100%;" id="btnGA">Calculate</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <hr />

    <div class="row">
        <center>
            <div class="panel panel-success" style="width: 50%;">
                <div class="panel-heading">
                    <h3 class="panel-title"><b><font size="4" color="#08298A" face="Agency FB">Summary - Simulated Annealing</font></b></h3>
                </div>
                <div class="panel-body">
                    <span id="summarydata"></span><br /><br />
                    <button type="button" class="btn btn-success btn-lg btn-block" onclick="fnExcelReport();">Export To Excel</button>
                </div>
                <iframe id="txtArea1" style="display:none"></iframe>
            </div>
        </center>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title"><b><font size="4" color="#08298A" face="Agency FB">Result - Simulated Annealing</font></b></h3>
                </div>
                <div class="panel-body">
                    <table class="table table-hover" id="ResultingTable">
                        <thead>
                            <tr>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>



</body>
</html>

<script type="text/javascript">

    $(document).ready(function () {

        document.getElementById("options_sa").disabled = true;
        document.getElementById("options_ga").disabled = true;
        document.getElementById("sa_no_OfTime").disabled = true;
        document.getElementById("btnSA").disabled = true;
        document.getElementById("ga_no_OfTime").disabled = true;
        document.getElementById("btnGA").disabled = true;
        document.getElementById("ga_no_OfGen").disabled = true;

        //Numbers Only
        $("#no_OfProjects").keypress(function (e) {
            if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
                return false;
            }
        });

        $("#sa_no_OfTime").keypress(function (e) {
            if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
                return false;
            }
        });

        $("#ga_no_OfTime").keypress(function (e) {
            if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
                return false;
            }
        });

        $("#ga_no_OfGen").keypress(function (e) {
            if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
                return false;
            }
        });
    });

    $('#btnUpload').click(function () {
        var fileVal = $('#fileUp').val();
        var noProjects = $('#no_OfProjects').val();

        if (fileVal == '') {
            alert("Please Select Data File [.tsv]");
        } else if (noProjects == '') {
            alert("Please Enter Number Of Project To One Student ");
        } else {
            var ext = $('#fileUp').val().split('.').pop().toLowerCase();
            if ($.inArray(ext, ['tsv']) == -1) {
                alert('Invalid File Format Need .tsv Format!');
            } 
            else {

                $.ajax({
                    type: "POST",
                    url: "result.jsp",
                    data: new FormData($("#fileUploadForm")[0]),
                    success: function (data) {
                        document.getElementById("options_sa").disabled = false;
                        document.getElementById("options_ga").disabled = false;
                    },
                    contentType: false,
                    processData: false
                });
                
            }
        }
    });

    $("#btnSA").click(function() {
        $(this).button('loading');
        $('#LoadingGif').show();
        $('#summarydata').html('');
        $('#ResultingTable thead tr').html('');
        $('#ResultingTable tbody').html('');

        $.ajax({
            type: "POST",
            url: "result.jsp",
            data: {
                funcname: 'SA',
                iterations: $('#sa_no_OfTime').val(),
                no_OfProjects: $('#no_OfProjects').val()
            },
            success: function (data) {
                var jsonobj = JSON.parse(data);

                for (var i = 0; i < jsonobj.summary.length; i++){
                    $('#summarydata').append('<b>' + jsonobj.summary[i].title + ' :</b> ' + jsonobj.summary[i].value + '<hr />');
                }
                $('#summarydata').append('<small><b>Projects which are conflicting with another is highlighted in red.</b></small>');

                for (var i = 0; i < jsonobj.tableheaders.length; i++){
                    $('#ResultingTable thead tr').append('<th>' + jsonobj.tableheaders[i].tableheader + '</th>');
                }

                for (var i = 0; i < jsonobj.tabledata.length; i++){
                    var tData = '<tr ' + (jsonobj.tabledata[i].col5 ? 'class="danger"' : '') + '>';

                    tData += '<th scope="row">' + jsonobj.tabledata[i].col1 + '</th>';

                    tData += '<td>' + jsonobj.tabledata[i].col2 + '</td>';
                    
                    tData += '<td>';
                    for (var j = 0; j < jsonobj.tabledata[i].col3.length; j++){
                        tData += (jsonobj.tabledata[i].col3[j].pref + '<br />');
                    }
                    tData += '</td>';

                    tData += '<td>' + jsonobj.tabledata[i].col4 + '</td>';
                    tData += '</tr>'

                    $('#ResultingTable tbody').append(tData);
                }
                $("#btnSA").button('reset');
                $('#LoadingGif').hide();
            }
        });
    });

    $('#btnRemove').click(function () {
        $(":file").filestyle('clear');
        $('#no_OfProjects').val("");

        $('#sa_no_OfTime').val("");
        $('#ga_no_OfTime').val("");
        $('#ga_no_OfGen').val("");

        document.getElementById("options_sa").disabled = true;
        document.getElementById("options_ga").disabled = true;
        document.getElementById("sa_no_OfTime").disabled = true;
        document.getElementById("btnSA").disabled = true;
        document.getElementById("ga_no_OfTime").disabled = true;
        document.getElementById("btnGA").disabled = true;
        document.getElementById("ga_no_OfGen").disabled = true;

        $('#options_sa').prop('checked', false);
        $('#options_ga').prop('checked', false);

        $('#summarydata').html('');
        $('#ResultingTable thead tr').html('');
        $('#ResultingTable tbody').html('');
    });

    $('input:radio[name="optionsRadios"]').change(function () {
        if ($(this).is(':checked') && $(this).val() == 'options_sa') {
            document.getElementById("sa_no_OfTime").disabled = false;
            document.getElementById("btnSA").disabled = false;

            document.getElementById("ga_no_OfTime").disabled = true;
            document.getElementById("btnGA").disabled = true;
            document.getElementById("ga_no_OfGen").disabled = true;

            $('#ga_no_OfTime').val("");
            $('#ga_no_OfGen').val("");
        }

        if ($(this).is(':checked') && $(this).val() == 'options_ga') {
            document.getElementById("ga_no_OfTime").disabled = false;
            document.getElementById("btnGA").disabled = false;
            document.getElementById("ga_no_OfGen").disabled = false;

            document.getElementById("sa_no_OfTime").disabled = true;
            document.getElementById("btnSA").disabled = true;

            $('#sa_no_OfTime').val("");
        }
    });

    $(":file").filestyle({ buttonName: "btn-info" });

    function fnExcelReport() {
        var tab_text = "<table border='2px'><tr bgcolor='#87AFC6'>";
        var textRange; var j = 0;
        tab = document.getElementById('ResultingTable'); // id of table

        for (j = 0 ; j < tab.rows.length ; j++) {
            tab_text = tab_text + tab.rows[j].innerHTML + "</tr>";
        }

        tab_text = tab_text + "</table>";
        tab_text = tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
        tab_text = tab_text.replace(/<img[^>]*>/gi, ""); // remove if u want images in your table
        tab_text = tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

        var ua = window.navigator.userAgent;
        var msie = ua.indexOf("MSIE ");

        if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
        {
            txtArea1.document.open("txt/html", "replace");
            txtArea1.document.write(tab_text);
            txtArea1.document.close();
            txtArea1.focus();
            sa = txtArea1.document.execCommand("SaveAs", true, "download.xls");
        }
        else                 //other browser not tested on IE 11
            sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));

        return (sa);
    }
</script>