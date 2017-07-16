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

        <title><%= session.getAttribute("brand")%> | Change Password</title>
       
        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">

        <style type="text/css">
            .input{
                width: 200px;
            }
        </style>
        <script type="text/javascript">


            function onSave()
            {
                var form = document.forms[0];
                if (form.password.value !== form.confirmpassword.value)
                {
                    alert("password and confirm password not matching.");
                    form.password.focus();
                    return false;
                }
                else if (form.password.value === form.oldpassword.value)
                {
                    alert("old password and new password should not be same.");
                    form.password.focus();
                    return false;
                }
                else if (form.password.value === "")
                {
                    alert("please enter new password");
                    form.password.focus();
                    return false;
                }
                else if (form.confirmpassword.value === "")
                {
                    alert("please enter confirm password");
                    form.confirmpassword.focus();
                    return false;
                }

                var URL = "changepassword.do?method=updatePassword";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
        </script>

    </head>

    <body>
        <jsp:include page="/jsp/common/header.jsp" />
        <html:form action="changepassword">

            <div class="panel panel-heading">
                <p class="h3 text-info">Change Password</p>
            </div>

            <div id="first" class="panel-body">
                <table class="table-condensed" style="font-size:12px">
                    <tr>
                        <td>Username</td>
                        <td> <html:text property="username" styleClass="input input-sm" readonly="true"/> </td>
                    </tr>
                    <tr>
                        <td>Old Password</td>
                        <td> <html:password property="oldpassword" styleClass="input input-sm"/> </td>
                    </tr>
                    <tr>
                        <td>New Password</td>
                        <td> <html:password property="password" styleClass="input input-sm"/> </td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td> <html:password property="confirmpassword" styleClass="input input-sm"/> </td>
                    </tr>
                </table>
                <table class="table-condensed">
                    <tr>
                        <td>
                            <html:button  property="method" value="Update" onclick="onSave()" styleClass="btn btn-primary"/>
                        </td>  
                        <td>
                            <logic:notEmpty name="messageUsercreation">
                                <div style="color: red" >
                                    Password changed successfully.
                                </div>
                            </logic:notEmpty>  
                        </td>
                    </tr>
                </table>

            </div>
        </html:form>
        <jsp:include page="/jsp/common/footer.jsp" />
    </body>
</html>