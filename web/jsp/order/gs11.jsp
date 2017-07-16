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
        <title><%= session.getAttribute("brand")%> | GS 11</title>

        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.2.js"></script>

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="css/fixedHeader.dataTables.min.css">

        <script type="text/javascript" language="javascript" src="js/jquery-1.12.3.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.fixedHeader.min.js"></script>

        <script>
            $(document).ready(function () {
                $('#example').DataTable({
                    fixedHeader: true,
                    bSort: false,
                    paging: false
                });
            });
            $(function () {
                $(document).tooltip();
            });
            function search() {
                var form = document.forms[0];
                var URL = "transreport.do?method=loadTransactions&year";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onPrintView(type) {
                var URL = "transreport.do?method=printView&type=" + type;
                window.open(document.action = URL);
                document.forms[0].submit();
                var URL = "transreport.do?method=loadTransactions";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onPrintPDF(type) {
                var URL = "transreport.do?method=pdfReport&type=" + type;
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
    <body style="margin: 0px;padding: 0px">
        <jsp:include page="/jsp/common/orderheader2.jsp" />
        <html:form>
            <div class="container">
                <div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
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
                                <li class="active"><a href="transreport.do?method=loadTransactionPage">GS 11</a></li>
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

                <table class="table-condensed" width="100%">
                    <tr>
                        <td>

                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <logic:notEmpty name="TransactionReportForm" property="lstyears">
                                <logic:iterate id="details" name="TransactionReportForm" property="lstyears" indexId="index">
                                    <logic:equal value="2017" property="year" name="details">
                                        <li class="active">
                                            <a class="paginate_button" href="transreport.do?method=loadTransactions&year=<bean:write name="details" property="years"/>">
                                                <bean:write name="details" property="year" />
                                            </a>
                                        </li>
                                    </logic:equal>
                                    <logic:notEqual value="2017" property="year" name="details">
                                        <li>
                                            <a class="paginate_button" href="transreport.do?method=loadTransactions&year=<bean:write name="details" property="years"/>">
                                                <bean:write name="details" property="year"/>
                                            </a>
                                        </li>
                                    </logic:notEqual>
                                </logic:iterate>
                            </logic:notEmpty>
                        </ul>
                    </nav>
                    </td>
                    <td>
                        <h4><b>GS 11 - <bean:write name="TransactionReportForm" property="year"/></b></h4> 
                    </td>
                    </tr>
                </table>
                <table class="table table-condensed">
                    <tr>
                        <td>
                            Opening Balance : <bean:write name="TransactionReportForm" property="carrybalance" format="##0.000"/>
                        </td>
                        <td>
                            <bean:write name="TransactionReportForm" property="message"/>
                        </td>
                        <td class="text-right">
                            <button onclick="onPrintView('Gold')" value="Submit" class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-print"></span> Print</button>
                        </td>
                    </tr>
                </table>

                <table id="example" class="table table-bordered" border="1">
                    <thead class="bg-primary">
                        <tr>
                            <th width="13%" style="text-align-last: center">Date</th>
                            <th width="25%">
                                <span style="float: left" title="Purchase Voucher | Receipt Voucher | Copper Addition | Ravi Receipts | Transfer from GS 12">Receipt</span>
                                <span style="float: right;padding-right: 20px">Weight</span>
                            </th>
                            <th width="25%">
                                <span style="float: left" title="Worker Memo | Melting Loss">Issues</span>
                                <span style="float: right;padding-right: 20px">Weight</span>
                            </th>
                            <th style="padding-left: 20px">Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <logic:notEmpty name="TransactionReportForm" property="lsttrgold">
                            <logic:iterate id="details" name="TransactionReportForm" property="lsttrgold" indexId="index">
                                <tr>
                                    <td  style="vertical-align: top" align="center"><b><bean:write name="details" property="date"/></b></td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstcredit">
                                            <table class="table table-condensed">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstcredit">
                                                        <tr>
                                                            <td width="50%"><bean:write name="details1" property="desc" /></td>
                                                            <td width="50%" class="text-right" style="padding-right: 30px;font-weight: bold"><bean:write name="details1" property="weight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstdebit">
                                            <table class="table table-condensed">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstdebit">
                                                        <tr>
                                                            <td width="50%"><bean:write name="details1" property="desc" /></td>
                                                            <td width="50%" class="text-right" style="padding-right: 30px;font-weight: bold"><bean:write name="details1" property="weight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td style="vertical-align: bottom;padding-left: 20px">
                                        <b><bean:write name="details" property="balance" format="##0.000"/></b>
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