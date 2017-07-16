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
        <title><%= session.getAttribute("brand")%> | Workers Memos Settlement</title>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/bootstrap-popover.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script>
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({});
            });
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example1').dataTable({
                    "bSort": false
                });
            });
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example2').dataTable({});
            });

            $(function () {
                $("#date").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            $(function () {
                $("#jeweldate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            $(document).ready(function () {
                $('[data-toggle="popover"]').popover();
            });
            function onSave()
            {
                var form = document.forms[0];

                if (form.memoid.value === '0') {
                    alert("Workers Memo not selected.");
                    form.memono.focus();
                    return false;
                }
                if (form.category.value === "") {
                    alert("Please select Category");
                    form.category.focus();
                    return false;
                }
                if (form.returndate.value === "") {
                    alert("Please enter date.");
                    form.returnweight.focus();
                    return false;
                }
                if (form.returnweight.value === "" || form.returnweight.value === "0.0") {
                    alert("Please enter weight.");
                    form.returnweight.focus();
                    return false;
                }


                var type = confirm("Are you sure you want to save the data ?");
                if (type) {
                    var URL = "memoaccept.do?method=saveStockReturn";
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }
            function onClearReturn()
            {
                var form = document.forms[0];

                var type = confirm("Do you want to clear form data ?");
                if (type) {
                    var form = document.forms[0];
                    var URL = "memoaccept.do?method=clearReturn";
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }

            function onchangeCategory(type, idval) {
                var form = document.forms[0];
                form.category.value = type;

                document.getElementById("1").className = 'btn btn-sm btn-default';
                document.getElementById("2").className = 'btn btn-sm btn-default';
                //document.getElementById("3").className = 'btn btn-large btn-default';
                // document.getElementById("4").className = 'btn btn-large btn-default';

                document.getElementById(idval).className = 'btn btn-sm btn-primary';
            }
            function onselectMemo(index)
            {
                var form = document.forms[0];
                var URL = "memoaccept.do?method=loadselectedMemo&index=" + index;
                form.action = URL;
                form.submit();
            }
            function onItem(itemid, item)
            {
                var form = document.forms[0];
                var URL = "memoaccept.do?method=setItem&item=" + item + "&itemid=" + itemid;
                form.action = URL;
                form.submit();
            }
            function saveJewel()
            {
                var form = document.forms[0];
                if (form.memoid.value === '0') {
                    alert("Workers Memo not selected.");
                    form.memono.focus();
                    return false;
                }

                if (form.description.value === "") {
                    alert("Please enter Description.");
                    form.description.focus();
                    return false;
                }
                if (form.jeweldate.value === "") {
                    alert("Please select Date.");
                    form.jeweldate.focus();
                    return false;
                }
                if (form.grossweight.value === "" || form.grossweight.value === "0.0") {
                    alert("Please enter gross weight.");
                    form.grossweight.focus();
                    return false;
                }
                if (form.totalgoldused.value === "" || form.totalgoldused.value === "0.0") {
                    alert("Please total gold used.");
                    form.netweight.focus();
                    return false;
                }

                var type = confirm("Are you sure you want to save the data ?");
                if (type) {
                    var URL = "memoaccept.do?method=saveJewels";
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }
            function clearJewel()
            {
                var form = document.forms[0];

                var type = confirm("Do you want to clear form data ?");
                if (type) {
                    var form = document.forms[0];
                    var URL = "memoaccept.do?method=clearJewelForm";
                    form.action = URL;
                    form.submit();
                } else {
                    return false;
                }
            }
            function onchangeweight()
            {
                var form = document.forms[0];
                var URL = "memoaccept.do?method=calulateWeight";
                form.action = URL;
                form.submit();
                form.wastage.focus();
            }
            function deleteJewel(jewelentryid)
            {
                var form = document.forms[0];
                var URL = "memoaccept.do?method=deleteJewels&index=" + jewelentryid;
                form.action = URL;
                form.submit();

            }
            function editJewelentry(index)
            {
                var form = document.forms[0];
                var URL = "memoaccept.do?method=editJewelsEntry&index=" + index;
                form.action = URL;
                form.submit();

            }

            function deleteStockReturn(voucherid)
            {
                var form = document.forms[0];
                var URL = "memoaccept.do?method=deleteStockReturn&index=" + voucherid;
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
                <button type="button" class="btn btn-sm btn-success"  aria-label="Pick Workers Memo" data-toggle="modal" data-target="#workermemos">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> SELECT MEMO
                </button>
                <html:hidden name="MemoAcceptForm" property="memoid" />
                <logic:notEqual name="MemoAcceptForm" property="memoid" value="0">
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            MEMO NO : <bean:write name="MemoAcceptForm" property="memono"/> <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Date : <bean:write name="MemoAcceptForm" property="memodate" format="dd/MM/yyyy" /></a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Issued Gold : <bean:write name="MemoAcceptForm" property="memogweight" format="##0.000"/></a></li>
                            <li><a href="#">Issued Silver : <bean:write name="MemoAcceptForm" property="memosweight" format="##0.000"/></a></li>
                            <li><a href="#">Issued Stones, Diamonds &amp; Pearls : <bean:write name="MemoAcceptForm" property="memostweight" format="##0.000"/></a></li>
                            <li><a href="#">Issued Diamond : <bean:write name="MemoAcceptForm" property="memodweight" format="##0.000"/></a></li>
                        </ul>
                    </div>
                    <button type="button" class="btn btn-warning btn-sm" title="Jewels Weight which is returend against memo">
                        WORKER : <bean:write name="MemoAcceptForm" property="memoemp" />
                    </button>
                    <button type="button" class="btn btn-primary btn-sm" title="Jewels Weight which is returend against memo">
                        GOLD ISSUED : <bean:write name="MemoAcceptForm" property="memogweight" format="##0.000"/>
                    </button>
                    <button type="button" class="btn btn-info btn-sm" title="Jewels Weight which is returend against memo">
                        GOLD RETURNED WEIGHT : <bean:write name="MemoAcceptForm" property="usedWeight" format="##0.000"/>
                    </button>
                    <button type="button" class="btn btn-default btn-sm" title="Jewels Weight which is returend against memo">
                        BALANCE WITH WORKER : <bean:write name="MemoAcceptForm" property="memobalance" format="##0.000"/>
                    </button>

                </logic:notEqual>

                <div class="modal fade" id="workermemos" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Worker Memo's</h4>
                            </div>
                            <div class="modal-body">
                                <table id="example" class="display" style="font-size: 13px">
                                    <thead>
                                        <tr>
                                            <th>Memo No.</th>
                                            <th>Worker</th>
                                            <th>Date</th> 
                                            <th>Gold Weight</th>
                                            <th>Silver Weight</th>
                                            <th>Stones, Pearls Weight</th>
                                            <th>Diamond Weight</th>
                                            <th>Remarks</th>
                                        </tr>
                                    </thead> 
                                    <tbody>
                                        <logic:iterate id="details" name="MemoAcceptForm" property="lstmemos" indexId="index">
                                            <tr>
                                                <td><html:hidden name="details" property="workersmemoid"/>
                                                    <a title="Click here to select" href="#" onclick="onselectMemo('<bean:write name="index"/>')"> 
                                                        <b><bean:write name="details" property="workermemono" /></b>
                                                    </a>
                                                </td>
                                                <td><bean:write name="details" property="employee" /></td>
                                                <td><bean:write name="details" property="date" format="dd/MM/yyyy" /></td>
                                                <td><bean:write name="details" property="goldweight" format="##0.000"/></td>
                                                <td><bean:write name="details" property="silverweight" format="##0.000"/></td>
                                                <td><bean:write name="details" property="stoneweight" format="##0.000"/></td>
                                                <td><bean:write name="details" property="diamondweight" format="##0.000"/></td>

                                                <td><bean:write name="details" property="remarks" /></td>
                                                <!--  <td>
                                                      <button onclick="onselectMemo('<bean:write name="index"/>')" value="Edit" class="btn btn-xs btn-info">Select</button>
                                                  </td> -->
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
                <br/>
                <table class="table table-condensed">
                    <tr>
                        <td>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class=" panel-title">Jewel Received Entry</h3>
                                </div>
                                <div class="panel-body">
                                    <logic:notEmpty property="jewelmsg" name="MemoAcceptForm">
                                        <div class="alert alert-danger" role="alert">
                                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                                            <bean:write name="MemoAcceptForm" property="jewelmsg" />
                                        </div>
                                    </logic:notEmpty>
                                    <div class="btn-group" role="group" aria-label="...">
                                        <logic:notEmpty name="MemoAcceptForm" property="lstitems">
                                            <logic:iterate id="details" name="MemoAcceptForm" property="lstitems">
                                                <a href="#" onclick="onItem(<bean:write name="details" property="itemid"/>, '<bean:write name="details" property="item"/>')" class="btn btn-primary btn-sm"><bean:write name="details" property="item"/></a>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </div>

                                    <table class="table-condensed">
                                        <tr>
                                            <td>Selected Item</td>
                                            <td><span class="btn btn-sm btn-success"><bean:write name="MemoAcceptForm" property="item"/></span></td>
                                        </tr>
                                    </table>
                                    <table class="table-condensed">
                                        <tr>
                                            <td>Description</td>
                                            <td><html:text onblur="form.jeweldate.focus()" property="description" styleClass="form-control" onfocus="this.value='';"/></td>
                                            <td>Date</td>
                                            <td> 
                                                <html:text onblur="form.grossweight.focus()"  alt="dd-mm-yyyy" property="jeweldate" styleId="jeweldate"  title="dd/mm/yyyy" styleClass="form-control"/>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table-condensed">
                                        <tr>
                                            <td>Gross Weight</td>
                                            <td><html:text property="grossweight" styleClass="form-control" onfocus="this.value='';" onblur="form.stonetype.focus()"/></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <html:text title="Stone" property="stonetype" styleClass="form-control"/>            
                                            </td>
                                            <td><html:text title="Stone weight" onchange="onchangeweight()" property="stonesweight" styleClass="form-control" onfocus="this.value='';" onblur="form.wastage.focus()"/></td>
                                        </tr>
                                        <tr>
                                            <td>Net Weight</td>
                                            <td><html:text property="netweight" styleClass="form-control" /></td>
                                        </tr>
                                        <tr>
                                            <td>Wastage</td>
                                            <td><html:text onchange="onchangeweight()" property="wastage" styleClass="form-control" onfocus="this.value='';"/></td>
                                        </tr>
                                        <tr>
                                            <td>Total gold used</td>
                                            <td><html:text property="totalgoldused" styleClass="form-control"/></td>
                                        </tr>
                                    </table>

                                </div>
                                <div class="panel-footer">
                                    <html:button styleId="add" property="method" onclick="saveJewel();" value="Submit" styleClass="btn  btn-primary btn-sm"/>

                                    <html:button property="method" onclick="clearJewel()" value="Reset" styleClass="btn  btn-default btn-sm"/>
                                </div>
                                <div class="panel-body">
                                    <table id="example1" class="display table table-condensed" style="font-size: 13px">
                                        <thead>
                                            <tr>
                                                <th>Date</th> 
                                                <th>Jewel Code</th>
                                                <th>Item &amp; Description</th>
                                                <th>Gross Weight</th>
                                                <th>Gold Weight</th>
                                                <th>Stone Type</th>
                                                <th>Stone Weight</th>
                                                <th>Net Weight</th>
                                                <th>Wastage</th>
                                                <th>Total gold usage</th>
                                                <th></th>
                                            </tr>
                                        </thead> 
                                        <tbody>
                                            <logic:iterate id="details" name="MemoAcceptForm" property="lstentry" indexId="index">
                                                <tr>
                                                    <td><bean:write name="details" property="date" format="dd/MM/yyyy" /></td>
                                                    <td><bean:write name="details" property="ornamentstockno"/></td>
                                                    <td><bean:write name="details" property="description" /></td>
                                                    <td><bean:write name="details" property="grossweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="goldweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="stonetype" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="stoneweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="netweight" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="wastage" format="##0.000"/></td>
                                                    <td><bean:write name="details" property="totalglodused" format="##0.000"/></td>
                                                    <td>
                                                        <button onclick="editJewelentry('<bean:write name="index"/>')" value="Edit" class="btn btn-xs btn-warning"><span class="glyphicon glyphicon-trash"></span>&nbsp;Edit</button>

                                                        <button onclick="deleteJewel('<bean:write name="details" property="jewelentryid"/>')" value="Delete" class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Remove</button>
                                                    </td>
                                                </tr>
                                            </logic:iterate>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Ravi [Stock Return]</h3>
                                </div>
                                <div class="panel-body">
                                    <logic:notEmpty property="returnmsg" name="MemoAcceptForm">
                                        <div class="alert alert-danger" role="alert">
                                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                                            <bean:write name="MemoAcceptForm" property="returnmsg" />
                                        </div>
                                    </logic:notEmpty>
                                    <html:hidden styleId="category" property="category"/>
                                    <div class="btn-group" role="group" aria-label="...">
                                        <a id="1" onclick="onchangeCategory('Gold', 1)" href="#gold" class="btn btn-sm btn-primary" data-toggle="tab">Gold</a>
                                        <a id="2" onclick="onchangeCategory('Silver', 2)" href="#silver" class="btn btn-sm btn-primary" data-toggle="tab">Silver</a>
                                        <!--    
                                        <a id="3" onclick="onchangeCategory('Stone, Pearls etc', 3)" href="#stone" class="btn btn-large btn-default"  data-toggle="tab">Stones, Pearls </a>
                                            <a id="4" onclick="onchangeCategory('Diamonds', 4)" href="#diamonds" class="btn btn-large btn-default"  data-toggle="tab">Diamonds</a>
                                        -->
                                    </div>

                                    <table class="table-condensed">
                                        <tr>
                                            <td>Date</td>
                                            <td> <html:text alt="dd-mm-yyyy" property="returndate" styleId="date"  title="dd/mm/yyyy" styleClass="form-control"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Weight (g)</td>
                                            <td><html:text property="returnweight" styleClass="form-control" onfocus="this.value='';"/></td>
                                        </tr>
                                    </table>

                                </div>

                                <div class="panel-footer">
                                    <html:button styleId="add" property="method" onclick="onSave();" value="Submit" styleClass="btn btn-info btn-sm"/>
                                    <html:button property="method" onclick="onClearReturn()" value="Reset" styleClass="btn  btn-default btn-sm"/>
                                </div>
                                <div class="panel-body">
                                    <table class="display" id="example2" style="font-size: 13px" >
                                        <thead>
                                            <tr>
                                                <th>Voucher Type</th>
                                                <th>Category</th>
                                                <th>Voucher No</th>
                                                <th>Date</th>
                                                <th>Weight (g)</th>
                                                <th>Amount</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <logic:notEmpty name="MemoAcceptForm" property="lstvouchers">
                                                <logic:iterate id="details" name="MemoAcceptForm" property="lstvouchers">
                                                    <tr>
                                                        <td><bean:write name="details" property="vouchertype" /></td>
                                                        <td><bean:write name="details" property="vouchercategory" /></td>
                                                        <td><bean:write name="details" property="voucherno" /></td>
                                                        <td><bean:write name="details" property="voucherdate" format="dd/MM/yyyy"/></td>
                                                        <td><bean:write name="details" property="weight" format="##0.000"/></td>
                                                        <td><bean:write name="details" property="amount" /></td>
                                                        <td>
                                                            <button onclick="deleteStockReturn('<bean:write name="details" property="voucherid"/>')" value="Delete" class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Remove</button>
                                                        </td>
                                                    </tr>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </html:form>
    </body>
</html:html>
