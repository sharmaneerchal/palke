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
        <title><%= session.getAttribute("brand")%> | New Order</title>
        <script type="text/javascript" src="js/allscripts.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/theme.css" rel="stylesheet"/>
        <link href="css/jquery-ui.css" rel="stylesheet"/>
        <link href="css/stylenew.css" rel="stylesheet"/>
        <%--Autocomplte--%>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="autocompleter.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/theme.css" rel="stylesheet">
        <style type="text/css">
            .input{
                width: 200px;
            }
        </style>
        <script>

        </script>
    </head>
    <body>
        <html:form>
            <jsp:include page="/jsp/common/orderheader.jsp" />
            <div style="font-size: 15px;padding-left: 15px" class="text-info">
                New Order
            </div>
            <div class="container">
                <table class="table table-condensed" cellpadding="3" cellspacing="3" >
                    <tr>
                        <td>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Customer Details</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table-condensed" style="font-size:12px;">
                                        <tr>
                                            <td>Customer Name</td>
                                            <td>
                                                <html:text  property="customername" title="Customer Name" styleClass="input input-sm"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Address</td>
                                            <td>
                                                <html:textarea  property="customeraddress" title="Customer Address" styleClass="input input-sm"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Contact No</td>
                                            <td>
                                                <html:text property="contact" title="Order Date" styleClass="input input-sm"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Order Date</td>
                                            <td>
                                                <html:text  onkeyup="var v = this.value;
                                                            if (v.match(/^\d{2}$/) !== null) {
                                                            this.value = v + '/';
                                                            } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
                                                            this.value = v + '/';
                                                            }" alt="dd-mm-yyyy" maxlength="10" property="orderdate" title="dd/mm/yyyy" styleClass="input input-sm"/>
                                            </td>

                                        </tr>
                                    </table>
                                    <!--<table style="float: right">
                                        <tr>
                                            <td>Similar customer found in previous orders</td>
                                    <!--show existing similar customer details in grid
                                    Show after confirmation only select the existing customer for order. otherwise order has to be reseted and reentered
                                 
                                </tr>
                            </table>   -->
                                </div>
                            </div>    
                        </td>
                        <!--  <td>
                              <div class="panel panel-primary">
                                  <div class="panel-heading">
                                      <h3 class="panel-title">Order History</h3>
                                  </div>
                                  <div class="panel-body">
                                      No orders found.
                                  </div>
                              </div>
                          </td> -->
                    </tr>  
                    <tr>
                        <td>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Gold Advance (Old Gold/Ornaments)</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-striped table-hover ">
                                        <thead>
                                            <tr>
                                                <th>SI. No</th>
                                                <th>Description</th>
                                                <th>Actual Quantity (Gm)</th>
                                                <th title="After Dust/Waste">Corrected Quantity (Gm)</th> <!-- after duct -->
                                                <th>Price</th> <!--Might be with reduction of all tax and labour -->
                                                <th>Remarks</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>  
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Jewell Order Details</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-striped table-hover ">
                                        <thead>
                                            <tr>
                                                <th>SI. No</th>
                                                <th>Jewels to be prepared with patterns</th>
                                                <th>Size</th>
                                                <th>To be prepared for (Gm)</th>
                                                <th>Estimated Price</th> <!--Might be with reduction of all tax and labour -->
                                                <th>Remarks</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Estimated Cost</h3>
                                </div>
                                <div class="panel-body">
                                    Panel content
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Advance Payment &amp Delivery Details</h3>
                                </div>
                                <div class="panel-body">
                                    Panel content
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Prepared By</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <html:button property="submit" styleClass="btn btn-primary" value="Submit"/>
                            <html:button property="submit" styleClass="btn btn-warning" value="Reset"/>
                            <html:button property="submit" styleClass="btn btn-default" value="Discard"/>
                        </td>

                    </tr>
                </table>

            </div>
        </html:form>
    </body>
</html:html>