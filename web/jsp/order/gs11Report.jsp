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
        <title><%= session.getAttribute("brand")%> | GS 11</title>
        <link href="css/jquery-ui.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script>
            function printpage() {
                window.print();
            }
        </script>
    </head>
    <body>
        <html:form>
            <div class="container">
                <div align="right">
                    <a href="#" onclick="printpage()">Print</a>
                </div>
                <div align="center">
                    <%= session.getAttribute("brand")%><br/>G. H. S. Road, Mangalore.
                </div>
                <div align="right">
                    Report Date : <bean:write name="TransactionReportForm" property="reportdate" format="dd/MM/yyyy" />
                </div>
                <div align="left">
                    Particular : <bean:write name="TransactionReportForm" property="type"/>
                </div>
                <div align="center">
                    GS 11 Report
                </div>
                Opening Balance : <bean:write name="TransactionReportForm" property="carrybalance" format="##0.000"/>

                <table class="table table-condensed" border="1">
                    <thead>
                        <tr>
                            <th width="12%">Date</th>
                            <th width="30%">
                                <span style="float: left">Receipt</span>
                                <span style="float: right;padding-right: 30px">Weight</span>
                            </th>
                            <th width="30%">
                                <span style="float: left">Issues</span>
                                <span style="float: right;padding-right: 30px">Weight</span>
                            </th>
                            <th style="padding-left: 20px">Balance</th>
                        </tr>
                    </thead>
                    <!--   <tfoot>
                           <tr style="font-weight: bold">
                               <td>Total</td>
                               <td class="text-right"><bean:write name="TransactionReportForm" property="credittotal" format="##0.000"/></td>
                               <td class="text-right"><bean:write name="TransactionReportForm" property="debittotal" format="##0.000"/></td>
                               <td class="text-left"><bean:write name="TransactionReportForm" property="balancetotal" format="##0.000"/></td>
                           </tr>
                       </tfoot> -->
                    <tbody>
                        <logic:notEmpty name="TransactionReportForm" property="lstprint">
                            <logic:iterate id="details" name="TransactionReportForm" property="lstprint" indexId="index">
                                <tr>
                                    <td><bean:write name="details" property="date"/></td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstcredit">
                                            <table class="table table-condensed table-bordered">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstcredit">
                                                        <tr>
                                                            <td><bean:write name="details1" property="desc" /></td>
                                                            <td class="text-right" style="padding-right: 30px"><bean:write name="details1" property="weight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstdebit">
                                            <table class="table table-condensed table-bordered">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstdebit">
                                                        <tr>
                                                            <td><bean:write name="details1" property="desc" /></td>
                                                            <td class="text-right" style="padding-right: 30px"><bean:write name="details1" property="weight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td style="vertical-align: bottom;padding-left: 20px">
                                        <b><bean:write name="details" property="balance" format="##0.000"/></b>
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