<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <title><%= session.getAttribute("brand")%></title>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />

        <link href="css/navbar-fixed-top.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head> 
    <body> 
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
                        <li class="active"><a href="gohome.do?method=displayHome">Home</a> <span class="sr-only"></span></li>
                        <li><a href="transaction.do?method=loadPage">Payment</a></li>
                        <li><a href="addmember.do?method=displayGroups">Members</a></li>
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
    </body>
</html>