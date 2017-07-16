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
        <title><%= session.getAttribute("brand")%> | Stock</title>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.2.js"></script>

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({});
            });
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
                                        <li  class="active"><a href="stock.do?method=loadStock">Stock- Gold, Silver Stone &AMP; Pearls</a></li>
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
                <p class="panel-title text-muted">GOLD STOCK</p><br/>
                <ui>
                    <li class="text-danger">Deleted Stock will not be considered for the <b>Total</b>.</li>
                </ui>
                <br/>
                <table id="example" class="display table table-condensed">
                    <thead>
                        <tr>
                            <td>Voucher Date</td>
                            <td>Voucher No</td>
                            <td>Weight (g)</td>
                            <td>Status</td>
                        </tr>
                    </thead>
                    <tbody>
                        <logic:notEmpty name="StockForm" property="lstgold">
                            <logic:iterate id="details" name="StockForm" property="lstgold" indexId="index">
                                <tr>
                                    <html:hidden name="details" property="goldstockid"/>
                                    <td><bean:write name="details" property="voucherdate" format="dd/MM/yyyy"/></td>
                                    <td>
                                        <logic:equal name="details" property="vouchertype" value="Purchase Voucher">
                                            <span class="label label-info">PV</span> - <bean:write name="details" property="refernceid" />
                                        </logic:equal>
                                        <logic:equal name="details" property="vouchertype" value="Receipt Voucher">
                                            <span class="label label-primary">RV</span> - <bean:write name="details" property="refernceid" />
                                        </logic:equal>
                                        <logic:equal name="details" property="vouchertype" value="Workers Memo">
                                            <span class="label label-default">Memo</span> - <bean:write name="details" property="refernceid" />
                                        </logic:equal>
                                        <logic:equal name="details" property="vouchertype" value="WM RTN">
                                            <span class="label label-success">WM RTN</span> - <bean:write name="details" property="refernceid" />
                                        </logic:equal>
                                    </td>
                                    <td><bean:write name="details" property="weight" format="##0.000"/></td>
                                    <td><bean:write name="details" property="remarks"/></td>
                                </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                    </tbody>
                    <tfoot>
                        <tr style="font-weight: bold">
                            <td>Total</td>
                            <td></td>
                            <td><bean:write name="StockForm" property="goldweight" format="##0.000"/></td>
                            <td></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </html:form>
    </body>
</html:html>