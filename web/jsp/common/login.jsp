<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <title>Login</title>
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />

        <script type="text/javascript" src="js/bootstrap.min.js"></script>

        <link href="css/signin.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <script type="text/javascript">
            $("#code").keyup(function (event) {
                if (event.keyCode === 13) {
                    $("#login").click();
                }
            });

        </script>
        <style>
            body { 
                background: url(images/banner_narrow.jpg) no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <br/><br/>
            <html:form action="/logins" styleClass="form-signin">
                <h2 class="form-signin-heading">Sign in</h2>
                <input type="text" class="form-control" placeholder="Username" id="username" name="userName" required autofocus>
                <input type="password" class="form-control" required id="code" name="password" placeholder="Password">
                <div><button class="btn btn-lg btn-primary btn-block" type="submit" >LogIn</button></div>
                <br/>
                <logic:notEmpty property="message" name="loginForm">
                    <div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <b><bean:write name="loginForm" property="message" /></b>
                    </div>
                </logic:notEmpty>
                <div class="alert alert-warning alert-dismissible text-center" role="button">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>Warning!</strong> Provide the Internet connectivity while logging in at least once in a day. So that your data will be stored in safe place.
                </div>
            </html:form>
            <br/><br/>
            <div class="navbar-fixed-bottom">
                <div class="row">
                    <!--   <p class="text-center" style="float: left;padding-left: 20px">Copyright @ 2014-17</p> -->

                    <p class="text-center" style="float: right;padding-right: 20px">Version 3.0</p>
                </div>
            </div>
        </div>
    </body>
</html>