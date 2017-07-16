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
<meta http-equiv="refresh" content="2" >
<html:html>
    <head>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <title><%= session.getAttribute("brand")%> | Computer generated workers memo receipt.</title>
        <link href="css/jquery-ui.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script>
            function printDiv(divID) {
                //Get the HTML of div
                var divElements = document.getElementById(divID).innerHTML;
                //Get the HTML of whole page
                var oldPage = document.body.innerHTML;

                //Reset the page's HTML with div's HTML only
                document.body.innerHTML =
                        "<html><head><title></title></head><body>" +
                        divElements + "</body>";

                //Print Page
                window.print();

                //Restore orignal HTML
                document.body.innerHTML = oldPage;
            }
        </script>
        <style>
            body {
                transform: scale(1);
            }
        </style>
    </head>
    <body>
        <html:form>
            <div class="container">
                <div align="right">
                    <a href="#" onclick="javascript:printDiv('printablediv')">Print</a>
                </div>
                <div id="printablediv" >
                    <logic:equal name="WorkersMemoForm" property="print" value="true">
                        <br/>
                        <div align="center">
                            WORKERS MEMO
                        </div>
                        <table  class="table-condensed" border="1" align="center">
                            <tr>
                                <td>
                                    <span style="font-size: 20px;font-weight: bold"><%= session.getAttribute("brand")%></span><br/>MANGALURU
                                </td>
                                <td><span style="font-size: 15px;font-weight: bold">No. <bean:write name="WorkersMemoForm" property="printmemoid" /></span></td>
                            </tr>
                            <tr>
                                <td>
                                    Worker's Name : <b><bean:write name="WorkersMemoForm" property="printworker" /></b><br/>
                                    Address : <bean:write name="WorkersMemoForm" property="printaddress" />
                                </td>
                                <td>
                                    Date : <b><bean:write name="WorkersMemoForm" property="printdate" /></b>
                                </td>
                            </tr>
                        </table>
                        <br/>
                        <table class="table-condensed table-bordered" align="center">
                            <tr>
                                <td>Order No</td>
                                <td>Ornament details</td>
                                <td>Weight/Length</td>
                                <td>Net weight</td>
                            </tr>
                            <tr>
                                <td><b><bean:write name="WorkersMemoForm" property="printOrderno" /></b></td>
                                <td><b><bean:write name="WorkersMemoForm" property="printjewel" /></b></td>
                                <td><b><bean:write name="WorkersMemoForm" property="printsize" /></b></td>
                                <td><b><bean:write name="WorkersMemoForm" property="printnetweight" format="##0.000"/></b></td>
                            </tr>
                        </table>
                        <br/>
                        <table class="table-condensed" align="center">
                            <tr>
                                <td>Jewel to be ready by <b><bean:write name="WorkersMemoForm" property="printreadydate" /></b></td>
                                <td style="padding-left: 100px">Stone weight <b><bean:write name="WorkersMemoForm" property="printstoneweight" format="##0.000"/></b></td>
                            </tr>
                            <tr>
                                <td>Gold issued : <b><span style="font-size: 20px"><bean:write name="WorkersMemoForm" property="printgoldweight" format="##0.000"/></b></span></td>
                                <td style="padding-left: 100px"></td>
                            </tr>
                            <tr>
                                <td><i><br/><br/><br/><b>Signature of worker</b></i></td>
                                <td style="padding-left: 100px"><i>For</i> <b><%= session.getAttribute("brand")%></b><br/><br/><br/><i><b>Partner</b></i></td>
                            </tr>
                        </table>
                    </logic:equal>
                </div>
                <logic:equal name="WorkersMemoForm" property="print" value="false">
                    <logic:notEmpty property="message" name="WorkersMemoForm">
                        <div class="alert alert-danger" role="alert">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <bean:write name="WorkersMemoForm" property="message" /><br/>
                            <center>No data found for print</center>
                        </div>
                    </logic:notEmpty>

                </logic:equal>

            </div>

        </html:form>
    </body>
</html:html>