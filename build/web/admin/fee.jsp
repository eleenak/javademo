<%-- 
    Document   : fee
    Created on : Sep 4, 2018, 2:25:30 PM
    Author     : Eleena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <h1 class="page-header">Fee Management</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Make payment
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <form role="form" action="${pageContext.request.contextPath}/Admin/Fee/Pay" method="post">
                                            <div class="form-group">
                                                <label>Student on Course</label>
                                                <select class="form-control" name="student_course" placeholder="Select student on course">
                                                    <c:forEach items="${studentcourselist}" var="sc">
                                                        <option value="${sc.id}">${sc.name}, ${sc.title}</option>
                                                    </c:forEach>
                                                </select>
                                                
                                            </div>
                                            <div class="form-group">
                                                <label>Amount</label>
                                                <input class="form-control" type="text" name="amount" placeholder="Enter amount" required>                                                
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
<div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Student Course Enrollment Information
                            </div>
                            <div class="panel-body">

                                <table width="100%" class="table table-striped table-bordered table-hover" id="sc_table">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>    
                                            <th>Address</th>
                                            <th>Phone</th>
                                            <th>Title</th>
                                            <th>Duration</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>                                                                                                             <th>Address</th>
                                            <th>Phone</th>
                                            <th>Title</th>
                                            <th>Duration</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${sclist}" var="sc">
                                            <tr>
                                                <td>${sc.id}</td>
                                                <td>${sc.name}</td>
                                                <td>${sc.address}</td>
                                                <td>${sc.phone}</td>
                                                <td>${sc.title}</td>
                                                <td>${sc.duration}</td>
                                                <td><a href="${pageContext.request.contextPath}/Admin/Fee/Pay/Edit?id=${sc.id}">Edit</a></td>
                                                <td><a class="btn btn-danger" href="#"
                                                       data-href="${pageContext.request.contextPath}/Admin/Fee/Pay/Delete?id=${sc.id}"
                                                       data-toggle='modal'
                                                       data-target="#confirm-delete"><i class="fa fa-trash-o"></i>Delete</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                                <!-- /.table-responsive -->


                                <!-- /.row (nested) -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
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

