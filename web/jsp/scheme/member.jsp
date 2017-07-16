<%-- 
    Document   : member
    Created on : 27 Feb, 2014, 11:45:50 PM
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
<!DOCTYPE html>
<html:html>
    <head>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <title><%= session.getAttribute("brand")%> | Member</title>


        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <script type="text/javascript">
            $(document).ready(function () {
                // $('#example').dataTable();
                $('#example').dataTable({
                    "bSort": false
                }
                );
            });
            $(function () {
                $("#accordion").accordion({
                    collapsible: true
                });
            });
            function onSave()
            {
                var form = document.forms[0];
                if (form.group.value === "")
                {
                    alert("please select group");
                    form.group.focus();
                    return false;
                } else if (form.membername.value === "")
                {
                    alert("please enter member name");
                    form.membername.focus();
                    return false;
                } else if (form.contactno.value === 0)
                {
                    alert("please enter contact no");
                    form.contactno.focus();
                    return false;
                }

                var URL = "addmember.do?method=saveMember";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onclear()
            {
                var URL = "addmember.do?method=clear";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onReset() {
                var URL = "addmember.do?method=reset";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            function fillMembers() {
                var URL = "addmember.do?method=getMemberDetails";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function onSelectMember()
            {
                var URL = "addmember.do?method=getMemberDetailsbymemberid";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            window.setTimeout(function () {
                $(".alert").fadeTo(500, 0).slideUp(500, function () {
                    $(this).remove();
                });
            }, 4000);
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
                    <li class="active"><a href="addmember.do?method=displayGroups">Members</a><span class="sr-only"></span></li>
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

    <html:form>
        <div class="container-fluid">
            <div  class="panel panel-primary" >
                <div class="panel-body">
                    <table class="table-condensed">
                        <html:hidden property="memberid"/>
                        <html:hidden property="memberno"/>
                        <tr>
                            <td>Group</td>
                            <td>
                                <html:select  property="group" styleClass="input-sm" onchange="fillMembers()">
                                    <html:option value="">--Select--</html:option>
                                    <html:optionsCollection property="groups"  value="id" label="label" />
                                </html:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Member Name</td>
                            <td>   
                                <html:text property="membername" title="enter member name" styleClass="form-control"/>
                            </td>
                            <td>Contact No.</td>
                            <td><html:text property="contactno" title="enter contact no" styleClass="form-control"/></td>
                            <td>E-mail</td>
                            <td><html:text property="email" title="enter email address" styleClass="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Member Address</td>
                            <td><html:textarea property="address" title="enter member address" styleClass="form-control"/></td>
                        </tr>
                    </table>
                    <br/>
                    <logic:notEmpty property="message" name="AddMemberForm">
                        <div class="alert alert-danger" role="alert">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <bean:write name="AddMemberForm" property="message" />
                        </div>
                    </logic:notEmpty>
                </div>  
                <div class="panel-footer text-right">
                    <html:button property="method" onclick="onSave()" value="Save" styleClass="btn btn-sm btn-primary"/>
                    <html:button property="method" onclick="onclear()" value="Clear" styleClass="btn btn-sm btn-default"/>
                </div>
            </div>
            <table id="example" class="table table-striped table-bordered" style="font-size: 13px">
                <thead>
                    <tr>
                        <th width="10%">Member No</th>
                        <th width="20%">Member Name</th>
                        <th width="30%">Address</th>
                        <th>Contact No</th>
                        <th>E-mail</th>
                        <th>Join Date</th>
                        <th>Edit</th>
                        <!--      <th>Delete</th> -->
                    </tr>
                </thead>
                <tbody>
                    <logic:notEmpty name="AddMemberForm" property="lstMembers">
                        <logic:iterate id="details1" name="AddMemberForm" property="lstMembers">
                            <tr>
                                <html:hidden name="details1" property="memberid" />
                                <html:hidden name="details1" property="groupid" />
                                <td>
                                    <bean:write name="details1" property="memberno" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="membername" />
                                </td>

                                <td>
                                    <bean:write name="details1" property="memberaddress" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="contactno" />
                                </td>
                                <td>
                                    <bean:write name="details1" property="email" />
                                </td>
                                <td style="width: 80px">
                                    <bean:write name="details1" property="joinDate" />
                                </td>
                                <td>
                                    <a href="addmember.do?method=editMembers&memberid=<bean:write name="details1" property="memberid"/>">Edit</a>
                                </td>
                                <!--<td>
                                    <a onclick="if (!confirm('Are you sure you want to delete this delete Member ?'))
                                                return false;" href="addmember.do?method=removeMember&memberid=<bean:write name="details1" property="memberid"/>"Delete</a>
                                </td> -->
                            </tr>

                        </logic:iterate>
                    </logic:notEmpty>
                </tbody>
            </table>

        </div>
    </html:form>
</body>
</html:html>
