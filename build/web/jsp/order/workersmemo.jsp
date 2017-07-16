<%-- 
    Document   : vouchers
    Created on : 23 Mar, 2015, 9:55:50 PM
    Author     : Lenovo
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<html:html>
    <head>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <title><%= session.getAttribute("brand")%> | Memo Issue</title>

        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/bootstrap-popover.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <script>
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({});
            });
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#wm').dataTable({
                    "bSort": false
                });
            });

            $(function () {
                $("#date").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            $(function () {
                $("#readydate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            function onAddVoucher(type)
            {
                var form = document.forms[0];
                if (form.workermemono.value === "")
                {
                    alert("Please enter worker memo no.");
                    form.workermemono.focus();
                    return false;
                }
                if (form.date.value === "")
                {
                    alert("Please enter date");
                    form.date.focus();
                    return false;
                }
                
                if (form.goldweight.value === "0.0" && form.silverweight.value === "0.0")
                {
                    alert("Please enter Gold weight or Silverweight");
                    form.goldweight.focus();
                    return false;
                }
                if (form.goldweight.value === "")
                {
                    alert("Please enter Gold weight");
                    form.goldweight.focus();
                    return false;
                }
                if (form.silverweight.value === "")
                {
                    alert("Please enter Silverweight");
                    form.goldweight.focus();
                    return false;
                }
                
                if (type === "add") {
                    var form = document.forms[0];
                    var URL = "workmemo.do?method=addWorkMemo&transtype=add";
                    form.action = URL;
                    form.submit();

                    var URL = "workmemo.do?method=viewPrintPage";
                    window.open(document.action = URL);
                    document.forms[0].submit();

                } else {
                    var form = document.forms[0];
                    var URL = "workmemo.do?method=addWorkMemo&transtype=update";
                    form.action = URL;
                    form.submit();

                    if (form.date.value === true) {
                        var URL = "workmemo.do?method=viewPrintPage";
                        window.open(document.action = URL);
                        document.forms[0].submit();
                    }
                }

            }
            function onReset()
            {
                var form = document.forms[0];

                var type = confirm("Do you want to clear the form data ?");
                if (type) {
                    var form = document.forms[0];
                    var URL = "workmemo.do?method=clearWorkMemo";
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }

            function onremoveVoucher(index)
            {
                var form = document.forms[0];

                var type = confirm("Do you want to remove Voucher ?");
                if (type) {
                    var form = document.forms[0];
                    var URL = "workmemo.do?method=removeWorkersMemo&index=" + index;
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }
            function oneditVoucher(index)
            {
                var form = document.forms[0];
                var URL = "workmemo.do?method=editWorkersMemo&index=" + index;
                form.action = URL;
                form.submit();

            }
            function onSelectEmployee(empid)
            {
                var form = document.forms[0];
                var URL = "workmemo.do?method=pickEmployee&employeeid=" + empid;
                form.action = URL;
                form.submit();

            }
            function onLoadMemos()
            {
                var type = confirm("Kindly save all unsaved Memos entry before loading existing Memos. Do you want to Proceed with Memo Loading ? ");
                if (type) {
                    var form = document.forms[0];
                    var URL = "workmemo.do?method=loadWorkersMemos";
                    form.action = URL;
                    form.submit();
                } else {
                    var form = document.forms[0];
                    var URL = "workmemo.do?method=loadWorkMemoPage";
                    form.action = URL;
                    form.submit();
                }
            }
            function onPrintView(index) {

                var form = document.forms[0];
                var URL = "workmemo.do?method=printMemo&index=" + index;
                form.action = URL;
                form.submit();

                var URL = "workmemo.do?method=viewPrintPage";
                window.open(document.action = URL);
                document.forms[0].submit();

            }
            window.setTimeout(function () {
                $(".alert").fadeTo(500, 0).slideUp(500, function () {
                    $(this).remove();
                });
            }, 4000);
        </script>
        <style>
            body { 
                background: url(images/ps_neutral.png) repeat scroll left bottom #dbd9d3; 
            }
        </style>
    </head>
    <body>
        <jsp:include page="/jsp/common/orderheader.jsp" />
        <html:form>
            <div class="container">
                <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="gohome.do?method=displayAppHome"><%= session.getAttribute("brand")%></a>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="gohome.do?method=displayOrderHome">Home</a></li>
                                <li><a href="vouchers.do?method=loadVouchersPage">Vouchers</a></li>
                                <li class="active"><a href="workmemo.do?method=loadWorkMemoPage">Memo Issue</a></li>
                                <li><a href="memoaccept.do?method=loadMemoAcceptPage">Memo Settlement</a></li>
                                <li><a href="transreport.do?method=loadTransactionPage">GS 11</a></li>
                                <li><a href="gs12.do?method=loadGS12Page">GS 12</a></li>
                                <li><a href="memoreport.do?method=loadReportPage">Memo Report</a></li>
                                <li><a href="orstock.do?method=loadOrnamentStock">Stock</a></li>
                                <li><a href="sales.do?method=loadSalesPage">Sales</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Masters<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="voucherlist.do?method=loadVoucherListPage">Vouchers</a></li>
                                        <li><a href="workmemolist.do?method=loadWorkersMemoListPage">Workers Memos</a></li>
                                        <li><a href="stock.do?method=loadStock" title="GOLD SILVER DIAMOND STONES PEARLS">Stock- Gold, Silver Stone &AMP; Pearls</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="masterdata.do?method=loadMasterDataPage">Master Data</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="../navbar/"></a></li>
                                <li><a href="#"  style="font-style: italic;"t class="text text-info"><bean:write  name="userName" /></a></li>
                                <li class="active"><a href="logout.do?method=logout">Logout</a></li>
                            </ul>
                        </div><!--/.nav-collapse -->
                    </div>
                </div>
                <html:hidden property="print"/>
                <logic:notEmpty property="message" name="WorkersMemoForm">
                    <div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <bean:write name="WorkersMemoForm" property="message" />
                    </div>
                </logic:notEmpty>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <a data-toggle="collapse" href="#collapseOne">
                            <h3 class="panel-title" style="color: white">Memo Issue</h3>
                        </a>
                    </div>
                    <div class="panel-body panel-collapse collapse in" id="collapseOne" >
                        <table class="table-condensed">
                            <tr>
                                <td>Memo No.*</td>
                                <td><html:text property="workermemono" styleClass="form-control"/></td>
                                <td>Date *</td>
                                <td> 
                                    <html:text alt="dd-mm-yyyy" property="date" styleId="date"  title="dd/mm/yyyy" styleClass="form-control"/>
                                </td>
                                <td>Worker *</td>
                                <td><html:text property="employee" styleClass="form-control" readonly="true"/></td>

                                <td>
                                    <button type="button" class="btn btn-success btn-sm" aria-label="Pick Worker" data-toggle="modal" data-target="#employees">
                                        <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td>Order No</td>
                                <td><html:text property="orderno" styleClass="form-control"/></td>
                                <td>Jewel Details</td>
                                <td><html:textarea property="jewel" styleClass="form-control" /></td>
                                <td>Size/Length</td>
                                <td><html:text property="size" styleClass="form-control" onfocus="this.value='';"/></td>

                                <td>Net weight</td>
                                <td><html:text property="netweight" styleClass="form-control" onfocus="this.value='';"/></td>
                            </tr>
                            <tr>
                                <td>Gold issued *</td>
                                <td><html:text property="goldweight" styleClass="form-control" onfocus="this.value='';"/></td>
                                <td>Silver issued *</td>
                                <td><html:text property="silverweight" styleClass="form-control" onfocus="this.value='';"/></td>
                                <!-- <td>Stones issued</td>
                                 <td><html:text property="stoneweight" styleClass="form-control" onfocus="this.value='';"/></td>
                                 <td>Diamond issued</td>
                                 <td><html:text property="diamondweight" styleClass="form-control" onfocus="this.value='';"/></td>
                                -->
                                <td>Jewel to be ready by</td>
                                <td>     
                                    <html:text alt="dd-mm-yyyy" property="readydate" styleId="readydate"  title="dd/mm/yyyy" styleClass="form-control"/>
                                </td>
                                <td>Remarks</td>
                                <td><html:textarea property="remarks" styleClass="form-control" /></td>

                                <td></td><td></td>
                            </tr>

                        </table>
                    </div>
                    <div class="panel-footer text-right">
                        <html:button styleId="add" property="method" onclick="onAddVoucher('add')" value="Submit" styleClass="btn btn-sm btn-primary"/>
                        <html:button styleId="Reset" property="method" onclick="onReset()" value="Reset" styleClass="btn btn-sm btn-default"/>
                    </div>
                </div>


                <div class="modal fade" id="employees" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Workers List</h4>
                            </div>
                            <div class="modal-body">
                                <table id="example" class="table table-bordered" style="font-size: 13px">
                                    <thead>
                                        <tr>
                                            <th>Worker</th>
                                        </tr>
                                    </thead> 
                                    <tbody>
                                        <logic:iterate id="details" name="WorkersMemoForm" property="lstEmp" indexId="index">
                                            <tr>
                                                <td><html:hidden name="details" property="employeeid"/>
                                                    <a href="#" onclick="onSelectEmployee('<bean:write name="details" property="employeeid"/>')"> 
                                                        <b><bean:write name="details" property="name" /></b>
                                                    </a>
                                                </td>
                                            </tr>

                                        </logic:iterate>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>

                <button class="btn btn-sm btn-primary" onclick="onLoadMemos();">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Worker Memos
                </button>
                <br/>
                <br/>
                <table class="table table-condensed table-striped table-bordered" id="wm">
                    <thead>
                        <tr>
                            <th>Memo No</th>
                            <th>Date</th>
                            <th>Order No</th>
                            <th>Employee</th>
                            <th>Jewel Details</th>
                            <th>Size</th>
                            <th>Net Weight</th>
                            <th>Gold Weight</th>
                            <th>Silver Weight</th>
                            <th>Stones Weight</th>
                            <th>Diamond Weight</th>
                            <th>Ready by</th>
                            <th>Remarks</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <logic:notEmpty name="WorkersMemoForm" property="lstWorkersMemo">
                            <logic:iterate id="details" name="WorkersMemoForm" property="lstWorkersMemo" indexId="index">
                                <tr>
                                    <td><bean:write name="details" property="workermemono" /></td>
                                    <td><bean:write name="details" property="date" /></td>
                                    <td><bean:write name="details" property="orderno" /></td>
                                    <td><bean:write name="details" property="employee" /></td>
                                    <td><bean:write name="details" property="jewel" /></td>
                                    <td><bean:write name="details" property="size" /></td>
                                    <td><bean:write name="details" property="netweight" /></td>
                                    <td><bean:write name="details" property="goldweight" format="##0.000"/></td>
                                    <td><bean:write name="details" property="silverweight" format="##0.000"/></td>
                                    <td><bean:write name="details" property="stoneweight" format="##0.000"/></td>
                                    <td><bean:write name="details" property="diamondweight" format="##0.000"/></td>
                                    <td><bean:write name="details" property="readydate" /></td>
                                    <td><bean:write name="details" property="remarks" /></td>
                                    <td width="90px">
                                        <button title="Edit" onclick="oneditVoucher('<bean:write name="details" property="workersmemoid"/>')" value="Edit" class="btn btn-xs btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>
                                        <button title="Delete" onclick="onremoveVoucher('<bean:write name="details" property="workersmemoid"/>')" value="Delete" class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
                                        <button title="Print" onclick="onPrintView('<bean:write name="details" property="workersmemoid"/>')" value="Print" class="btn btn-xs btn-primary"><span class="glyphicon glyphicon-print"></span></button>
                                    </td>
                                </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                    </tbody>
                </table>
            </div>
        </html:form>
    </body>
</html:html>
