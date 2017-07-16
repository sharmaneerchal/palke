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
        <title><%= session.getAttribute("brand")%> | GS 12</title>

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
            function search() {
                var form = document.forms[0];
                var URL = "gs12.do?method=loadGS12Transactions&year";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onPrintView() {
                var URL = "gs12.do?method=printViewGS12";
                window.open(document.action = URL);
                document.forms[0].submit();
                var URL = "gs12.do?method=loadGS12Transactions";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onPrintPDF(type) {
                var URL = "gs12.do?method=pdfReport&type=" + type;
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
    <body  style="margin: 0px;padding: 0px">
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
                                <li><a href="transreport.do?method=loadTransactionPage">GS 11</a></li>
                                <li class="active"><a href="gs12.do?method=loadGS12Page">GS 12</a></li>
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
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <logic:notEmpty name="TransactionReportForm" property="lstyears">
                            <logic:iterate id="details" name="TransactionReportForm" property="lstyears" indexId="index">
                                <logic:equal value="2017" property="year" name="details">
                                    <li class="active">
                                        <a class="paginate_button" href="gs12.do?method=loadGS12Transactions&year=<bean:write name="details" property="years"/>">
                                            <bean:write name="details" property="year" />
                                        </a>
                                    </li>
                                </logic:equal>
                                <logic:notEqual value="2017" property="year" name="details">
                                    <li>
                                        <a class="paginate_button" href="gs12.do?method=loadGS12Transactions&year=<bean:write name="details" property="years"/>">
                                            <bean:write name="details" property="year"/>
                                        </a>
                                    </li>
                                </logic:notEqual>
                            </logic:iterate>
                        </logic:notEmpty>
                    </ul>               
                </nav>

                <!-- gold -->

                <table class="table-condensed" width="100%">
                    <tr>
                        <td>
                            Opening Net weight Balance : <bean:write name="TransactionReportForm" property="netcarryBalance" format="##0.000"/>
                            <br/>
                            Opening Gross weight Balance : <bean:write name="TransactionReportForm" property="grosscarryBalance" format="##0.000"/>
                            <br/><br/>
                        </td>

                        <td>
                            <bean:write name="TransactionReportForm" property="message"/>
                        </td>
                        <td class="text-right"><h5><b>GS 12 - <bean:write name="TransactionReportForm" property="year"/></b></h5></td>
                        <td class="text-right">
                            <button onclick="onPrintView()" value="Submit" class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-print"></span> Print</button>
                        </td>
                    </tr>
                </table>   

                <table id="example" class="table table-condensed text-center" border="1">
                    <thead class="bg-primary">
                        <tr>
                            <th width="10%" style="vertical-align: middle;text-align-last: center">Date</th>
                            <th width="35%" style="vertical-align: middle" title="Worker Memo">
                                <center>Receipts</center>
                                <table class="table table-condensed" style="font-size: 14px">
                                    <thead  class="bg-primary">
                                        <tr>
                                            <th width="40%" title="Memo No - Item Code - Jewel Code">Memo No - Jewel Code</th>
                                            <th width="30%">Gross Weight</th>
                                            <th width="30%">Net Weight</th>
                                        </tr>
                                    </thead> 
                                </table>
                            </th>
                            <th width="35%" style="vertical-align: middle" title="Bills | Transfer to GS 12">
                                <center>Sales</center>
                                <table class="table table-condensed">
                                    <thead  class="bg-primary">
                                        <tr>
                                            <th width="40%">Bill No - Jewel Code</th>
                                            <th width="30%">Gross Weight</th>
                                            <th width="30%">Net Weight</th>
                                        </tr>
                                    </thead> 
                                </table>
                            </th>
                            <th width="20%" style="vertical-align: middle">
                                <center>Balance</center>
                                <table class="table table-condensed">
                                    <thead  class="bg-primary">
                                        <tr>
                                            <th>Gross Weight</th>
                                            <th>Net Weight</th>
                                        </tr>
                                    </thead> 
                                </table>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <logic:notEmpty name="TransactionReportForm" property="lstjewel">
                            <logic:iterate id="details" name="TransactionReportForm" property="lstjewel" indexId="index">
                                <tr>
                                    <td  style="vertical-align: top"><strong><bean:write name="details" property="date"/></strong></td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstreceipt">
                                            <table class="table table-condensed">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstreceipt">
                                                        <tr>
                                                            <td width="40%"><strong class="text-danger"><bean:write name="details1" property="memono" /></strong></td>
                                                            <td width="30%"><bean:write name="details1" property="grossweight" format="##0.000"/></td>
                                                            <td width="30%"><bean:write name="details1" property="netweight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstsales">
                                            <table class="table table-condensed">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstsales">
                                                        <tr>
                                                            <td width="40%"><strong class="text-danger"><bean:write name="details1" property="memono" /></strong></td>
                                                            <td width="30%"><bean:write name="details1" property="grossweight" format="##0.000"/></td>
                                                            <td width="30%"><bean:write name="details1" property="netweight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td style="vertical-align: bottom;padding-left: 20px">
                                        <table class="table table-condensed">
                                            <tbody>
                                                <tr>
                                                    <td><bean:write name="details" property="grossweightbalance" format="##0.000"/></td> 
                                                    <td><bean:write name="details" property="netweightbalance" format="##0.000"/></td>
                                                </tr>
                                            </tbody>
                                        </table>
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