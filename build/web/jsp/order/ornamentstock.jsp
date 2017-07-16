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
        <title><%= session.getAttribute("brand")%> | Ornaments Stock GS 12</title>

        <script src="js/bootstrap-popover.js"></script>
        <script src="js/jquery-1.12.4.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <script>

            $(document).ready(function () {
                var table = $('#example').DataTable({
                    /*     "order": [[ 1, "asc" ]]*/
                    "bSort": false
                });

                $('a.toggle-vis').on('click', function (e) {
                    e.preventDefault();

                    // Get the column API object
                    var column = table.column($(this).attr('data-column'));

                    // Toggle the visibility
                    column.visible(!column.visible());
                });
            });
            function onItem(itemid, item)
            {

                var form = document.forms[0];
                var URL = "orstock.do?method=loadOrnamentStockDetails&item=" + item + "&itemid=" + itemid;
                form.action = URL;
                form.submit();
            }
            function showTotal()
            {
                var form = document.forms[0];
                var URL = "orstock.do?method=loadTotal";
                form.action = URL;
                form.submit();
            }

            function update()
            {
                var form = document.forms[0];
                var URL = "orstock.do?method=updateOrnamentValues&index=" + document.getElementById("stockid").value;
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
            function onchangeweight()
            {
                document.getElementById("totalgold").value = parseFloat(document.getElementById("revnet").value) + parseFloat(document.getElementById("revwaste").value);

            }

            function updateTransfer(index)
            {
                var form = document.forms[0];
                var URL = "orstock.do?method=updateStockTransfer&index=" + index;
                form.action = URL;
                form.submit();
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
                                <li  class="active"><a href="orstock.do?method=loadOrnamentStock">Stock</a></li>
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

                <logic:notEmpty property="msg" name="StockForm">
                    <div class="alert alert-danger"role="alert">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <bean:write name="StockForm" property="msg" />
                    </div>
                </logic:notEmpty>

                <div class="btn-toolbar">
                    <div class="btn-group btn-group-sm">
                        <logic:notEmpty name="StockForm" property="lstItems">
                            <logic:iterate id="details" name="StockForm" property="lstItems">
                                <a style="font-size: 14px"  onclick="onItem(<bean:write name="details" property="itemid"/>, '<bean:write name="details" property="item"/>')" class="btn btn-primary"><bean:write name="details" property="item"/></a>
                            </logic:iterate>
                        </logic:notEmpty>
                    </div>
                </div>
                <br/>
                <div style="font-size: 13px">
                    Hide Column: 
                    <a class="toggle-vis" data-column="10">Revised Gross weight</a> - 
                    <a class="toggle-vis" data-column="11">Revised Net weight</a> - 
                    <a class="toggle-vis" data-column="12">Revised wastage</a> - 
                    <a class="toggle-vis" data-column="13">Revised Total Gold</a> 
                </div>
                <center><span class="label label-danger" style="font-size: 15px;"><bean:write name="StockForm" property="item"/></span>
                </center> 
                <br/>
                <table id="example" class="display table table-striped" cellspacing="0" width="100%" border="1">
                    <thead >
                        <tr style="font-size: 13px">
                            <th>Date</th>
                            <th>Memo No</th>
                            <th>Worker</th>
                            <th>Item &amp; Description</th>
                            <th>Jewel Code</th>
                            <th>Gross weight</th>
                            <th>Stone</th>
                            <th>Stone weight</th>
                            <th>Net weight</th>
                            <th>Wastage</th>  
                            <th>Total Gold</th>
                            <th>Revised Gross weight</th>
                            <th>Revised Net weight</th>
                            <th>Revised wastage</th>
                            <th>Revised Total Gold</th>
                            <th></th>
                        </tr>     
                    </thead>
                    <tbody>
                        <tr>
                            <td>      
                                <button onclick="showTotal();" value="Show Total" class="btn btn-primary btn-xs">Show Total</button>
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><bean:write name="StockForm" property="grosstotal" format="##0.000"/></td>
                            <td></td>
                            <td></td>
                            <td><bean:write name="StockForm" property="nettotal" format="##0.000"/></td>
                            <td></td>
                            <td></td>
                            <td><bean:write name="StockForm" property="revgrosstotal" format="##0.000"/></td>
                            <td><bean:write name="StockForm" property="revnettotal" format="##0.000"/></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <logic:notEmpty name="StockForm" property="lstorgold">
                            <logic:iterate id="details" name="StockForm" property="lstorgold" indexId="index">
                                <tr>
                                    <td><bean:write name="details" property="insertdate" format="dd/MM/yyyy"/></td>
                                    <td><bean:write name="details" property="memono" /></td>
                                    <td><bean:write name="details" property="worker" /></td>
                                    <td><bean:write name="details" property="description" /></td>
                                    <td><span class="text-danger"><bean:write name="details" property="ornamentstockno"/></span></td>
                                    <td class="bg-danger"><bean:write name="details" property="grossweight" format="##0.000"/></td>
                                    <td class="bg-info"><bean:write name="details" property="stonetype" /></td>
                                    <td class="bg-info"><bean:write name="details" property="stoneweight" format="##0.000"/></td>
                                    <td class="bg-danger"><bean:write name="details" property="netweight" format="##0.000"/></td>
                                    <td class="bg-danger"><bean:write name="details" property="wastage" format="##0.000"/></td>
                                    <td class="bg-danger"><bean:write name="details" property="totalglodused" format="##0.000"/></td>
                                    <td class="bg-primary"><bean:write name="details" property="revgrossweight" format="##0.000"/></td>
                                    <td class="bg-primary"><bean:write name="details" property="revnetweight" format="##0.000"/></td>
                                    <td class="bg-primary"><bean:write name="details" property="revwastage" format="##0.000"/></td>
                                    <td class="bg-primary"><bean:write name="details" property="revtotalglodused" format="##0.000"/></td>
                                    <logic:equal name="details" property="sold" value="true">
                                        <td align="center"><span class="btn btn-xs btn-danger">Sold - <bean:write name="details" property="billno"/></span></td>
                                    </logic:equal>
                                    <logic:equal name="details" property="transfered" value="true">
                                        <td align="center"><span class="btn btn-xs btn-danger">Transfered</span></td>
                                    </logic:equal>

                                    <logic:notEqual name="details" property="sold" value="true">
                                        <logic:notEqual name="details" property="transfered" value="true">
                                            <td width="10%"> 
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
                                                <button title="Transfer to GS 11"  class="btn btn-xs btn-warning" onclick="updateTransfer(<bean:write name="details" property="ornamentstockid"/>);">
                                                    GS11
                                                </button>
                                            </td>     
                                        </logic:notEqual>
                                    </logic:notEqual>
                                </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                    </tbody>
                </table>

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
                                            <html:text  styleId="revgross" name="StockForm" property="revgrossweight" styleClass="form-control"  onfocus="this.value='';"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Revised Net weight</td>
                                        <td>
                                            <html:text onchange="onchangeweight()" styleId="revnet" name="StockForm" property="revnetweight" styleClass="form-control"  onfocus="this.value='';"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Revised wastage</td>
                                        <td>
                                            <html:text onchange="onchangeweight()" styleId="revwaste" name="StockForm" property="revwastage" styleClass="form-control"  onfocus="this.value='';"/>
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
                                            <html:text styleId="stonetype" name="StockForm" property="stonetype" styleClass="form-control" />
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