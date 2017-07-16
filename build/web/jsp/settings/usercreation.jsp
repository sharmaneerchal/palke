<%-- 
    Document   : paymententry
    Created on : 3 Mar, 2014, 8:16:20 PM
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

        <title><%= session.getAttribute("brand")%> | Create User</title>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">

        <style type="text/css">

            .input{
                width: 200px;
            }

        </style>
        <script type="text/javascript">

            function popupCalender(param)
            {
                var cal = new Zapatec.Calendar.setup({
                    inputField: param, // id of the input field
                    singleClick: true, // require two clicks to submit
                    ifFormat: "%d-%m-%Y", // format of the input field
                    showsTime: false, // show time as well as date
                    button: "button2" // trigger button
                });
            }

            function onSave()
            {
                var form = document.forms[0];
                if (form.username.value === "")
                {
                    alert("please enter username");
                    form.username.focus();
                    return false;
                }
                else if (form.password.value === "")
                {
                    alert("please enter password");
                    form.password.focus();
                    return false;
                }

                var URL = "usercreation.do?method=saveUserDetails";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
        </script>

    </head>

    <body>
        <jsp:include page="/jsp/common/header.jsp" />
        <html:form action="usercreation">

            <div class="panel panel-heading">
                <p class="h4 text-info">User Creation</p>
            </div>
            <div id="first" class="panel-body">
                <table class="table-condensed">
                    <tr>
                        <td>Username</td>
                        <td> <html:text property="username" styleClass="input input-sm"/> </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td> <html:password property="password" styleClass="input input-sm"/> </td>
                    </tr>
                    <tr>
                        <td>Admin</td>
                        <td><html:checkbox property="admin"/></td>
                    </tr>
                </table>
                <table class="table-condensed">
                    <tr>
                        <td>
                            <html:button  property="method" value="Create" onclick="onSave()" styleClass="btn btn-primary"/>
                        </td>  
                        <td>
                            <logic:notEmpty name="messageUsercreation">
                                <div style="color: red" >
                                    User created successfully.
                                </div>
                            </logic:notEmpty>  
                        </td>
                    </tr>
                </table>

                <table class="table-condensed table-bordered">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Admin</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <logic:notEmpty name="usersettingsForm" property="lstusers">
                            <logic:iterate id="details" name="usersettingsForm" property="lstusers">
                                <tr>
                                    <html:hidden name="details" property="userid" />
                                    <td>
                                        <bean:write name="details" property="username"/>
                                    </td>
                                    <td>
                                        <bean:write name="details" property="admin"/>
                                    </td>
                                    <td>
                                        <a href="usercreation.do?method=deleteUser&userid=<bean:write name="details" property="userid"/>">Delete</a>
                                    </td>
                                </tr>

                            </logic:iterate>
                        </logic:notEmpty>
                    </tbody>
                </table>
            </div>
        </html:form>
        <jsp:include page="/jsp/common/footer.jsp" />
    </body>
</html>