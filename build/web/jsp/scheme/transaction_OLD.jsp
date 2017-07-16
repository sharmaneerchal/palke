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
        <title><%= session.getAttribute("brand")%> | Transactions</title>
        <script type="text/javascript" src="js/allscripts.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/jquery-ui.css" rel="stylesheet"/>
        <link href="css/stylenew.css" rel="stylesheet"/>
        <%--Autocomplte--%>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="autocompleter.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link href="css/theme.css" rel="stylesheet">
        <style type="text/css">
            .input{
                width: 200px;
            }
            .paymentpanel{cursor: pointer;background: none;
                          border: 1px solid #CCC;
                          width: auto;
                          -moz-box-shadow: none;
                          -webkit-box-shadow: none;
                          box-shadow: none;
                          padding: 5px;
                          -webkit-border-radius: 2px;
                          -moz-border-radius: 2px;
                          border-radius: 2px;
                          width: 93%;
                          vertical-align: top;width: 100%;margin-top: 2px}
            </style>
            <script>
                function onChangeGroup()
                {
                    var URL = "transactionold.do?method=changeGroup";
                    document.forms[0].action = URL;
                    document.forms[0].submit();
                }
                function onSelectMember()
                {
                    var member = document.getElementById("autoText").value;
                    var URL = "transactionold.do?method=fillPaymentDetails&selectedmember=" + member;
                    document.forms[0].action = URL;
                    document.forms[0].submit();
                }

                function onSavePayment(input, mode)
                {
                    var form = document.forms[0];
                    if (form.groupid.value === "")
                    {
                        alert("please select group");
                        form.group.focus();
                        return false;
                    }
                    else if (form.date.value === "") {
                        alert("please select date.");
                        form.date.focus();
                        return false;

                    } else if (form.paymentmode.value === "") {
                        alert("please select Payment Mode.");
                        form.paymentmode.focus();
                        return false;
                    }
                    if (mode === 'entry') {
                        disableOnSubmit(input);
                        var count = document.getElementById("count").value;
                        var URL = "transactionold.do?method=savePayment&term=" + count;
                        document.forms[0].action = URL;
                        document.forms[0].submit();
                        document.getElementById('count').value = 0;

                    } else if (mode === 'edit') {
                        disableOnSubmit(input);
                        var count = document.getElementById("count").value;
                        var URL = "transactionold.do?method=updatePayment&term=" + count;
                        document.forms[0].action = URL;
                        document.forms[0].submit();
                        document.getElementById('count').value = 0;

                    }
                }

                function disableOnSubmit(input) {
                    setTimeout('disableAfterTimeout(\'' + input.id + '\');', 50);
                }
                function disableAfterTimeout(id) {
                    var toDisable = document.getElementById(id);
                    toDisable.disabled = 'disabled';
                    // Use the Salesforce CSS style to make the button appear disabled
                    toDisable.className = 'btn  btn-info btn-sm';
                    toDisable.value = "Saving...";
                }

                function onOpenPayment(term, mode)
                {
                    var form = document.forms[0];

                    document.getElementById("date").value = "";
                    form.amount.value = "500";
                    form.paymentmode.value = "cash";
                    form.remarks.value = "";

                    if (mode === 'entry') {
                        //alert(term);
                        //form.disablepayment.value = "0";
                        document.getElementById("count").value = term;
                        document.getElementById("idsave").style.display = '';
                        document.getElementById("idupdate").style.display = 'none';
                        document.getElementById("note").style.display = 'none';
                    } else if (mode === 'edit') {
                        document.getElementById("count").value = term;
                        document.getElementById("idsave").style.display = 'none';
                        document.getElementById("idupdate").style.display = '';
                        document.getElementById("note").style.display = '';


                        $.ajax({
                            type: "POST",
                            url: "transactionold.do?method=editPayment&term=" + term,
                            success: function(response) {
                                //we have the response
                                //$('#info').html(response);

                                // alert(data);
                            },
                            error: function(e) {
                                alert('Error: ' + e);

                            }
                        });

                        var cells = Array.prototype.slice.call(document.getElementById("tbl").getElementsByTagName("font"));
                        // for (var i in cells) {
                        //   if (cells[term + 1].innerHTML.toString().length > 5) {
                        //alert("My contents is \"" + cells[term - 1].innerHTML + "\"");
                        var data = cells[term - 1].innerHTML;
                        //alert(data);

                        var pay = data.split("-");
                        form.date.value = pay[1].toString().trim();
                        document.getElementById("date").value = pay[1].toString().trim();
                        form.amount.value = parseInt(pay[2].toString().trim());
                        var pay2 = pay[3].toString().split("\n");
                        form.paymentmode.value = pay2[0].toLowerCase().trim().toString();
                        form.remarks.value = pay2[1].toString().trim();
                        //  }
                        // }
                    }

                }

                function onDeletePayment(term)
                {
                    var val = confirm("Do you want to delete the payment entry");
                    if (val) {
                        var URL = "transactionold.do?method=cancelPayment&term=" + term;
                        document.forms[0].action = URL;
                        document.forms[0].submit();
                    } else {
                        var URL = "transactionold.do?method=cancelPayment&term=0";
                        document.forms[0].action = URL;
                        document.forms[0].submit();
                    }
                }

                function onOpenPrize(term)
                {
                    //alert(term);
                    document.getElementById("count").value = term;
                    document.getElementById("termlbl").innerHTML = term;

                }
                function onPrizeEntry()
                {
                    var count = document.getElementById("count").value;

                    var form = document.forms[0];
                    if (form.groupid.value === "")
                    {
                        alert("please select group");
                        form.group.focus();
                        return false;
                    }
                    if (count === "0")
                    {
                        alert("please select term");
                        form.member.focus();
                        return false;
                    }
                    if (form.prizeamount.value === "0.0")
                    {
                        alert("please enter amount");
                        form.member.focus();
                        return false;
                    }
                    if (form.drawtypeid.value === "0")
                    {
                        alert("please select draw type");
                        form.member.focus();
                        return false;
                    }
                    var count = document.getElementById("count").value;
                    var form = document.forms[0];
                    var URL = "transactionold.do?method=savePrize&term=" + count;
                    form.action = URL;
                    form.submit();
                }
                function onDeletePrize(term)
                {

                    var val = confirm("Do you want to delete the payment entry");
                    if (val) {
                        var URL = "transactionold.do?method=deletePrize&term=" + term;
                        document.forms[0].action = URL;
                        document.forms[0].submit();
                    } else {
                        var URL = "transactionold.do?method=deletePrize&term=0";
                        document.forms[0].action = URL;
                        document.forms[0].submit();
                    }

                }
                function printReceipt(term)
                {
                    var URL = "transactionold.do?method=printReciept&term=" + term;
                    document.forms[0].action = URL;
                    document.forms[0].submit();
                }
                function saveStartdate()
                {
                    var form = document.forms[0];
                    var URL = "transactionold.do?method=saveStartdate";
                    form.action = URL;
                    form.submit();
                }
                function updateSettlement()
                {
                    var form = document.forms[0];
                    if (form.settlementcomment.value === "")
                    {
                        alert("please enter remarks.");
                        form.group.focus();
                        return false;
                    }

                    var form = document.forms[0];
                    var URL = "transactionold.do?method=accountSettlement";
                    form.action = URL;
                    form.submit();
                }
                function onreport()
                {
                    var URL = "transactionold.do?method=generatememberreport";
                    document.forms[0].action = URL;
                    document.forms[0].submit();

                }


            </script>
        </head>
        <body>
            <jsp:include page="/jsp/common/header.jsp" />
            <!-- header -->
            <!-- Fixed navbar -->
            <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="gohome.do?method=displayAppHome"><%= session.getAttribute("brand")%></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="gohome.do?method=displayHome">Home</a></li>
                        <li class="active"><a href="transaction.do?method=loadPage">Payment</a></li>
                        <!--  <li><a href="Groupmemberdetails.do?method=displayGroupsdetails" >Transactions</a></li> -->
                        <li><a href="addmember.do?method=displayGroups">Members</a></li>
                        <!--  <li><a href="draw.do?method=displayGroups">Prizes</a></li> -->
                        <li><a href="creategroup.do?method=displayGroups">Groups</a></li>
                        <li><a href="paymentsreports.do?method=displayGroups">Payment Report</a></li>
                        <!--  <li class="dropdown">
                          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports <b class="caret"></b></a>
                          <ul class="dropdown-menu">
                              <li><a href="paymentsreports.do?method=displayGroups">Payment Report</a></li>
                          </ul>
                      </li> -->
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
                        <li><a href="../navbar/"></a></li>
                        <li><a href="#"  style="font-style: italic;"t class="text text-info"><bean:write  name="userName" /></a></li>
                        <li class="active"><a href="logout.do?method=logout">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
        <!-- end -->
        <html:form>
            <div class="container">
                <div id="first">      
                    <input type="hidden" id="count"/>
                    <table class="table-condensed" style="font-size:12px;">
                        <tr>
                            <td>Group</td>
                            <td><html:select  property="groupid" styleClass="input input-sm" onchange="onChangeGroup()">
                                    <html:option value="0">--Select--</html:option>
                                    <html:optionsCollection property="groups"  value="id" label="label"/>
                                </html:select>
                            </td>
                            <td>
                                <input type="text" id="search" name="search" class="search input input-sm" onchange="return onSelectMember();"/>
                                <input type="hidden" id="autoText"/>
                                <button class="btn btn-sm btn-primary" onclick="onSelectMember();">Search <img alt="search" src="images/search.png"/></button>
                            </td>
                            <td>
                                <b>
                                    <bean:write  name="transactionForm" property="selectedmember"/>
                                </b><br/>
                                <bean:write  name="transactionForm" property="memberaddress"/>
                                <br/>
                                <font color="brown"><bean:write  name="transactionForm" property="membercontactno"/><br/></font>
                            </td>
                            <td><button class="btn btn-sm btn-default" onclick="onreport();">Member Report</button></td>
                        </tr>
                    </table>
                </div> 

                <table class="table table-bordered" >
                    <thead>
                        <tr>
                            <td>
                                <b>Paid Amount : </b><span style="color: red"><bean:write  name="transactionForm" property="totalpaidamount"/></span>
                            </td>
                            <td>
                                <b>Prize Amount : </b><span style="color: red"><bean:write  name="transactionForm" property="drawamount"/></span>
                            </td>
                            <td>
                                <b>Total Amount : <span style="color: red"><bean:write  name="transactionForm" property="totalamount"/></span></b>
                            </td>
                            <td>
                                <b>Status : </b><span style="color: red"><bean:write  name="transactionForm" property="status"/></span>
                            </td> 
                            <logic:equal name="transactionForm" property="status" value="Settled">
                                <td>    
                                    <bean:write name="transactionForm" property="settlementcomment"/>
                                </td>
                            </logic:equal>
                            <td>
                                <a class="btn-link" data-toggle="collapse" href="#collapseOne">Member Settlement</a>
                            </td>
                            <td>
                                <a class="btn-link" data-toggle="collapse" href="#collapseTwo">Update Start Date</a>
                            </td>
                        </tr>
                    </thead>
                </table>
                <div  id="collapseOne" class="panel-collapse collapse">
                    <table class="table table-condensed" style="width: 50%">
                        <tr>
                            <td>Remarks</td>
                            <td><html:textarea property="settlementcomment" styleClass="input input-sm"/></td>
                            <td><button data-toggle="collapse" href="#collapseOne" onclick="updateSettlement()" value="Settle" class="btn-sm btn  btn-default ">Settle</button></td>

                            <td><button class="btn btn-default btn-sm" data-toggle="collapse" href="#collapseOne">Close</button></td>
                        </tr>
                    </table>
                </div>
                <div  id="collapseTwo" class="panel-collapse collapse">
                    <table class="table table-condensed" style="width: 50%">
                        <tr>
                            <td>
                                Actual Start Date
                            </td>
                            <td>         
                                <html:text onkeyup="var v = this.value;
                                           if (v.match(/^\d{2}$/) !== null) {
                                           this.value = v + '/';
                                           } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
                                           this.value = v + '/';
                                           }" alt="dd-mm-yyyy" maxlength="10" property="actualstartdate" title="dd/mm/yyyy" styleClass="input input-sm"/>
                            </td>
                            <td><button data-toggle="collapse" href="#collapseTwo" onclick="saveStartdate()" value="Update" class="btn btn-sm btn-default ">Update</button></td>
                            <td><button class="btn btn-default btn-sm" data-toggle="collapse" href="#collapseTwo">Close</button></td>
                        </tr>
                    </table>
                </div>
                <span style="color: red;"> 
                    <bean:write  name="transactionForm" property="message"/>
                </span>
                <div id="second">
                    <table id="tbl"  class="table table-condensed table-bordered" id="paymenttbl">
                        <logic:notEmpty name="transactionForm" property="lstPayment">
                            <logic:iterate id="details" name="transactionForm" property="lstPayment">
                                <tr>
                                    <td class="vnav">
                                        <div class="panel panel-primary" style="height: 200px">
                                            <div class="panel-heading">
                                                <h3 class="panel-title" style="font-size: 14px">
                                                    <span class="badge">
                                                        <bean:write name="details" property="count1"/>
                                                    </span>
                                                    <bean:write name="details" property="month1" />
                                                </h3>
                                            </div>
                                            <div class="panel-body">
                                                <font style="color: red;font-weight: bold">
                                                    <bean:write name="details" property="paymentdetails1"/>
                                                </font>
                                                <br/>
                                                <font style="color: black">
                                                    <bean:write name="details" property="prizedetails1"/>
                                                </font>
                                                <logic:equal name="details" property="status1" value="Paid">
                                                    <logic:notEqual name="details" property="prizedetails1" value="">
                                                        &nbsp;&nbsp;
                                                        <button  class="btn btn-xs btn-default" title="Delete Prize" onclick="onDeletePrize(<bean:write name="details" property="count1"/>);">
                                                            <img alt="Delete Prize" src="images/delete.png" width="15px" height="15px" title="Delete Prize"/>
                                                        </button>
                                                    </logic:notEqual>
                                                </logic:equal> 
                                            </div>
                                            <div class="panel-footer">
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status1" value="Not Paid">
                                                        <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#payments" onclick="onOpenPayment(<bean:write name="details" property="count1"/>, 'entry');">
                                                            Enter Payment
                                                        </button>
                                                    </logic:equal>
                                                </logic:notEqual>
                                                <logic:equal name="details" property="status1" value="Paid">
                                                    <button title="Edit Payment"  class="btn btn-xs btn-default" data-toggle="modal" data-target="#payments" 
                                                            onclick="onOpenPayment(<bean:write name="details" property="count1"/>, 'edit');">
                                                        Edit
                                                    </button>
                                                    <button  class="btn btn-xs btn-default" title="Delete Payment" onclick="onDeletePayment(<bean:write name="details" property="count1"/>);">
                                                        Delete
                                                    </button>
                                                    <button title="Print Receipt"  class="btn btn-xs btn-default" onclick="printReceipt(<bean:write name="details" property="count1"/>);">
                                                        Print Receipt
                                                    </button>
                                                </logic:equal>
                                                <br/>  <br/>
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status1" value="Paid">
                                                        <logic:equal name="details" property="prizedetails1" value="">
                                                            <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#prize" onclick="onOpenPrize(<bean:write name="details" property="count1"/>);">
                                                                Enter Prize
                                                            </button>
                                                        </logic:equal>
                                                    </logic:equal>
                                                </logic:notEqual>
                                            </div>
                                        </div>   
                                    </td>

                                    <!--2 -->

                                    <td class="vnav">
                                        <html:hidden name="details" property="paymentid2" />
                                        <html:hidden name="details" property="term2" />

                                        <div class="panel panel-primary" style="height: 200px">
                                            <div class="panel-heading">
                                                <h3 class="panel-title" style="font-size: 14px">
                                                    <span class="badge">
                                                        <bean:write name="details" property="count2"/>
                                                    </span>
                                                    <bean:write name="details" property="month2" />
                                                </h3>
                                            </div>
                                            <div class="panel-body">
                                                <font style="color: red;font-weight: bold">
                                                    <bean:write name="details" property="paymentdetails2"/>
                                                </font> 
                                                <br/>
                                                <font style="color: black">
                                                    <bean:write name="details" property="prizedetails2"/>
                                                </font> 
                                                <logic:equal name="details" property="status2" value="Paid">
                                                    <logic:notEqual name="details" property="prizedetails2" value="">
                                                        &nbsp;&nbsp;
                                                        <button class="btn btn-xs btn-default" title="Delete Prize" onclick="onDeletePrize(<bean:write name="details" property="count2"/>);">
                                                            <img alt="Delete Prize" src="images/delete.png" width="15px" height="15px" title="Delete Prize"/>
                                                        </button>
                                                    </logic:notEqual>
                                                </logic:equal>
                                            </div>
                                            <div class="panel-footer">
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status2" value="Not Paid">
                                                        <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#payments" onclick="onOpenPayment(<bean:write name="details" property="count2"/>, 'entry');">
                                                            Enter Payment
                                                        </button>
                                                    </logic:equal>
                                                </logic:notEqual>
                                                <logic:equal name="details" property="status2" value="Paid">
                                                    <button title="Edit Payment"  class="btn btn-xs btn-default" data-toggle="modal" data-target="#payments" 
                                                            onclick="onOpenPayment(<bean:write name="details" property="count2"/>, 'edit');">Edit
                                                    </button>
                                                    <button  class="btn btn-xs btn-default" title="Delete Payment" onclick="onDeletePayment(<bean:write name="details" property="count2"/>);">
                                                        Delete
                                                    </button>
                                                    <button title="Print Receipt"  class="btn btn-xs btn-default" onclick="printReceipt(<bean:write name="details" property="count2"/>);">
                                                        Print Receipt
                                                    </button>
                                                </logic:equal>
                                                <br/>  <br/>
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status2" value="Paid">
                                                        <logic:equal name="details" property="prizedetails2" value="">
                                                            <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#prize" onclick="onOpenPrize(<bean:write name="details" property="count2"/>);">
                                                                Enter Prize
                                                            </button>
                                                        </logic:equal>
                                                    </logic:equal>
                                                </logic:notEqual>
                                            </div>
                                        </div>
                                    </td>
                                    <!-- 3 -->
                                    <td class="vnav">
                                        <html:hidden name="details" property="paymentid3" />
                                        <html:hidden name="details" property="term3" />

                                        <div class="panel panel-primary" style="height: 200px">
                                            <div class="panel-heading">
                                                <h3 class="panel-title" style="font-size: 14px">
                                                    <span class="badge">
                                                        <bean:write name="details" property="count3"/>
                                                    </span>
                                                    <bean:write name="details" property="month3" />
                                                </h3>
                                            </div>
                                            <div class="panel-body">
                                                <font style="color: red;font-weight: bold">
                                                    <bean:write name="details" property="paymentdetails3"/>
                                                </font> 
                                                <br/>
                                                <span style="color: black;"> 
                                                    <bean:write name="details" property="prizedetails3"/>
                                                </span>
                                                <logic:equal name="details" property="status3" value="Paid">
                                                    <logic:notEqual name="details" property="prizedetails3" value="">
                                                        &nbsp;&nbsp;
                                                        <button class="btn btn-xs btn-default" title="Delete Prize" onclick="onDeletePrize(<bean:write name="details" property="count3"/>);">
                                                            <img alt="Delete Prize" src="images/delete.png" width="15px" height="15px" title="Delete Prize"/>
                                                        </button>
                                                    </logic:notEqual>
                                                </logic:equal>
                                            </div>
                                            <div class="panel-footer">
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status3" value="Not Paid">
                                                        <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#payments" onclick="onOpenPayment(<bean:write name="details" property="count3"/>, 'entry');">
                                                            Enter Payment
                                                        </button>
                                                    </logic:equal>
                                                </logic:notEqual>
                                                <logic:equal name="details" property="status3" value="Paid">
                                                    <button title="Edit Payment"  class="btn btn-xs btn-default" data-toggle="modal" data-target="#payments" 
                                                            onclick="onOpenPayment(<bean:write name="details" property="count3"/>, 'edit');">
                                                        Edit
                                                    </button>
                                                    <button  class="btn btn-xs btn-default" title="Delete Payment" onclick="onDeletePayment(<bean:write name="details" property="count3"/>);">
                                                        Delete
                                                    </button>
                                                    <button title="Print Receipt"  class="btn btn-xs btn-default" onclick="printReceipt(<bean:write name="details" property="count3"/>);">
                                                        Print Receipt
                                                    </button>
                                                </logic:equal>
                                                <br/><br/>
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status3" value="Paid">
                                                        <logic:equal name="details" property="prizedetails3" value="">
                                                            <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#prize" onclick="onOpenPrize(<bean:write name="details" property="count3"/>);">
                                                                Enter Prize
                                                            </button>
                                                        </logic:equal>
                                                    </logic:equal>
                                                </logic:notEqual>
                                            </div>
                                        </div>
                                    </td>
                                    <!-- 4 -->
                                    <td class="vnav">
                                        <html:hidden name="details" property="paymentid4" />
                                        <html:hidden name="details" property="term4" />

                                        <div class="panel panel-primary" style="height: 200px">
                                            <div class="panel-heading">
                                                <h3 class="panel-title" style="font-size: 14px">
                                                    <span class="badge">
                                                        <bean:write name="details" property="count4"/>
                                                    </span>
                                                    <bean:write name="details" property="month4" />
                                                </h3>
                                            </div>
                                            <div class="panel-body">
                                                <font style="color:red;font-weight: bold">
                                                    <bean:write name="details" property="paymentdetails4"/>
                                                </font> 
                                                <br/>
                                                <span style="color:black">
                                                    <bean:write name="details" property="prizedetails4"/>
                                                </span>
                                                <logic:equal name="details" property="status4" value="Paid">
                                                    <logic:notEqual name="details" property="prizedetails4" value="">
                                                        &nbsp;&nbsp;
                                                        <button  class="btn btn-xs btn-default" title="Delete Prize" onclick="onDeletePrize(<bean:write name="details" property="count4"/>);">
                                                            <img alt="Delete Prize" src="images/delete.png" width="15px" height="15px" title="Delete Prize"/>
                                                        </button>
                                                    </logic:notEqual>
                                                </logic:equal>
                                            </div>
                                            <div class="panel-footer">
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status4" value="Not Paid">
                                                        <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#payments" onclick="onOpenPayment(<bean:write name="details" property="count4"/>, 'entry');">
                                                            Enter Payment
                                                        </button>
                                                    </logic:equal>
                                                </logic:notEqual>
                                                <logic:equal name="details" property="status4" value="Paid">
                                                    <button title="Edit Payment"  class="btn btn-xs btn-default" data-toggle="modal" data-target="#payments" 
                                                            onclick="onOpenPayment(<bean:write name="details" property="count4"/>, 'edit');">
                                                        Edit
                                                    </button>
                                                    <button  class="btn btn-xs btn-default" title="Delete Payment" onclick="onDeletePayment(<bean:write name="details" property="count4"/>);">
                                                        Delete
                                                    </button>
                                                    <button title="Print Receipt"  class="btn btn-xs btn-default" onclick="printReceipt(<bean:write name="details" property="count4"/>);">
                                                        Print Receipt
                                                    </button>
                                                </logic:equal>
                                                <br/><br/>
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status4" value="Paid">
                                                        <logic:equal name="details" property="prizedetails4" value="">
                                                            <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#prize" onclick="onOpenPrize(<bean:write name="details" property="count4"/>);">
                                                                Enter Prize
                                                            </button>
                                                        </logic:equal>
                                                    </logic:equal>
                                                </logic:notEqual>
                                            </div>
                                        </div>
                                    </td>
                                    <!-- 5 -->
                                    <td class="vnav">
                                        <html:hidden name="details" property="paymentid5" />
                                        <html:hidden name="details" property="term5" />

                                        <div class="panel panel-primary" style="height: 200px">
                                            <div class="panel-heading">
                                                <h3 class="panel-title" style="font-size: 14px">
                                                    <span class="badge">
                                                        <bean:write name="details" property="count5"/>
                                                    </span>
                                                    <bean:write name="details" property="month5" />
                                                </h3>
                                            </div>
                                            <div class="panel-body">
                                                <font style="color: red;font-weight: bold">
                                                    <bean:write name="details" property="paymentdetails5"/>
                                                </font> 
                                                <br/>
                                                <span style="color: black;">
                                                    <bean:write name="details" property="prizedetails5"/>
                                                </span>
                                                <logic:equal name="details" property="status5" value="Paid">
                                                    <logic:notEqual name="details" property="prizedetails5" value="">
                                                        &nbsp;&nbsp;
                                                        <button  class="btn btn-xs btn-default" title="Delete Prize" onclick="onDeletePrize(<bean:write name="details" property="count5"/>);">
                                                            <img alt="Delete Prize" src="images/delete.png" width="15px" height="15px" title="Delete Prize"/>
                                                        </button>
                                                    </logic:notEqual>
                                                </logic:equal>
                                            </div>
                                            <div class="panel-footer">
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status5" value="Not Paid">
                                                        <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#payments" onclick="onOpenPayment(<bean:write name="details" property="count5"/>, 'entry');">
                                                            Enter Payment
                                                        </button>
                                                    </logic:equal>
                                                </logic:notEqual>
                                                <logic:equal name="details" property="status5" value="Paid">
                                                    <button title="Edit Payment"  class="btn btn-xs btn-default" data-toggle="modal" data-target="#payments" 
                                                            onclick="onOpenPayment(<bean:write name="details" property="count5"/>, 'edit');">
                                                        Edit
                                                    </button>
                                                    <button  class="btn btn-xs btn-default" title="Delete Payment" onclick="onDeletePayment(<bean:write name="details" property="count5"/>);">
                                                        Delete
                                                    </button>
                                                    <button title="Print Receipt"  class="btn btn-xs btn-default" onclick="printReceipt(<bean:write name="details" property="count5"/>);">
                                                        Print Receipt
                                                    </button>
                                                </logic:equal>
                                                <br/><br/>
                                                <logic:notEqual name="transactionForm" property="status" value="Settled">
                                                    <logic:equal name="details" property="status5" value="Paid">
                                                        <logic:equal name="details" property="prizedetails5" value="">
                                                            <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#prize" onclick="onOpenPrize(<bean:write name="details" property="count5"/>);">
                                                                Enter Prize
                                                            </button>
                                                        </logic:equal>
                                                    </logic:equal>
                                                </logic:notEqual>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                    </table>
                </div>
                <div class="modal fade" id="payments" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Payment Entry</h4>
                            </div>
                            <div class="modal-body">
                                <table id="pay" class="table table-striped">
                                    <tbody>
                                        <tr>
                                            <td>Date<br/><span class="text-muted">(DD/MM/YYYY)</span></td>
                                            <td>         
                                                <html:text onkeyup="var v = this.value;
                                                           if (v.match(/^\d{2}$/) !== null) {
                                                           this.value = v + '/';
                                                           } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
                                                           this.value = v + '/';
                                                           }" maxlength="10" alt="dd-mm-yyyy" property="date" styleId="date"  title="dd/mm/yyyy" styleClass="input input-sm"/>
                                            </td>

                                            <td>Amount</td>
                                            <td>
                                                <html:select  property="amount" styleClass="input input-sm" disabled="false">
                                                    <html:optionsCollection property="amountlst"  value="id" label="label" />

                                                </html:select>   

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Payment mode</td> 
                                            <td>
                                                <html:radio property="paymentmode" value="cash"/> Cash

                                                <html:radio property="paymentmode" value="cheque"/> Cheque/NEFT
                                            </td>
                                            <td></td> <td></td>
                                        </tr>
                                        <tr>
                                            <td>Remarks</td>
                                            <td><html:textarea property="remarks" styleClass="input input-sm"/></td>
                                            <td></td> <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <label id="note" >Note : Amount can be changed only for last payment.</label>
                                <html:button styleId="idsave" property="method" onclick="onSavePayment(this,'entry')" value="Save" styleClass="btn  btn-primary"/>
                                <html:button styleId="idupdate" property="method" onclick="onSavePayment(this,'edit')" value="Update" styleClass="btn  btn-primary"/>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="prize" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Prize Entry</h4>
                            </div>
                            <div class="modal-body">
                                <table class="table table-striped">
                                    <tbody>
                                        <tr>
                                            <td>
                                                Term(Paid)
                                            </td>
                                            <td>
                                                <label id="termlbl" styleClass="input input-sm"/>                     
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Draw Date<br/><span class="text-muted">(DD/MM/YYYY)</span></td>
                                            <td>         
                                                <html:text onkeyup="var v = this.value;
                                                           if (v.match(/^\d{2}$/) !== null) {
                                                           this.value = v + '/';
                                                           } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
                                                           this.value = v + '/';
                                                           }" maxlength="10" property="drawdate" styleId="drawdate"  styleClass="input input-sm"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Prize
                                            </td>
                                            <td><html:select  property="drawtypeid" styleClass="input input-sm" onchange="fillpostions()">

                                                    <html:option value="">--Select--</html:option>

                                                    <html:optionsCollection property="drawtypes"  value="id" label="label" />

                                                </html:select>                      
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Prize Amount 
                                            </td>
                                            <td>
                                                <html:text property="prizeamount" title="enter prize amount" styleClass="input input-sm"/>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <html:button styleId="id" property="method" onclick="onPrizeEntry()" value="Save" styleClass="btn btn-primary"/>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </html:form>
    </body>
</html:html>