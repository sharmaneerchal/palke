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
        <title><%= session.getAttribute("brand")%> | Master Data</title>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/bootstrap-popover.js"></script>

        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script>
            $(document).ready(function() {
                // $('#example').dataTable();
                $('#example').dataTable({});
            });
            $(document).ready(function() {
                // $('#example').dataTable();
                $('#example1').dataTable({});
            });

            $(function() {
                $("#date").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });

            $(function() {
                $("#jeweldate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            function onSaveEmployee()
            {
                var form = document.forms[0];
                if (form.name.value === '') {
                    alert("Enter Employee Name.");
                    form.name.focus();
                    return false;
                }
                var URL = "masterdata.do?method=saveEmployee";
                form.action = URL;
                form.submit();

            }
            function onSaveItem()
            {
                var form = document.forms[0];
                if (form.item.value === '') {
                    alert("Enter Item Name.");
                    form.item.focus();
                    return false;
                }
                var URL = "masterdata.do?method=saveItem";
                form.action = URL;
                form.submit();
            }
            function reetBalance()
            {
                var form = document.forms[0];

                var URL = "masterdata.do?method=resetBalance";
                form.action = URL;
                form.submit();
            }
            function editEmployee(employeeid, name, contact, address, joindate)
            {
                var form = document.forms[0];
                form.employeeid.value = employeeid;
                form.empid.value = employeeid;
                form.name.value = name;
                form.contactno.value = contact;
                form.address.value = address;
                form.date.value = joindate;
            }
            function editItem(itemid, item, itemcode)
            {
                var form = document.forms[0];
                form.itemid.value = itemid;
                form.itmid.value = itemid;
                form.itemcode.value = itemcode;
                form.item.value = item;
            }
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
                                <li><a href="sales.do?method=loadSalesPage">Sales</a></li>
                                <li class="dropdown active">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Masters<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="voucherlist.do?method=loadVoucherListPage">Vouchers</a></li>
                                        <li><a href="workmemolist.do?method=loadWorkersMemoListPage">Workers Memos</a></li>
                                        <li><a href="stock.do?method=loadStock" title="GOLD SILVER DIAMOND STONES PEARLS">Stock- Gold, Silver Stone &AMP; Pearls</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li class="active"><a href="masterdata.do?method=loadMasterDataPage">Master Data</a></li>
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

                <p class="panel-title text-muted"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Master Data</p><br/>

                <div class="row">
                    <div class="col-lg-8">
                        <div class="bs-component">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class=" panel-title">Employee Master</h3>
                                </div>
                                <div class="panel-body">
                                    <a class="btn-link" data-toggle="modal" data-target="#employeepanel">
                                        <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add new
                                    </a>
                                    <br/><br/>
                                    <table id="example" class="display">
                                        <thead>
                                            <tr>
                                                <th>Employee No</th>
                                                <th>Name</th>
                                                <th>Contact No</th>
                                                <th>Address</th>
                                                <th>Join Date</th>
                                                <th></th>
                                            </tr>
                                        </thead> 
                                        <tbody>
                                            <logic:notEmpty name="MasterDataForm" property="lstEmp">
                                                <logic:iterate id="details" name="MasterDataForm" property="lstEmp" indexId="index">
                                                    <tr>
                                                        <td><bean:write name="details" property="employeeid" /></td>
                                                        <td><bean:write name="details" property="name" /></td>
                                                        <td><bean:write name="details" property="contactno" /></td>
                                                        <td><bean:write name="details" property="address" /></td>
                                                        <td><bean:write name="details" property="joindate" /></td>
                                                        <td><a title="Edit" href="#" data-toggle="modal" data-target="#employeepanel" onclick="editEmployee('<bean:write name="details" property="employeeid"/>', '<bean:write name="details" property="name" />', '<bean:write name="details" property="contactno" />', '<bean:write name="details" property="address" />', '<bean:write name="details" property="joindate" />')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                                                    </tr>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="bs-component">

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Item Master</h3>
                                </div>
                                <div class="panel-body">
                                    <a class="btn-link" data-toggle="modal" data-target="#itempanel">
                                        <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add new
                                    </a>
                                    <br/><br/>
                                    <table id="example1" class="display">
                                        <thead>
                                            <tr>
                                                <th>Item</th>
                                                <th>Item Code</th>
                                                <th></th>
                                            </tr>
                                        </thead> 
                                        <tbody>
                                            <logic:notEmpty name="MasterDataForm" property="lstItems">
                                                <logic:iterate id="details" name="MasterDataForm" property="lstItems">
                                                    <tr>
                                                        <td>
                                                            <html:hidden name="details" property="itemid" />
                                                            <bean:write name="details" property="item" />
                                                        </td>
                                                        <td>
                                                            <bean:write name="details" property="itemcode" />
                                                        </td>
                                                        <td>
                                                            <a data-toggle="modal" data-target="#itempanel" title="Edit" href="#" onclick="editItem('<bean:write name="details" property="itemid" />', '<bean:write name="details" property="item" />', '<bean:write name="details" property="itemcode" />')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
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
                </div>   

                <html:button property="method" value="Reset Balance Values" onclick="reetBalance()" styleClass="btn  btn-info btn-sm"/>

                <logic:notEmpty property="message" name="MasterDataForm">
                    <div class="alert alert-danger">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <bean:write name="MasterDataForm" property="message" />
                    </div>
                </logic:notEmpty>
                <div class="modal fade" id="employeepanel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Employee</h4>
                            </div>
                            <div class="modal-body">
                                <table class="table-condensed">
                                    <tr>
                                        <td>Name</td>
                                        <td>
                                            <html:hidden styleId="empid" name="MasterDataForm" property="employeeid"/>
                                            <html:hidden styleId="employeeid" property="employee.employeeid"/>
                                            <html:text styleId="name" property="employee.name" styleClass="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Contact No.</td>
                                        <td>
                                            <html:text styleId="contactno" property="employee.contactno" styleClass="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Address</td>
                                        <td>
                                            <html:text styleId="address" property="employee.address" styleClass="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <html:button property="method" value="Submit" onclick="onSaveEmployee()" styleClass="btn  btn-info btn-sm"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="itempanel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Item</h4>
                            </div>
                            <div class="modal-body">
                                <table class="table-condensed">
                                    <tr>
                                        <td>Item</td>
                                        <td>
                                            <html:hidden styleId="itmid" name="MasterDataForm" property="itemid"/>
                                            <html:hidden styleId="itemid" property="item.itemid"/>
                                            <html:text styleId="item" property="item.item" styleClass="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Item Code</td>
                                        <td>
                                            <html:text styleId="itemcode" property="item.itemcode" styleClass="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <html:button property="method" value="Submit" onclick="onSaveItem()" styleClass="btn  btn-info btn-sm"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </html:form>
    </body>
</html:html>
