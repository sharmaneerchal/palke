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
        <title><%= session.getAttribute("brand")%> | GS 12 Memo Balance Report</title>

        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.2.js"></script>

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script>
            function search() {
                var form = document.forms[0];
                var URL = "memoreport.do?method=loadTransactions&year";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onPrintView() {
                var URL = "memoreport.do?method=printView";
                window.open(document.action = URL);
                document.forms[0].submit();
                var URL = "memoreport.do?method=loadTransactions";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onPrintPDF(type) {
                var URL = "memoreport.do?method=pdfReport&type=" + type;
                document.forms[0].action = URL;
                document.forms[0].submit();
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
                                <li class="active"><a href="memoreport.do?method=loadReportPage">Memo Report</a></li>
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

                <ul class="pagination pagination-sm">
                    <logic:notEmpty name="MemoReportForm" property="lstyears">
                        <logic:iterate id="details" name="MemoReportForm" property="lstyears" indexId="index">
                            <logic:equal value="2016" property="year" name="details">
                                <li class="active">
                                    <a href="memoreport.do?method=loadTransactions&year=<bean:write name="details" property="years"/>">
                                        <bean:write name="details" property="year" />
                                    </a>
                                </li>
                            </logic:equal>
                            <logic:notEqual value="2016" property="year" name="details">
                                <li>
                                    <a href="memoreport.do?method=loadTransactions&year=<bean:write name="details" property="years"/>">
                                        <bean:write name="details" property="year"/>
                                    </a>
                                </li>
                            </logic:notEqual>
                        </logic:iterate>
                    </logic:notEmpty>
                </ul>               

                <center style="float: right">
                    <h4>Memo Report  - <bean:write name="MemoReportForm" property="year"/></h4> 
                    <bean:write name="MemoReportForm" property="message"/>
                    <button onclick="onPrintView()" value="Submit" class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-print"></span> Print</button>
                </center>

                    <table id="example4" class="table table-condensed" border="1">
                        <thead>
                            <tr>
                                <th width="30%" style="text-align-last: center">Workers Memo</th>
                                <th style="text-align-last: center">
                                    Jewels Received
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th width="8%">Jewel Code</th>
                                                <th width="13%">Date</th>
                                                <th>Description</th>
                                                <th width="20%">Gross weight (g)</th>
                                                <th width="20%">Net weight (g)</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </th>
                                <th width="10%" style="vertical-align: middle">Balance</th>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:notEmpty name="MemoReportForm" property="lstMemos">
                                <logic:iterate id="details" name="MemoReportForm" property="lstMemos" indexId="index">
                                    <tr>
                                        <td style="vertical-align: top">
                                            <table class="table table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th width="10%">Memo No.</th>
                                                        <th width="10%">Date</th>
                                                        <th width="15%">Gold weight</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <tr>
                                                        <td width="10%"><bean:write name="details" property="memono"/></td>
                                                        <td width="10%"><bean:write name="details" property="memodate" format="dd/MM/yyyy"/></td>
                                                        <td width="15%"><b><bean:write name="details" property="goldweight" format="##0.000"/></b></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </td>
                                        <td style="vertical-align: top;">
                                            <logic:notEmpty name="details" property="lstDetails">
                                                <table class="table table-bordered">
                                                    <tbody>
                                                        <logic:iterate id="details1" name="details" property="lstDetails">
                                                            <tr>       
                                                                <td width="8%"><bean:write name="details1" property="jewelentryid" /></li>
                                                                <td width="13%"><bean:write name="details1" property="jewelDate" format="dd/MM/yyyy"/></td>
                                                                <td><bean:write name="details1" property="item" /></td>
                                                                <td width="20%"><bean:write name="details1" property="grossweight" format="##0.000"/></td>
                                                                <td width="20%"><bean:write name="details1" property="netweight" format="##0.000"/></td>
                                                            </tr>
                                                        </logic:iterate>
                                                        <tr style="font-weight: bold">       
                                                            <td></td>
                                                            <td colspan="2">Total</td>
                                                            <td><bean:write name="details" property="totalgrossweight" format="##0.000"/></td>
                                                            <td><bean:write name="details" property="totalnetweight" format="##0.000"/></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </logic:notEmpty>
                                        </td>
                                        <td style="vertical-align: bottom;padding-bottom: 25px">
                                            <b><bean:write name="details" property="netbalance" format="##0.000"/></b>
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