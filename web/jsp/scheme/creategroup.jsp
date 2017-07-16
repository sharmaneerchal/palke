
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
        <title><%= session.getAttribute("brand")%> | Groups</title> 

        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <style>
            body { 
                background: url(images/confectionary.png)  repeat scroll left bottom #dbd9d3; 
            }
        </style>
        <script>
            $(function () {
                $("#startdate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            $(function () {
                $("#enddate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true
                });
            });
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({
                    //"scrollY": "350px",
                    //  "scrollCollapse": true,
                    //  "paging": false
                }
                );
            });
            function checkIntegerinString() {
                var form = document.forms[0];
                if (((form.customerName.value.toString()).match(".*\\d.*"))) {
                    alert("please enter character on .Nos not allowed");
                    form.customerName.focus();
                    form.customerName.value = '';
                    return false;
                }

            }

            function onSave()
            {
                var form = document.forms[0];
                if (form.groupName.value === "")
                {
                    alert("Please enter Group name");
                    form.groupName.focus();
                    return false;
                } else if (form.noofmembers.value === "0")
                {
                    alert("Please enter No. of Members");
                    form.noofmembers.focus();
                    return false;
                } else if (form.noofinstallment.value === "0")
                {
                    alert("Please enter No. of installment");
                    form.noofinstallment.focus();
                    return false;
                } else if (form.installmentamount.value === "0.0")
                {
                    alert("Please enter installment amount");
                    form.installmentamount.focus();
                    return false;
                } else if (form.startdate.value === "")
                {
                    alert("Please enter Estimated Start Date");
                    form.startdate.focus();
                    return false;
                } else if (form.enddate.value === "")
                {
                    alert("Please enter Estimated End Date");
                    form.enddate.focus();
                    return false;
                }

                var URL = "creategroup.do?method=saveGroup";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            function onOK()
            {
                var form = document.forms[0];
                if (form.drawtype.value === "")
                {
                    alert("please select draw type");
                    form.drawtype.focus();
                    return false;
                } else if (form.position.value === "")
                {
                    alert("please select Position");
                    form.position.focus();
                    return false;
                } else if (form.placeamount.value === "0.0")
                {
                    alert("please enter prize amount");
                    form.placeamount.focus();
                    return false;
                }

                var URL = "creategroup.do?method=OK";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function resetMethod() {
                var URL = "creategroup.do?method=resetPage";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            window.setTimeout(function () {
                $(".alert").fadeTo(500, 0).slideUp(500, function () {
                    $(this).remove();
                });
            }, 4000);

        </script>
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
                    <li class="active"><a href="creategroup.do?method=displayGroups">Groups</a><span class="sr-only"></span></li>
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

    <html:form action="creategroup">
        <html:hidden name="GroupCreationForm" property="edit" />
        <html:hidden name="GroupCreationForm" property="rowid" />

        <div class="container-fluid">

            <logic:notEmpty property="message" name="GroupCreationForm">
                <div class="alert alert-danger" role="alert">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <bean:write name="GroupCreationForm" property="message" />
                </div>
            </logic:notEmpty>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Create Group</h3>
                </div>
                <div class="panel-body">
                    <table class="table-condensed">
                        <tr>
                            <td>Group Name</td>
                            <td><html:text property="groupName" title="enter group name" styleClass="form-control"/></td>

                            <td>No. of Members</td> 
                            <td><html:text property="noofmembers" title="enter no. of members" styleClass="form-control"/></td>

                            <td>Estimated Start Date</td> 

                            <td>
                                <html:text property="startDate" styleId="startdate" title="dd/mm/yyyy"  styleClass="form-control"/>
                            </td> 
                        </tr>
                        <tr>
                            <td>Estimated End Date</td> 

                            <td>
                                <html:text property="endDate"  styleId="enddate"  title="dd-mm-yyyy" styleClass="form-control"/>
                            </td> 

                            <td>No. of Installment</td>

                            <td>
                                <html:text value="20" property="noofinstallment" title="enter no of installment" styleClass="form-control"/>
                            </td>

                            <td>Installment Amount(Per Installment)</td>
                            <td>
                                <html:text property="installmentamount" title="enter amount" styleClass="form-control"/>
                            </td>
                        </tr>

                    </table>
                </div>
                <div class="panel-footer text-right">
                    <html:button property="method" onclick="onSave()" value="Save" styleClass="btn btn-primary btn-sm"/>
                    <html:button property="method" onclick="resetMethod()" value="Reset" styleClass="btn btn-default btn-sm"/>
                </div>
            </div>

            <table id="example" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Group Name</th>
                        <th>Estimated Start Date</th>
                        <th>Estimated End Date</th>
                        <th>Max Members</th>
                        <th>Existing Members</th>
                        <th>Installments</th>
                        <th>Installment Amount</th>
                        <th>Status</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <logic:notEmpty name="GroupCreationForm" property="groupDetails">
                        <logic:iterate id="details1" name="GroupCreationForm" property="groupDetails">
                            <tr>
                                <td>
                                    <html:hidden name="details1" property="groupid" />
                                    <html:hidden name="details1" property="rowid" />
                                    <bean:write name="details1" property="groupname" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="startdate" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="enddate" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="noofmembers" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="noofexistmembers" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="noofinstallments" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="installmentamount" />
                                </td>
                                <td>
                                    <span class="text text-success">
                                        <bean:write name="details1" property="status" />
                                    </span>
                                </td>
                                <td>
                                    <a href="creategroup.do?method=editGroup&rowid=<bean:write name="details1" property="groupid"/>">Edit</a>
                                </td>
                                <td>
                                    <html:checkbox property="withmember" name="GroupCreationForm" title="check this if you want to delete the group with members"/>
                                    Members
                                    <a onclick="if (!confirm('Are you sure you want to delete this Group ?'))
                                                return false;" href="creategroup.do?method=deleteGroup&rowid=<bean:write name="details1" property="groupid"/>">Delete</a>
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