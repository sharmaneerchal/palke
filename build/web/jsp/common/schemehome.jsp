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
            <%= session.getAttribute("brand")%> | Scheme Management
        </title>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <script src="js/jquery-1.10.2.js"></script>
        <style>
            body { 
                background: url(images/ps_neutral.png) repeat scroll left bottom #dbd9d3; 
            }
            .btn{
                width: 200px;
                height: 200px
            }
        </style>
    </head>

    <body>
        <jsp:include page="/jsp/common/header.jsp" />
        <!-- Wrap all page content here -->
        <div id="wrap">
            <!-- Begin page content -->
            <div class="container">
                <center>
                    <div class="page-header">
                        <h3>Scheme Management</h3>
                        <p class="lead"></p>
                        <p></p>
                    </div>
                </center>
                <br/>
                <div class="panel-body" style="background: transparent">
                    <center>
                        <a href="transaction.do?method=loadPage" >
                            <button type="button" class="btn btn-lg btn-primary">
                                <p>Scheme Payment <br/> &amp; <br/>Member Accounts</p>
                                <p style="font-size: 13px"></p>
                            </button>
                        </a>

                        <a href="addmember.do?method=displayGroups">
                            <button type="button" class="btn btn-lg btn-warning">
                                <p>Scheme Members</p>
                                <p style="font-size: 13px"></p>
                            </button>
                        </a>
                        <a href="creategroup.do?method=displayGroups">
                            <button type="button" class="btn btn-lg btn-danger">
                                <p>Scheme Groups</p>
                                <p style="font-size: 13px"></p>
                            </button>
                        </a>

                        <a href="dataentry.do?method=displayData">
                            <button type="button" class="btn btn-lg btn-success">
                                <p>Data Entry</p>
                                <p style="font-size: 13px"></p>
                            </button>
                        </a>

                        <!--    <a href="transactionold.do?method=loadPage" >
                                <button type="button" class="btn btn-lg btn-default">
                                    <p>sdsd</p>
                                    <p style="font-size: 13px"></p>
                                </button>
                            </a>-->
                    </center>
                </div>


                <!--
                                <div id="accordion" class="panel-group">
                
                                    <div class="panel panel-default">
                
                                        <div class="panel-heading">
                
                                            <h4 class="panel-title">
                
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">1. What is HTML?</a>
                
                                            </h4>
                
                                        </div>
                
                                        <div id="collapseOne" class="panel-collapse collapse">
                
                                            <div class="panel-body">
                
                                                <p>HTML stands for HyperText Markup Language. HTML is the main markup language for describing the structure of Web pages. <a href="http://www.tutorialrepublic.com/html-tutorial/" target="_blank">Learn more.</a></p>
                
                                            </div>
                
                                        </div>
                
                                    </div>
                
                                    <div class="panel panel-default">
                
                                        <div class="panel-heading">
                
                                            <h4 class="panel-title">
                
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">2. What is Twitter Bootstrap?</a>
                
                                            </h4>
                
                                        </div>
                
                                        <div id="collapseTwo" class="panel-collapse collapse in">
                
                                            <div class="panel-body">
                
                                                <p>Twitter Bootstrap is a powerful front-end framework for faster and easier web development. It is a collection of CSS and HTML conventions. <a href="http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/" target="_blank">Learn more.</a></p>
                
                                            </div>
                
                                        </div>
                
                                    </div>
                
                                    <div class="panel panel-default">
                
                                        <div class="panel-heading">
                
                                            <h4 class="panel-title">
                
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">3. What is CSS?</a>
                
                                            </h4>
                
                                        </div>
                
                                        <div id="collapseThree" class="panel-collapse collapse">
                
                                            <div class="panel-body">
                
                                                <p>CSS stands for Cascading Style Sheet. CSS allows you to specify various style properties for a given HTML element such as colors, backgrounds, fonts etc. <a href="http://www.tutorialrepublic.com/css-tutorial/" target="_blank">Learn more.</a></p>
                
                                            </div>
                
                                        </div>
                
                                    </div>
                
                                </div>
                
                
                
                <!-- Button trigger modal 
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    Launch demo modal
                </button>

                <!-- Modal 
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>

                -->


            </div>
        </div>
        <jsp:include page="/jsp/common/footer.jsp" />
    </body>
</html>