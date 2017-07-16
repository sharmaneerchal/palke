<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<!DOCTYPE html>
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <title>
            <%= session.getAttribute("brand")%> | Home
        </title>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <script src="js/jquery-1.10.2.js"></script>
        <style>
            body { 
                background: url(images/ps_neutral.png) repeat scroll left bottom #dbd9d3; 
            }
            .btn{
                width: 200px;
                height: 200px
            }

        </style>
    </head>

    <body>
        <jsp:include page="/jsp/common/orderheader.jsp" />
        <!-- Wrap all page content here -->
        <div id="wrap">

            <!-- Begin page content -->
            <div class="container">
                <center>
                    <div class="page-header">
                        <h3>Welcome to Stock Management</h3>
                        <p class="lead"></p>
                        <p></p>
                    </div>
                </center>

                <div class="panel-body text-center" style="background: transparent">

                    <a href="vouchers.do?method=loadVouchersPage" >
                        <button type="button" class="btn btn-lg btn-primary">
                            <p>Vouchers</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>

                    <a href="workmemo.do?method=loadWorkMemoPage" >
                        <button type="button" class="btn btn-lg btn-default">
                            <p>Workers Memo <br/>Issue</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>

                    <a href="memoaccept.do?method=loadMemoAcceptPage" >
                        <button type="button" class="btn btn-lg btn-success">
                            <p>Workers Memo <br/>Settlement</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>


                    <a href="transreport.do?method=loadTransactionPage">
                        <button type="button" class="btn btn-lg btn-info">
                            <p>GS 11</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>
                    <br/><br/>
                    <a href="gs12.do?method=loadGS12Page" > 
                        <button type="button" class="btn btn-lg btn-warning">
                            <p>GS 12</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>
                    <a href="orstock.do?method=loadOrnamentStock" > 
                        <button type="button" class="btn btn-lg btn-success">
                            <p>Jewels Stock</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>
                    <a href="sales.do?method=loadSalesPage" > 
                        <button type="button" class="btn btn-lg btn-danger">
                            <p>Sales &amp; Bills</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>

                    <a href="memoreport.do?method=loadReportPage" >
                        <button type="button" class="btn btn-lg btn-default">
                            <p>Memo Report</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>

                    <a href="settlement.do?method=loadMemoSettlementPage" >
                        <button type="button" class="btn btn-lg btn-default">
                            <p>Memo Settlement</p>
                            <p style="font-size: 13px"></p>
                        </button>
                    </a>
                </div>
            </div>
        </div>


    </body>
</html>