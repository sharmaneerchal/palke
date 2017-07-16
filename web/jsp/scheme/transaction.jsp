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
        <title><%= session.getAttribute("brand")%> | Transactions</title>

        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <script>
            function onChangeGroup()
            {
                var URL = "transaction.do?method=changeGroup";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onPickGroup(groupid, group)
            {
                var URL = "transaction.do?method=changeGroup&groupid=" + groupid + "&group=" + group;
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onpickMember(member)
            {
                var URL = "memberaccount.do?method=fillPaymentDetails&memberno=" + member;
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({
                    "scrollY": "600px",
                    "scrollCollapse": true,
                    "paging": false
                }
                );
            });

        </script>
        <style>
            body { 
                /*background: url(images/smooth_wall.png)  repeat scroll left bottom #dbd9d3; */
            }
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
                    <li class="active"><a href="transaction.do?method=loadPage">Payment</a><span class="sr-only"></span></li>
                    <li><a href="addmember.do?method=displayGroups">Members</a></li>
                    <li><a href="creategroup.do?method=displayGroups">Groups</a></li>
                    <li><a href="paymentsreports.do?method=displayGroups">Payment Report</a></li>
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
    <div class="container-fluid">
        <html:form>
            <logic:notEqual value="" property="group" name="transactionForm"> 
                <span style="font-size: 16px" class="btn btn-danger">
                    <bean:write name="transactionForm" property="group"/>
                </span>
            </logic:notEqual>

            <div class="btn-group btn-group-sm">
                <logic:notEmpty name="transactionForm" property="groups">
                    <logic:iterate id="details" name="transactionForm" property="groups">
                       <!-- <a href="#" class="btn btn-default"><bean:write name="details" property="id"/></a> -->
                        <a  href="#" onclick="onPickGroup(<bean:write name="details" property="id"/>, '<bean:write name="details" property="label"/>');" class="btn btn-primary btn-large"><bean:write name="details" property="label"/></a>
                    </logic:iterate>
                </logic:notEmpty>
            </div>

            <table id="example" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th width="10%">Member No.</th>
                        <th>Member</th>
                    </tr>
                </thead>
                <tbody>
                    <logic:notEmpty name="transactionForm" property="lstMembers">
                        <logic:iterate id="details" name="transactionForm" property="lstMembers">
                            <tr>
                                <td class="text-center text-primary" ><b><bean:write name="details" property="memberno"/></b></td>
                                <td> 
                                    <a href="#" style="text-decoration: none"  onclick="onpickMember(<bean:write name="details" property="memberno"/>);" >
                                        <span class="text-primary text-capitalize"><b><bean:write name="details" property="membername"/></b></span>
                                        <span class="text-success"><bean:write name="details" property="memberaddress"/></span>
                                        <span class="text-warning"><bean:write name="details" property="contactno"/></span>
                                    </a>
                                </td>
                            </tr>
                        </logic:iterate>
                    </logic:notEmpty>
                </tbody>
            </table>
        </html:form>
    </div>
</body>
</html:html>