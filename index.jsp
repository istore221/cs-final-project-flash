<!DOCTYPE html>
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
                        <button type="button" class="btn btn-primary" style="width: 100%;" id="btnSA">Calculate</button>
                        <br/><br/>
                        <button type="button" class="btn btn-success" style="width: 100%;" id="btnDwnSA">Download Excel</button>
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
                        <br/><br/>
                        <button type="button" class="btn btn-success" style="width: 100%;" id="btnDwnGA">Download Excel</button>
                    </form>
                </div>
            </div>
        </div>
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
                                <th>#</th>
                                <th>Student Name</th>
                                <th>Preferences</th>
                                <th>Current Project</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>1. A <br />2. B <br />3. C <br />4. D</td>
                                <td>D</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>1. A <br />2. B <br />3. C <br />4. D</td>
                                <td>D</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>1. A <br />2. B <br />3. C <br />4. D</td>
                                <td>D</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title"><b><font size="4" color="#08298A" face="Agency FB">Summary - Simulated Annealing</font></b></h3>
                </div>
                <div class="panel-body">
                    <b>Weight : </b><hr />
                    <b>Time taken to run : </b><hr />
                    <b>Validity : </b><hr />

                    <iframe id="txtArea1" style="display:none"></iframe>
                    <button type="button" class="btn btn-success btn-lg btn-block" onclick="fnExcelReport();">Export To Excel</button>
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
        document.getElementById("btnDwnSA").disabled = true;
        document.getElementById("btnDwnGA").disabled = true;
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

    //Only two Numbers
    var max_chars = 2;
    $("#no_OfProjects").keyup(function (e) {
        if ($(this).val().length >= max_chars) {
            $(this).val($(this).val().substr(0, max_chars));
        }
    });

    var max_charsSA = 3;
    $("#sa_no_OfTime").keyup(function (e) {
        if ($(this).val().length >= max_charsSA) {
            $(this).val($(this).val().substr(0, max_charsSA));
        }
    });

    var max_charsGA = 3;
    $("#ga_no_OfTime").keyup(function (e) {
        if ($(this).val().length >= max_charsGA) {
            $(this).val($(this).val().substr(0, max_charsGA));
        }
    });

    var max_charsGAgen = 3;
    $("#ga_no_OfGen").keyup(function (e) {
        if ($(this).val().length >= max_charsGAgen) {
            $(this).val($(this).val().substr(0, max_charsGAgen));
        }
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
                        alert(data.trim());
                        document.getElementById("options_sa").disabled = false;
                        document.getElementById("options_ga").disabled = false;
                    },
                    contentType: false,
                    processData: false
                });
                
            }
        }
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
        document.getElementById("btnDwnSA").disabled = true;
        document.getElementById("btnDwnGA").disabled = true;
        document.getElementById("ga_no_OfGen").disabled = true;

        $('#options_sa').prop('checked', false);
        $('#options_ga').prop('checked', false);
    });

    $('input:radio[name="optionsRadios"]').change(
            function () {
                if ($(this).is(':checked') && $(this).val() == 'options_sa') {
                    document.getElementById("sa_no_OfTime").disabled = false;
                    document.getElementById("btnSA").disabled = false;
                    document.getElementById("btnDwnSA").disabled = false;

                    document.getElementById("ga_no_OfTime").disabled = true;
                    document.getElementById("btnGA").disabled = true;
                    document.getElementById("btnDwnGA").disabled = true;
                    document.getElementById("ga_no_OfGen").disabled = true;

                    $('#ga_no_OfTime').val("");
                    $('#ga_no_OfGen').val("");
                }

                if ($(this).is(':checked') && $(this).val() == 'options_ga') {
                    document.getElementById("ga_no_OfTime").disabled = false;
                    document.getElementById("btnGA").disabled = false;
                    document.getElementById("btnDwnGA").disabled = false;
                    document.getElementById("ga_no_OfGen").disabled = false;

                    document.getElementById("sa_no_OfTime").disabled = true;
                    document.getElementById("btnSA").disabled = true;
                    document.getElementById("btnDwnSA").disabled = true;

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