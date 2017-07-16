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
        <title><%= session.getAttribute("brand")%> | GS 12</title>
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
                <div align="center">
                    GS 12 Report
                </div>
                Opening Net weight Balance : <bean:write name="TransactionReportForm" property="netcarryBalance" format="##0.000"/>
                <br/>
                Opening Gross weight Balance : <bean:write name="TransactionReportForm" property="grosscarryBalance" format="##0.000"/>

                <table class="table table-condensed" border="1">
                    <thead>
                        <tr>
                            <th width="10%" style="vertical-align: middle">Date</th>
                            <th style="vertical-align: middle">
                                <center>Receipts</center>
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>Memo No</th>
                                            <th>Gross Weight</th>
                                            <th>Net Weight</th>
                                        </tr>
                                    </tbody> 
                                </table>
                            </th>
                            <th style="vertical-align: middle">
                                <center>Sales</center>
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>Bill No</th>
                                            <th>Gross Weight</th>
                                            <th>Net Weight</th>
                                        </tr>
                                    </tbody> 
                                </table>
                            </th>
                            <th style="vertical-align: middle">
                                &nbsp;
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>Gross Weight</th>
                                            <th>Net Weight</th>
                                        </tr>
                                    </tbody> 
                                </table>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <logic:notEmpty name="TransactionReportForm" property="lstprint">
                            <logic:iterate id="details" name="TransactionReportForm" property="lstprint" indexId="index">
                                <tr>
                                    <td  style="vertical-align: top"><bean:write name="details" property="date"/></td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstreceipt">
                                            <table class="table table-condensed table-bordered">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstreceipt">
                                                        <tr>
                                                            <td><strong><bean:write name="details1" property="memono" /></strong></td>
                                                            <td><bean:write name="details1" property="grossweight" format="##0.000"/></td>
                                                            <td><bean:write name="details1" property="netweight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td>
                                        <logic:notEmpty name="details" property="lstsales">
                                            <table class="table table-condensed table-bordered">
                                                <tbody>
                                                    <logic:iterate id="details1" name="details" property="lstsales">
                                                        <tr>
                                                            <td><bean:write name="details1" property="memono" /></td>
                                                            <td><bean:write name="details1" property="grossweight" format="##0.000"/></td>
                                                            <td><bean:write name="details1" property="netweight" format="##0.000"/></td>
                                                        </tr>
                                                    </logic:iterate>
                                                </tbody>
                                            </table>
                                        </logic:notEmpty>
                                    </td>
                                    <td style="vertical-align: bottom;padding-left: 20px">
                                        <table class="table table-condensed table-bordered">
                                            <tbody>
                                                <tr>
                                                    <td><bean:write name="details" property="grossweightbalance" format="##0.000"/></td> 
                                                    <td><bean:write name="details" property="netweightbalance" format="##0.000"/></td>
                                                </tr>
                                            </tbody>
                                        </table>
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