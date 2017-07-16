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
        <title><%= session.getAttribute("brand")%> | Vouchers</title>

        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/bootstrap-popover.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">

        <script>

            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({});
            });
            $(function () {
                $("#date").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            $(function () {
                $("#date2").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            function onchangeCategory(type, idval) {
                var form = document.forms[0];
                form.category.value = type;

                document.getElementById("1").className = 'btn btn-sm btn-default';
                document.getElementById("2").className = 'btn btn-sm btn-default';
                document.getElementById("3").className = 'btn btn-sm btn-default';
                document.getElementById("4").className = 'btn btn-sm btn-default';
                document.getElementById("5").className = 'btn btn-sm btn-default';
                document.getElementById("6").className = 'btn btn-sm btn-default';
                document.getElementById("7").className = 'btn btn-sm btn-default';
                document.getElementById("8").className = 'btn btn-sm btn-default';
                document.getElementById("9").className = 'btn btn-sm btn-default';
                document.getElementById("10").className = 'btn btn-sm btn-default';

                document.getElementById(idval).className = 'btn btn-sm btn-primary';
            }
            function onchangeVoucher(type) {
                var form = document.forms[0];
                form.vouchertype.value = type;
                //document.getElementById('lb').value = type;

                if (type === 'Receipt Voucher') {
                    document.getElementById("two").style.display = 'none';
                    document.getElementById("one").style.display = 'block';
                    document.getElementById("amt").style.display = 'none';
                    document.getElementById("amt1").style.display = 'none';
                    document.getElementById('pv').className = 'btn btn-large btn-default';
                    document.getElementById('rv').className = 'btn btn-large btn-primary';
                }
                if (type === 'Purchase Voucher') {
                    document.getElementById("two").style.display = 'block';
                    document.getElementById("one").style.display = 'none';
                    document.getElementById("amt").style.display = 'block';
                    document.getElementById("amt1").style.display = 'block';
                    document.getElementById('rv').className = 'btn btn-large btn-default';
                    document.getElementById('pv').className = 'btn btn-large btn-primary';
                }

            }

            function onAddVoucher(type, vouchertype)
            {
                var form = document.forms[0];

                if (type === "add") {
                    var form = document.forms[0];
                    var URL = "vouchers.do?method=saveVouchers&transtype=add&vouchertype=" + vouchertype;
                    form.action = URL;
                    form.submit();
                } else {
                    var form = document.forms[0];
                    var URL = "vouchers.do?method=saveVouchers&transtype=update&vouchertype=" + vouchertype;
                    form.action = URL;
                    form.submit();
                }

            }
            function onReset()
            {
                var form = document.forms[0];

                var type = confirm("Do you want to clear the form data ?");
                if (type) {
                    var form = document.forms[0];
                    var URL = "vouchers.do?method=cancelVocuher";
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }
            function deleteVoucher(voucherid, category)
            {
                var form = document.forms[0];

                var type = confirm("Do you want to delete the voucher ?");
                if (type) {
                    var form = document.forms[0];
                    var URL = "vouchers.do?method=deleteVouchers&voucherid=" + voucherid + "&category=" + category;
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }
            function oneditVoucher(index)
            {
                var form = document.forms[0];
                var URL = "vouchers.do?method=editVoucher&index=" + index;
                form.action = URL;
                form.submit();

            }

            function onchangeType(type) {
                var form = document.forms[0];
                var URL = "vouchers.do?method=loadVouchers&vouchertype=" + type;
                form.action = URL;
                form.submit();
            }
            function onPrintView(type, index) {
                if (type === 'Purchase Voucher') {
                    var URL = "vouchers.do?method=printpvVoucher&index=" + index;
                    window.open(document.action = URL);
                    document.forms[0].submit();
                }
                if (type === 'Receipt Voucher') {
                    var URL = "vouchers.do?method=printrvVoucher&index=" + index;
                    window.open(document.action = URL);
                    document.forms[0].submit();
                }
                var form = document.forms[0];
                var URL = "vouchers.do?method=loadVouchers&vouchertype=" + type;
                form.action = URL;
                form.submit();

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
                                <li class="active"><a href="vouchers.do?method=loadVouchersPage">Vouchers</a></li>
                                <li><a href="workmemo.do?method=loadWorkMemoPage">Memo Issue</a></li>
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
                <div class="row">
                    <div class="col-lg-6">
                        <div class="bs-component">
                            <html:hidden styleId="vouchertype" property="vouchertype"/>
                            <html:hidden styleId="category" property="category"/>
                            <!--Purchase Voucher -->
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Purchase Voucher</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="btn-group" role="group" aria-label="...">
                                        <a id="1" onclick="onchangeCategory('Gold', 1)" href="#gold" class="btn btn-sm btn-default" data-toggle="tab">Gold</a>
                                        <a id="2" onclick="onchangeCategory('Copper', 2)" href="#copper" class="btn btn-sm btn-default " data-toggle="tab">Copper</a>
                                        <a id="3" onclick="onchangeCategory('Silver', 3)" href="#silver" class="btn btn-sm btn-default" data-toggle="tab">Silver</a>
                                        <a id="4" onclick="onchangeCategory('Stone, Pearls etc', 4)" href="#stone" class="btn btn-sm btn-default"  data-toggle="tab">Stones &amp; Pearls </a>
                                        <a id="5" onclick="onchangeCategory('Diamonds', 5)" href="#diamonds" class="btn btn-sm btn-default"  data-toggle="tab">Diamonds</a>
                                        <a style="display: none" id="6" onclick="onchangeCategory('Silver Ornaments', 6)" href="#silverornaments" class="btn btn-sm btn-default"  data-toggle="tab">Silver Ornaments</a>
                                        <a style="display: none" id="7"  onclick="onchangeCategory('Gold Ornaments', 7)" href="#goldornaments" class="btn btn-sm btn-default" data-toggle="tab">Gold Ornaments</a>

                                    </div>
                                    <br/><br/>
                                    <table class="table-condensed">
                                        <tr>
                                            <td>Voucher No</td>
                                            <td><html:text property="pvoucherno" styleClass="form-control"/></td>
                                            <td>Date</td>
                                            <td> <html:text property="pvoucherdate" styleId="date"  title="dd/mm/yyyy" styleClass="form-control"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Weight (g)</td>
                                            <td><html:text property="pweight" styleClass="form-control"  onfocus="this.value='';"/></td>

                                            <td Id="amt" >Amount</td>
                                            <td><html:text property="pamount" styleClass="form-control text-right" /></td>
                                        </tr>
                                    </table>

                                </div>
                                <div class="panel-footer text-right">

                                    <logic:equal name="VouchersForm" property="ptranstype" value="add">
                                        <html:button styleId="add" property="method" onclick="onAddVoucher('add','Purchase Voucher')" value="Submit" styleClass="btn  btn-info btn-sm"/>
                                    </logic:equal>
                                    <logic:equal name="VouchersForm" property="ptranstype" value="update">
                                        <html:button styleId="update" property="method" onclick="onAddVoucher('update','Purchase Voucher')" value="Update" styleClass="btn  btn-info btn-sm"/>
                                    </logic:equal>

                                    <html:button styleId="Reset" property="method" onclick="onReset()" value="Reset" styleClass="btn  btn-default btn-sm"/>

                                </div>
                            </div> 
                        </div>
                    </div>
                    <!--Receipt Voucher -->
                    <div class="col-lg-6">
                        <div class="bs-component">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Receipt Voucher</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="btn-group" role="group" aria-label="...">
                                        <a id="8" onclick="onchangeCategory('Gold', 8)" href="#gold" class="btn btn-sm btn-default" data-toggle="tab">Gold</a>
                                        <a id="9" onclick="onchangeCategory('Silver', 9)" href="#silver" class="btn btn-sm btn-default" data-toggle="tab">Silver</a>
                                        <a id="10" onclick="onchangeCategory('Copper', 10)" href="#copper" class="btn btn-sm btn-default" data-toggle="tab">Copper</a>
                                    </div>
                                    <br/> <br/>
                                    <table class="table-condensed">
                                        <tr>
                                            <td>Voucher No</td>
                                            <td><html:text property="rvoucherno" styleClass="form-control"/></td>
                                            <td>Date</td>
                                            <td> <html:text property="rvoucherdate" styleId="date2"  title="dd/mm/yyyy" styleClass="form-control"/>
                                            </td>
                                        </tr>
                                        <tr>  
                                            <td>Weight (g)</td>
                                            <td><html:text property="rweight" styleClass="form-control" onfocus="this.value='';"/></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="panel-footer text-right">
                                    <logic:equal name="VouchersForm" property="rtranstype" value="add">
                                        <html:button styleId="add" property="method" onclick="onAddVoucher('add','Receipt Voucher')" value="Submit" styleClass="btn  btn-info btn-sm"/>
                                    </logic:equal>
                                    <logic:equal name="VouchersForm" property="rtranstype" value="update">
                                        <html:button styleId="update" property="method" onclick="onAddVoucher('update','Receipt Voucher')" value="Update" styleClass="btn  btn-info btn-sm"/>
                                    </logic:equal>  
                                    <html:button styleId="Reset" property="method" onclick="onReset()" value="Reset" styleClass="btn  btn-default btn-sm"/>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <logic:notEmpty property="message" name="VouchersForm">
                    <div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <bean:write name="VouchersForm" property="message" />
                    </div>
                </logic:notEmpty>

                <table class="table-condensed">
                    <tr>
                        <td>  
                            <a onclick="onchangeType('Purchase Voucher')" href="#purhcase" class="btn btn-sm btn-warning" data-toggle="tab">Purchase Voucher</a>
                        </td> 
                        <td>
                            <a onclick="onchangeType('Receipt Voucher')" href="#receipt" class="btn btn-sm btn-success" data-toggle="tab">Receipt Voucher</a>
                        </td> 
                        <td>
                            <a onclick="onchangeType('Workers Memo')" href="#wm" class="btn btn-sm btn-primary" data-toggle="tab">Workers Memo Returns</a>
                        </td> 
                        <td>
                            <a onclick="onchangeType('Transfer from GS12')" href="#wm" class="btn btn-sm btn-info" data-toggle="tab">Transfer from GS12</a>
                        </td> 
                    </tr>
                </table>
                <br/>
                <table class="table table-bordered table-striped" id="example">
                    <thead>
                        <tr>
                            <th>SI. No</th>
                            <th>Voucher Type</th>
                            <th>Category</th>
                            <th>Voucher No</th>
                            <th>Date</th>
                            <th>Weight (g)</th>
                            <th>Amount</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <logic:notEmpty name="VouchersForm" property="lstVouchers">
                            <logic:iterate id="details" name="VouchersForm" property="lstVouchers" indexId="index">
                                <tr>
                                    <td><%=index + 1%><html:hidden name="details" property="voucherid"/></td>
                                    <td><bean:write name="details" property="vouchertype" /></td>
                                    <td><bean:write name="details" property="category" /></td>
                                    <td><bean:write name="details" property="voucherno" /></td>
                                    <td><bean:write name="details" property="voucherdate" /></td>
                                    <td><bean:write name="details" property="weight" format="##0.000"/></td>
                                    <td><bean:write name="details" property="amount" format="##0.00"/></td>
                                    <td>
                                        <button data-toggle="collapse" href="#collapseOne" onclick="oneditVoucher('<bean:write name="index"/>')" value="Edit" class="btn btn-xs btn-info">Edit</button>
                                        <button onclick="deleteVoucher('<bean:write name="details" property="voucherid" />', '<bean:write name="details" property="vouchertype" />')" value="delete" class="btn btn-xs btn-danger">Delete</button>
                                        <logic:equal value="Purchase Voucher" property="vouchertype" name="details">
                                            <button onclick="onPrintView('<bean:write name="VouchersForm" property="vouchertype" />', '<bean:write name="index"/>')" value="Submit" class="btn btn-xs btn-primary"><span class="glyphicon glyphicon-print"></span> Print</button>
                                        </logic:equal>
                                        <logic:equal value="Receipt Voucher" property="vouchertype" name="details">
                                            <button onclick="onPrintView('<bean:write name="VouchersForm" property="vouchertype" />', '<bean:write name="index"/>')" value="Submit" class="btn btn-xs btn-primary"><span class="glyphicon glyphicon-print"></span> Print</button>
                                        </logic:equal>
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
