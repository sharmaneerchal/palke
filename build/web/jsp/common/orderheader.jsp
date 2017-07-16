<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <title></title>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />

        <link href="css/navbar-fixed-top.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style>
            .container{
                width: 98%;
            }
        </style>

    </head> 
    <body> 
        <!-- Fixed navbar -->
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
                        <li class="active"><a href="gohome.do?method=displayOrderHome">Home</a></li>
                        <li><a href="vouchers.do?method=loadVouchersPage">Vouchers</a></li>
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
    </body>
</html>