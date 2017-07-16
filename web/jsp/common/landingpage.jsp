<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <title>
            <%= session.getAttribute("brand")%> | Home
        </title>

        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-1.12.4.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

        <style>
            body { 
                background: url(images/confectionary.png) repeat scroll left bottom #dbd9d3; 
            }
        </style>
    </head>

    <body>
        <div class="navbar navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-collapse collapse" style="float: right">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="logout.do?method=logout">Logout</a></li> 
                        <li class="dropdown" >
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Settings <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="changepassword.do?method=changePassword">Change Password</a></li>
                                <li><a href="usercreation.do?method=displayUsers">Create Users</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Wrap all page content here -->
        <div id="wrap">
            <!-- Begin page content -->
            <div class="container" >
                <center>
                    <div class="page-header">
                        <h3 class="lead"><b>Welcome to  <%= session.getAttribute("brand")%></b></h3>
                        <p ></p>

                    </div>
                </center>
                <br/>  <br/>  <br/>
                <br/><br/>  
                <div class="row" style="background-color: transparent">

                    <center>
                        <a href="gohome.do?method=displayHome" >
                            <button type="button" class="btn btn-lg btn-primary" style="width: 300px;height: 200px">
                                <p>Scheme Management</p>
                                <p style="font-size: 13px">Group | Member | Payment | Report</p>
                            </button>
                        </a>
                        <a href="gohome.do?method=displayOrderHome" >
                            <button type="button" class="btn btn-lg btn-warning" style="width: 300px;height: 200px">
                                <p>Stock Management</p>
                                <p style="font-size: 13px">Voucher | Memo | GS11 | GS12 | Sales </p>
                            </button>
                        </a>
                    </center>
                </div>
            </div>
        </div>
        <jsp:include page="/jsp/common/footer.jsp" />
    </body>
</html>