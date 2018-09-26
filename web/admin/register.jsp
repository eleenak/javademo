<%-- 
    Document   : register
    Created on : Sep 4, 2018, 2:25:30 PM
    Author     : Eleena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Bootstrap Admin Theme</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">



        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div id="wrapper">

            <!--navigation here -->
            <%@include file="header.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">User Registration</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                New User Registration
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <form role="form" action="${pageContext.request.contextPath}/Admin/User/Register" method="post" enctype="multipart/form-data">
                                            <div class="form-group">
                                                <label>Full Name</label>
                                                <input class="form-control" name="name" type="text" placeholder="Enter Name" required>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input class="form-control" name="email" placeholder="Enter email" type="email" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Password</label>
                                                <input class="form-control" name="password" placeholder="Enter password" type="password" required>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label>Confirm Password</label>
                                                <input class="form-control" name="cpassword" placeholder="Confirm password" type="password" required>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label>user Role</label>
                                                <select class="form-control" name="role">
                                                    <option value="admin">Admin</option>
                                                    <option value="user">User</option>  
                                                </select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label>User Image</label>
                                                <input class="form-control " name="image" type="file" accept="image/*" placeholder="select image" required>
                                            </div>
                                            
                                           
                                            
                                            <button type="submit" class="btn btn-default">Submit Button</button>
                                            <button type="reset" class="btn btn-default">Reset Button</button>
                                        </form>
                                    </div>
                                    <!-- /.col-lg-6 (nested) -->
                                    
                                    
                                </div>
                                <!-- /.row (nested) -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

    </body>

</html>

