<%-- 
    Document   : transaction
    Created on : 7 Sep, 2014, 10:56:14 PM
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
        <title><%= session.getAttribute("brand")%> | Ornaments Sales</title>

        <script src="js/bootstrap-popover.js"></script>
        <script src="js/jquery-1.12.4.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <script>
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({
                    "bSort": false
                });
            });
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example1').dataTable({
                    "bSort": false
                });
            });

            $(document).ready(function () {
                // $('#example').dataTable();
                $('#billtable').dataTable({
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
            function onItem(itemid, item)
            {
                var form = document.forms[0];
                var URL = "sales.do?method=loadOrnamentStockDetails&item=" + item + "&itemid=" + itemid;
                form.action = URL;
                form.submit();
            }

            function addOrnaments(jewelcode)
            {
                var form = document.forms[0];
                var URL = "sales.do?method=addOrnament&jewelcode=" + jewelcode;
                form.action = URL;
                form.submit();
            }
            function removeOrnaments(jewelcode)
            {
                var form = document.forms[0];
                var URL = "sales.do?method=removeOrnament&jewelcode=" + jewelcode;
                form.action = URL;
                form.submit();
            }
            function saveSales()
            {
                var form = document.forms[0];
                var URL = "sales.do?method=saveSales";
                form.action = URL;
                form.submit();
            }
            function deleteSales()
            {
                var type = confirm("Do you want to delete Bill ?");
                if (type) {
                    var form = document.forms[0];
                    var URL = "sales.do?method=deletBill";
                    form.action = URL;
                    form.submit();
                } else {
                    var form = document.forms[0];
                    var URL = "#";
                    form.action = URL;
                    form.submit();
                }
            }

            function resetForm()
            {
                var form = document.forms[0];
                var URL = "sales.do?method=clearForm";
                form.action = URL;
                form.submit();
            }
            function loadSales()
            {
                var form = document.forms[0];
                var URL = "sales.do?method=loadOrnamentSales";
                form.action = URL;
                form.submit();
            }
            function openBill(salesid)
            {
                var form = document.forms[0];
                var URL = "sales.do?method=openBill&salesid=" + salesid;
                form.action = URL;
                form.submit();
            }
            function updatePanel(index, jewelcode, totalgold, revgross, revnet, revwaste, stonetype)
            {
                document.getElementById("stockid").value = index;
                document.getElementById("jewelcode").value = jewelcode;
                document.getElementById("revwaste").value = revwaste.toFixed(3);
                document.getElementById("revgross").value = revgross.toFixed(3);
                document.getElementById("revnet").value = revnet.toFixed(3);
                document.getElementById("totalgold").value = totalgold.toFixed(3);
                document.getElementById("stonetype").value = stonetype;
            }
            function update()
            {
                var form = document.forms[0];
                var URL = "sales.do?method=updateOrnamentValues&index=" + document.getElementById("stockid").value;
                form.action = URL;
                form.submit();
            }
            function onchangeweight()
            {
                document.getElementById("totalgold").value = parseFloat(document.getElementById("revnet").value) + parseFloat(document.getElementById("revwaste").value);

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
                                <li><a href="workmemo.do?method=loadWorkMemoPage">Memo Issue</a></li>
                                <li><a href="memoaccept.do?method=loadMemoAcceptPage">Memo Settlement</a></li>
                                <li><a href="transreport.do?method=loadTransactionPage">GS 11</a></li>
                                <li><a href="gs12.do?method=loadGS12Page">GS 12</a></li>
                                <li><a href="memoreport.do?method=loadReportPage">Memo Report</a></li>
                                <li><a href="orstock.do?method=loadOrnamentStock">Stock</a></li>
                                <li class="active"><a href="sales.do?method=loadSalesPage">Sales</a></li>
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
                <button title="Load existing Bill"  class="btn btn-sm btn-primary" data-toggle="modal" data-target="#bills"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Sales Bills
                </button>
                <logic:notEqual name="SalesForm" property="salesid" value="0">
                    <button  title="Delete Bill"  class="btn btn-sm btn-danger" onclick="deleteSales();">Delete Bill : <bean:write name="SalesForm" property="billno" /></button>
                </logic:notEqual>
                <h5 style="float: right">Bill Reference No <span class="label label-primary"> <bean:write name="SalesForm" property="salesid" /></span></h5>
                <br/><br/>
                <logic:notEmpty property="message" name="SalesForm">
                    <div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <b><bean:write name="SalesForm" property="message" /></b>
                    </div>
                </logic:notEmpty>

                <div class="panel-group" id="accordion">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Ornament Stock</a>
                                <span class="label label-default" style="font-size: 16px;float: right;">
                                    <bean:write name="SalesForm" property="item" />
                                </span>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <div class="btn-group btn-group-sm">
                                    <logic:notEmpty name="SalesForm" property="lstItems">
                                        <logic:iterate id="details" name="SalesForm" property="lstItems">
                                            <a  href="#" onclick="onItem(<bean:write name="details" property="itemid"/>, '<bean:write name="details" property="item"/>')" class="btn btn-primary"><bean:write name="details" property="item"/></a>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </div>
                                <br/><br/>
                                <!-- Table -->
                                <table id="example1" class="table table-condensed table-striped">
                                    <thead style="font-size: 12px">
                                        <tr>
                                            <th>Memo No</th>
                                            <th>Item &amp; Description</th>
                                            <th>Jewel Code</th>
                                            <th>Gross weight (g)</th>
                                            <th>Net weight (g)</th>
                                            <th>Wastage (g)</th>
                                            <th>Total Gold (g)</th>  
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <logic:notEmpty name="SalesForm" property="lstornaments">
                                            <logic:iterate id="details" name="SalesForm" property="lstornaments" indexId="index">
                                                <tr>
                                                    <td><bean:write name="details" property="memono" /></td>
                                                    <td><bean:write name="details" property="description" /></td>
                                                    <td><span class="text-danger"><bean:write name="details" property="ornamentstockno"/></span></td>
                                                    <td><bean:write name="details" property="revgrossweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revnetweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revwastage" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revtotalglodused" format="##0.000"/></td>
                                                    <td>   
                                                        <logic:equal name="details" property="revtotalglodused" value="0.0">
                                                            <button title="Update Jewel Details"  class="btn btn-xs btn-primary" data-toggle="modal" data-target="#payments" 
                                                                    onclick="updatePanel(<bean:write name="details" property="ornamentstockid"/>, '<bean:write name="details" property="ornamentstockno"/>', <bean:write name="details" property="totalglodused"/>, <bean:write name="details" property="grossweight"/>, <bean:write name="details" property="netweight"/>, <bean:write name="details" property="wastage"/>, '<bean:write name="details" property="stonetype"/>');">
                                                                Update
                                                            </button>
                                                        </logic:equal>
                                                        <logic:notEqual name="details" property="revtotalglodused" value="0">
                                                            <button title="Update Jewel Details"  class="btn btn-xs btn-primary" data-toggle="modal" data-target="#payments" 
                                                                    onclick="updatePanel(<bean:write name="details" property="ornamentstockid"/>, '<bean:write name="details" property="ornamentstockno"/>',<bean:write name="details" property="totalglodused"/>, <bean:write name="details" property="revgrossweight"/>, <bean:write name="details" property="revnetweight"/>, <bean:write name="details" property="revwastage"/>, '<bean:write name="details" property="stonetype"/>');">
                                                                Update
                                                            </button>
                                                        </logic:notEqual>

                                                        <button title="Add Jewel"  class="btn btn-xs btn-success" onclick="addOrnaments(<bean:write name="details" property="ornamentstockid"/>);">Add
                                                        </button>
                                                    </td>
                                                </tr>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Ornament Added</a>
                                <span style="font-size: 14px;">
                                    (<b><bean:write name="SalesForm" property="count" /></b>)
                                </span>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <div class="panel-body">
                                <table class="table table-striped table-condensed" id="example" >
                                    <thead style="font-size: 12px">
                                        <tr>
                                            <th>Memo No</th>
                                            <th>Item &amp; Description</th>
                                            <th>Jewel Code</th>
                                            <th>Gross weight (g)</th>
                                            <th>Net weight (g)</th>
                                            <th>Wastage (g)</th>  
                                            <th>Total Gold (g)</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <logic:notEmpty name="SalesForm" property="lstoradded">
                                            <logic:iterate id="details" name="SalesForm" property="lstoradded" indexId="index">
                                                <tr>
                                                    <td><bean:write name="details" property="memono" /></td>
                                                    <td><bean:write name="details" property="description" /></td>
                                                    <td><span class="text-danger"><bean:write name="details" property="ornamentstockno"/></span></td>
                                                    <td><bean:write name="details" property="revgrossweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revnetweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revwastage" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revtotalglodused" format="##0.000"/></td>

                                                    <td>
                                                        <button title="Remove"  class="btn btn-sm btn-danger"  
                                                                onclick="removeOrnaments(<bean:write name="details" property="ornamentstockid"/>);"> <span class="glyphicon glyphicon-trash"></span>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Bill Details</a>
                            </h4>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse">
                            <div class="panel-body">
                                <table class="table-condensed">
                                    <tr>
                                        <td>Bill No. </td>
                                        <td>
                                            <html:text styleId="billno" name="SalesForm" property="billno" styleClass="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Bill Date</td>
                                        <td>
                                            <html:text property="billdate" styleId="date"  title="dd/mm/yyyy" styleClass="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Amount</td>
                                        <td>
                                            <html:text styleId="amount" name="SalesForm" property="billamount" styleClass="form-control" onfocus="this.value='';"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Discount Amount</td>
                                        <td>
                                            <html:text styleId="discamount" name="SalesForm" property="discount" styleClass="form-control" onfocus="this.value='';"/>
                                        </td>
                                    </tr>
                                </table>

                            </div>
                            <div class="panel-footer">
                                <button title="Save bill"  class="btn btn-primary btn-sm"  
                                        onclick="saveSales();"> Submit
                                </button>
                                <button title="Reset"  class="btn btn-default btn-sm"  
                                        onclick="resetForm();"> Reset
                                </button>

                            </div>
                        </div>
                    </div>
                </div> 

                <div class="modal fade" id="bills" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Bills</h4>
                            </div>
                            <div class="modal-body">
                                <table id="billtable" class="table table-condensed" >
                                    <thead>
                                        <tr>
                                            <th>Bill Ref No</th>
                                            <th>Bill No</th>
                                            <th>Bill Date</th>
                                            <th>Bill Amount</th>
                                            <th>Discounts</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <logic:notEmpty name="SalesForm" property="lstbills">
                                            <logic:iterate id="details" name="SalesForm" property="lstbills" indexId="index">
                                                <tr>
                                                    <td><bean:write name="details" property="salesid"/></td>
                                                    <td><bean:write name="details" property="billno" /></td>
                                                    <td><bean:write name="details" property="billdate" /></td>
                                                    <td><bean:write name="details" property="billamount" format="##0.00"/></td>
                                                    <td><bean:write name="details" property="discounts" format="##0.00"/></td>
                                                    <td>   
                                                        <button title="Open Bill"  class="btn btn-xs btn-primary" onclick="openBill(<bean:write name="details" property="salesid"/>);">Open
                                                        </button>
                                                    </td>
                                                </tr>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>             
                <!-- ornament added detailed list -->
                <div class="modal fade" id="added" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Detailed Ornament Added</h4>
                            </div>
                            <div class="modal-body">
                                <table class="display" id="example" >
                                    <thead style="font-size: 12px">
                                        <tr>
                                            <th>Jewel Code</th>
                                            <th>Item &amp; Description</th>
                                            <th>Memo No</th>
                                            <th>Gross weight (g)</th>
                                            <th>Net weight (g)</th>
                                            <th>Wastage (g)</th>  
                                            <th>Total Gold (g)</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <logic:notEmpty name="SalesForm" property="lstoradded">
                                            <logic:iterate id="details" name="SalesForm" property="lstoradded" indexId="index">
                                                <tr>
                                                    <td><span class="text-danger"><bean:write name="details" property="ornamentstockno"/></span></td>
                                                    <td><bean:write name="details" property="description" /></td>
                                                    <td><bean:write name="details" property="memono" /></td>
                                                    <td><bean:write name="details" property="revgrossweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revnetweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revwastage" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="revtotalglodused" format="##0.000"/></td>

                                                    <td>
                                                        <button title="Remove"  class="btn btn-sm btn-danger"  
                                                                onclick="removeOrnaments(<bean:write name="details" property="ornamentstockid"/>);"> <span class="glyphicon glyphicon-trash"></span>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>             

                <div class="modal fade" id="payments" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"  >
                    <div class="modal-dialog" style="width: 400px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Update Ornament Details</h4>
                            </div>
                            <div class="modal-body">
                                <table class="table-condensed">
                                    <tr>
                                        <td>Jewel Code</td>
                                        <td><input style="display: none" id="stockid"/>
                                            <input readonly="true" id="jewelcode" class="form-control input" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Revised Gross weight</td>
                                        <td>
                                            <html:text  styleId="revgross" name="SalesForm" property="revgrossweight" styleClass="form-control"  onfocus="this.value='';"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Revised Net weight</td>
                                        <td>
                                            <html:text onchange="onchangeweight()" styleId="revnet" name="SalesForm" property="revnetweight" styleClass="form-control"  onfocus="this.value='';"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Revised wastage</td>
                                        <td>
                                            <html:text onchange="onchangeweight()" styleId="revwaste" name="SalesForm" property="revwastage" styleClass="form-control"  onfocus="this.value='';"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Revised Total Gold</td>
                                        <td>
                                            <input readonly="true" id="totalgold" class="form-control" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Stone Type</td>
                                        <td>
                                            <html:text styleId="stonetype" name="SalesForm" property="stonetype" styleClass="form-control" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button onclick="update();" value="Update" class="btn btn-sm btn-primary">Update</button>
                                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </html:form>
    </body>
</html:html>