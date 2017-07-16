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
        <title><%= session.getAttribute("brand")%> | Data Entry</title>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>

        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">

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

            function saveDrawType()
            {
                var form = document.forms[0];
                if (form.drawtypes.value === "")
                {
                    alert("please enter draw type");
                    form.drawtypes.focus();
                    return false;
                }
                var URL = "dataentry.do?method=saveDrawtypes";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            function savePositions()
            {
                var form = document.forms[0];
                if (form.position.value === "")
                {
                    alert("please enter position");
                    form.position.focus();
                    return false;
                }
                var URL = "dataentry.do?method=savePositions";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            function savePaymentmode()
            {
                var form = document.forms[0];
                if (form.paymentmode.value === "")
                {
                    alert("please enter payment mode.");
                    form.position.focus();
                    return false;
                }
                var URL = "dataentry.do?method=savePaymentmode";
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
        <html:form action="dataentry">

            <div class="row" style="padding-left: 15px">
                <div class="col-sm-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Prize Types</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table-condensed" style="font-size:12px">
                                <tr>
                                    <td>Draw Type</td>
                                    <td> <html:text property="drawtypes" styleClass="input input-sm"/> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <html:button  property="method" value="Save" onclick="saveDrawType()" styleClass="btn btn-primary btn-sm"/>
                                    </td>  
                                </tr>
                            </table>
                            <table class="table table-bordered table-striped" rules="rows" style="font-size:12px">
                                <thead>
                                    <tr>
                                        <th>Draw Type</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="dataentryForm" property="lstdrawtypes">
                                        <logic:iterate id="details" name="dataentryForm" property="lstdrawtypes">
                                            <tr>
                                                <html:hidden name="details" property="drawtypeid" />
                                                <td>
                                                    <bean:write name="details" property="drawtypes"/>
                                                </td>
                                                <td>
                                                    <a href="dataentry.do?method=deleteDrawtypes&drawtypeid=<bean:write name="details" property="drawtypeid"/>">Delete</a>
                                                </td>
                                            </tr>

                                        </logic:iterate>
                                    </logic:notEmpty>
                                </tbody>
                            </table>
                            <br/>
                            <logic:notEmpty property="message" name="dataentryForm">
                                <div class="alert alert-danger" role="alert">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <bean:write name="dataentryForm" property="message" />
                                </div>
                            </logic:notEmpty>
                        </div>
                    </div>
                </div> 
                <!--              
              <div class="col-sm-4">
                  <div class="panel panel-default">
                      <div class="panel-heading">
                          <h3 class="panel-title">Payment Modes</h3>
                      </div>
                      <div class="panel-body">
                          <table class="table-condensed" style="font-size:12px">
                              <tr>
                                  <td>Payment Mode</td>
                                  <td> <html:text property="paymentmode" styleClass="input input-sm"/> </td>
                              </tr>
                          </table>
                          <table class="table-condensed">
                              <tr>
                                  <td>
                <html:button  property="method" value="Save" onclick="savePaymentmode()" styleClass="btn btn-primary"/>
            </td> 
        </tr>
    </table>
    <table class="table-striped table-bordered table-condensed" rules="rows" style="font-size:12px">
        <tr>
            <th>Payment Mode</th>
            <th>Delete</th>
        </tr>
                <logic:notEmpty name="dataentryForm" property="lstPaymentModes">
                    <logic:iterate id="details" name="dataentryForm" property="lstPaymentModes">
                        <tr>
                        <html:hidden name="details" property="paymentmodeid" />
                        <td>
                        <bean:write name="details" property="paymentmode"/>
                    </td>
                    <td>
                        <a href="dataentry.do?method=deletePaymentmode&paymentmodeid=<bean:write name="details" property="paymentmodeid"/>">Delete</a>
                    </td>
                </tr>

                    </logic:iterate>
                </logic:notEmpty>
            </table>
        </div>
    </div>
</div> -->
            </div>

        </html:form>
        <jsp:include page="/jsp/common/footer.jsp" />
    </body>
</html>