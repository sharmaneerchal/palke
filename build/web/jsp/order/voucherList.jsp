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
        <title><%= session.getAttribute("brand")%> | Voucher List</title>

        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.2.js"></script>

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function() {
                // $('#example').dataTable();
                $('#example').dataTable({});
            });
            function onchangeCategory(type) {
                var form = document.forms[0];
                var URL = "voucherlist.do?method=loadVouchers&vouchertype=" + type;
                form.action = URL;
                form.submit();
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
                    var form = document.forms[0];
                    var URL = "voucherlist.do?method=loadVouchers&vouchertype=" + category;
                    form.action = URL;
                    form.submit();
                }
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
                                        <li class="active"><a href="voucherlist.do?method=loadVoucherListPage">Vouchers</a></li>
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

                <p class="panel-title text-muted">Voucher List</p><br/>
                <table class="table">
                    <tr>
                        <td>  
                            <a onclick="onchangeCategory('Purchase Voucher')" href="#purhcase" class="btn btn-large btn-primary" data-toggle="tab">Purchase Voucher</a>
                            <a onclick="onchangeCategory('Receipt Voucher')" href="#receipt" class="btn btn-large btn-success" data-toggle="tab">Receipt Voucher</a>
                        </td> 
                        <td>
                            <label><bean:write name="VouchersForm" property="message" /></label>
                        </td>
                    </tr>
                </table>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Vouchers
                        <!--    <img alt="Enter Vouchers" src="images/addnew.png" width="30px" height="30px" title="Enter Voucher"/><html:link action="vouchers.do?method=loadVouchersPage">Enter Vouchers</html:link>
                                -->    
                            </h3>
                        </div>
                        <div class="panel-body">
                            <table id="example" class="display">
                                <thead>
                                    <tr>
                                        <th>SI. No</th>
                                        <th>Voucher Type</th>
                                        <th>Category</th>
                                        <th>Voucher No</th>
                                        <th>Date</th>
                                        <th>Weight (g)</th>
                                        <th>Amount</th>
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
                                            <td><bean:write name="details" property="amount" /></td>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </html:form>
    </body>
</html:html>