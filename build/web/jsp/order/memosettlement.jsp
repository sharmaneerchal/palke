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
        <title><%= session.getAttribute("brand")%> | Memo Settlement</title>
        <script src="js/bootstrap-popover.js"></script>
        <script src="js/jquery-1.12.4.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <script>
            $(document).ready(function () {
                $('#workerlist').dataTable({});
            });

            $(document).ready(function () {
                $('#memotable').dataTable({});
            });

            function onSelectEmployee(empid)
            {
                var form = document.forms[0];
                var URL = "settlement.do?method=onSelectEmployee&employeeid=" + empid;
                form.action = URL;
                form.submit();

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
                                <li class="active"><a href="memoaccept.do?method=loadMemoAcceptPage">Memo Settlement</a></li>
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
                <button type="button" class="btn btn-sm btn-warning"  aria-label="Pick Worker" data-toggle="modal" data-target="#worker">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> SELECT WORKER
                </button>
                <logic:notEqual property="employee.name" value="" name="MemoSettlementForm">
                    <button type="button" class="btn btn-sm btn-primary" >
                        <bean:write name="MemoSettlementForm" property="employee.name" />
                    </button>
                </logic:notEqual>
                <logic:notEqual property="employee.name" value="" name="MemoSettlementForm">
                    <logic:notEqual property="goldIssued" value="" name="MemoSettlementForm">
                        <button type="button" class="btn btn-sm btn-danger">
                            GOLD ISSUED : <bean:write name="MemoSettlementForm" property="goldIssued" format="##0.000"/>
                        </button>
                    </logic:notEqual>
                    <logic:notEqual property="silverIssued" value="0" name="MemoSettlementForm">
                        <button type="button" class="btn btn-sm btn-danger">
                            SILVER ISSUED : <bean:write name="MemoSettlementForm" property="silverIssued" format="##0.000"/>
                        </button>
                    </logic:notEqual>
                    <button type="button" class="btn btn-sm btn-success">
                        GOLD RETURNED : <bean:write name="MemoSettlementForm" property="goldReturned" format="##0.000"/>
                    </button>
                    <button type="button" class="btn btn-sm btn-primary">
                        BALANCE WITH WORKER : <bean:write name="MemoSettlementForm" property="balance" format="##0.000"/>
                    </button>
                    <button type="button" class="btn btn-sm btn-warning" aria-label="Pick Worker" data-toggle="modal" data-target="#memoModal">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> MEMO ISSUED (<bean:write name="MemoSettlementForm" property="noofmemo"/>)
                    </button>
                </logic:notEqual>
                <br/><br/>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class=" panel-title">Ornament Received</h3>
                    </div>
                    <div class="panel-body">
                        <div class="btn-group" role="group" aria-label="...">
                            <logic:notEmpty name="MemoSettlementForm" property="items">
                                <logic:iterate id="details" name="MemoSettlementForm" property="items">
                                    <a href="#" onclick="onItem(<bean:write name="details" property="itemid"/>, '<bean:write name="details" property="item"/>')" class="btn btn-primary btn-sm"><bean:write name="details" property="item"/></a>
                                </logic:iterate>
                            </logic:notEmpty>
                        </div>
                    </div>
                </div>






                <div class="modal fade" id="worker" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Workers</h4>
                            </div>
                            <div class="modal-body">
                                <table id="workerlist" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Worker</th>
                                        </tr>
                                    </thead> 
                                    <tbody>
                                        <logic:iterate id="details" name="MemoSettlementForm" property="worker" indexId="index">
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

                <div  class="modal fade" id="memoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 60%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Memo Issued to : <b><bean:write name="MemoSettlementForm" property="employee.name" /></b></h4>
                            </div>
                            <div class="modal-body">
                                <table id="memotable" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Memo No.</th>
                                            <th>Date</th> 
                                            <th>Gold Weight</th>
                                            <th>Silver Weight</th>
                                            <th>Stones Weight</th>
                                            <th>Diamond Weight</th>
                                            <th>Remarks</th>
                                        </tr>
                                    </thead> 
                                    <tbody>
                                        <logic:iterate id="details" name="MemoSettlementForm" property="workersmemo" indexId="index">
                                            <tr>
                                                <td><html:hidden name="details" property="workersmemoid"/>
                                                    <a title="Click here to select" href="#" onclick="onselectMemo('<bean:write name="index"/>')"> 
                                                        <b><bean:write name="details" property="workermemono" /></b>
                                                    </a>
                                                </td>
                                                <td><bean:write name="details" property="date" format="dd/MM/yyyy" /></td>
                                                <td><bean:write name="details" property="goldweight" format="##0.000"/></td>
                                                <td><bean:write name="details" property="silverweight" format="##0.000"/></td>
                                                <td><bean:write name="details" property="stoneweight" format="##0.000"/></td>
                                                <td><bean:write name="details" property="diamondweight" format="##0.000"/></td>

                                                <td><bean:write name="details" property="remarks" /></td>

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

                <br/><br/>

            </div>
        </html:form>
    </body>
</html:html>
