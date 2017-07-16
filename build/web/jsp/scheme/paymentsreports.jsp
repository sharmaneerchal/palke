<%-- 
    Document   : paymentsreports
    Created on : 29 Aug, 2014, 10:18:57 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <title><%= session.getAttribute("brand")%> | Payments Report</title>

        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <script type="text/javascript">
            $(function () {
                $("#fromdate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            $(function () {
                $("#todate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            function search()
            {
                var form = document.forms[0];
                if (form.fromdate.value === "")
                {
                    alert("Please select From Date");
                    form.fromdate.focus();
                    return false;
                }
                if (form.todate.value === "")
                {
                    alert("Please select To Date");
                    form.todate.focus();
                    return false;
                }
                if (!isNumber(form.fromno.value)) {
                    alert("Receipt No. Should be number.");
                    form.todate.focus();
                    return false;
                }
                if (!isNumber(form.tono.value)) {
                    alert("Receipt No. Should be number.");
                    form.todate.focus();
                    return false;
                }
                var URL = "paymentsreports.do?method=searchPayments";
                document.forms[0].action = URL;
                document.forms[0].submit();
                document.getElementById("grid").focus();
            }
            function isNumber(n) {
                return !isNaN(parseFloat(n)) && isFinite(n);
            }
            function clearsearch()
            {
                var URL = "paymentsreports.do?method=clearsearch";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function generateminireport() {
                var URL = "paymentsreports.do?method=generateministatement";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function generatepdf() {
                var URL = "paymentsreports.do?method=generatepdf";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function generatexls() {
                var URL = "paymentsreports.do?method=generatexls";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

        </script>
        <style>
            body { 
                background: url(images/confectionary.png)  repeat scroll left bottom #dbd9d3; 
            }
        </style>
    </head>
    <body>
        <jsp:include page="/jsp/common/header.jsp" />
        <!-- header -->
        <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="gohome.do?method=displayAppHome"><%= session.getAttribute("brand")%></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav">
                    <li><a href="gohome.do?method=displayHome">Home</a> </li>
                    <li><a href="transaction.do?method=loadPage">Payment</a></li>
                    <li><a href="addmember.do?method=displayGroups">Members</a></li>
                    <li><a href="creategroup.do?method=displayGroups">Groups</a></li>
                    <li class="active"><a href="paymentsreports.do?method=displayGroups">Payment Report</a><span class="sr-only"></span></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Settings <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="changepassword.do?method=changePassword">Change Password</a></li>
                            <li><a href="usercreation.do?method=displayUsers">Create Users</a></li>
                            <li><a href="dataentry.do?method=displayData">Data Entry</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"  style="font-style: italic;"t class="text text-info"><%= session.getAttribute("userName")%>
                        </a></li>
                    <li class="active"><a href="logout.do?method=logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- end -->

    <html:form action="paymentsreports">
        <div class="container-fluid">  
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table-condensed">
                        <tr>
                            <td>Group</td>
                            <td><html:select  property="groupid" styleClass="form-control" onchange="fillMembers()">
                                    <html:option value="">--Select--</html:option>
                                    <html:optionsCollection property="groups"  value="id" label="label"/>
                                </html:select>
                            </td>
                            <td colspan="6"></td>
                        </tr>
                        <tr>
                            <td>From Date</td>
                            <td>
                                <html:text property="fromDate" styleId="fromdate" title="dd/mm/yyyy" styleClass="form-control"/>
                            </td>
                            <td>To Date</td>
                            <td>
                                <html:text property="toDate" styleId="todate"  title="dd/mm/yyyy" styleClass="form-control" />
                            </td>
                            <td>From Receipt No.</td>
                            <td>
                                <html:text property="fromno" styleId="fromno" styleClass="form-control" onfocus="this.value='';"/>
                            </td>
                            <td>To Receipt No.</td>
                            <td>
                                <html:text property="tono" styleId="tono" styleClass="form-control" onfocus="this.value='';"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="7"></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
                <div class="panel-footer text-right">
                    <html:button property="method" onclick="search()" value="Search" styleClass="btn btn-sm btn-primary"/>
                    <html:button property="method" onclick="clearsearch()" value="Clear" styleClass="btn btn-sm btn-default"/>
                </div>
            </div>

            <table class="table-condensed">
                <tr>
                    <td><html:button styleId="ide" property="method" onclick="generatexls()" value="EXPORT TO EXCEL" styleClass="btn  btn-primary btn-xs"/></td>
                    <td><html:button styleId="ids" property="method" onclick="generatepdf()" value="SAVE AS PDF" styleClass="btn btn-info btn-xs"/></td>
                    <td><html:button styleId="idm" property="method" onclick="generateminireport()" value="MINI REPORT" styleClass="btn  btn-warning btn-xs"/></td>
                </tr>
            </table>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Receipt No.</th>
                        <th>Receipt Date</th>
                        <th>Payment Mode</th>
                        <th>Remarks</th>
                        <th>Member Details</th>
                        <th>Group</th>
                        <th>Paid Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <logic:notEmpty name="paymentsReportsForm" property="lstpaymentstatus">
                        <logic:iterate id="details1" name="paymentsReportsForm" property="lstpaymentstatus">
                            <tr>
                                <html:hidden name="details1" property="paymentid" />
                                <td>
                                    <b><bean:write name="details1" property="paymentid" /></b>
                                </td>
                                <td>
                                    <bean:write name="details1" property="paiddate" />
                                </td>

                                <td>
                                    <bean:write name="details1" property="paymentmode" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="remarks" />
                                </td>
                                <td>
                                    <b><bean:write name="details1" property="membername" /></b><br/>
                                    <bean:write name="details1" property="memberinfo" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="group" />
                                </td>
                                <td>
                                    <b> Rs. <bean:write name="details1" property="paidamount" /> </b>
                                </td>
                            </tr>

                        </logic:iterate>
                    </logic:notEmpty>
                </tbody>
                <tfoot>
                    <tr style="font-weight: bold">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Total</td>
                        <td>
                            Rs. <bean:write name="paymentsReportsForm" property="totalamount" />
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </html:form>

</body>
</html>
