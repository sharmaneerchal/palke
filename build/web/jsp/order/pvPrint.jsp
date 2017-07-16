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
        <title><%= session.getAttribute("brand")%> | Voucher Receipt</title>
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
                <table class="table-condensed" align="center">
                    <tr>
                        <td width="150px">
                            Tel : 2424756<br/>
                            TIN : 29110704414<br/>
                            CST : 3095342-0
                        </td>
                        <td width="300px">
                            <div align="center">
                                <span style="text-decoration: underline;font-weight: bold">PURCHASE VOUCHER</span>
                                <br/>
                                <strong style="font-size: 25px"><%= session.getAttribute("brand")%></strong>
                                <br/>
                                <span style="font-weight: bold">
                                    G. H. SCHOOL ROAD,
                                    MANGALORE-575001.
                                </span>
                            </div>
                        </td>
                        <td width="150px">
                            Sl No. <b><bean:write name="VouchersForm" property="slno" /></b><br/>
                            Voucher No : <b><bean:write name="VouchersForm" property="voucherno" /></b><br/>
                            Date : <bean:write name="VouchersForm" property="printdate" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" style="font-weight: bold">
                            <br/>
                            Name :  <bean:write name="VouchersForm" property="printname" />
                        </td>
                    </tr>
                </table>
                <br/><br/>
                <table class="table-condensed table-bordered" align="center">
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Rate</th>
                            <th>Weight</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><bean:write name="VouchersForm" property="description" /></td>
                            <td><bean:write name="VouchersForm" property="description" /></td>
                            <td><bean:write name="VouchersForm" property="netweight" format="##0.000"/></td>
                            <td><bean:write name="VouchersForm" property="printamount" format="##0.00"/></td>
                        </tr>
                    </tbody>
                </table>
                <table class="table-condensed" align="center">
                    <tr>
                        <td>
                            <br/><br/><br/>
                            <i><b>Signature of the Seller</b></i>
                        </td>
                        <td style="padding-left: 150px">
                            <br/><br/><br/>
                            <i><b>Partner</b></i>
                        </td>
                    </tr>
                </table>
            </div>
        </html:form>
    </body>
</html:html>