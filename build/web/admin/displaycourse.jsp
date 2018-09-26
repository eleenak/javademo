<%-- 
    Document   : addsourse
    Created on : Sep 4, 2018, 2:25:30 PM
    Author     : Eleena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

        <!-- DataTables CSS -->
        <link href="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">



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
                        <h1 class="page-header">Course Management</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Display Course Information
                            </div>
                            <div class="panel-body">
                                <div class="row">

                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                All available courses
                                                <span style="color:red;">${message}</span>
                                            </div>
                                            <!-- /.panel-heading -->
                                            <div class="panel-body">
                                                <table width="100%" class="table table-striped table-bordered table-hover" id="course_table">
                                                    <thead>
                                                        <tr>
                                                            <th>ID</th>
                                                            <th>Title</th>
                                                            <th>Price</th>
                                                            <th>Duration</th>
                                                            <th>Edit</th>
                                                            <th>Delete</th>
                                                        </tr>
                                                    </thead>
                                                    <tfoot>
                                                        <tr>
                                                            <th>ID</th>
                                                            <th>Title</th>
                                                            <th>Price</th>
                                                            <th>Duration</th>
                                                            <th>Edit</th>
                                                            <th>Delete</th>
                                                        </tr>
                                                    </tfoot>
                                                    <tbody>
                                                        <c:forEach items="${courselist}" var="course">
                                                            <tr>
                                                                <td>${course.id}</td>
                                                                <td>${course.title}</td>
                                                                <td>${course.price}</td>
                                                                <td>${course.duration}</td>
                                                                <td><a href="${pageContext.request.contextPath}/Admin/Course/Edit?id=${course.id}">Edit</a></td>
                                                                <td><a class="btn btn-danger" href="#"
                                                                        data-href="${pageContext.request.contextPath}/Admin/Course/Delete?id=${course.id}"
                                                                        data-toggle='modal'
                                                                        data-target="#confirm-delete"><i class="fa fa-trash-o"></i>Delete</a></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>

                                                </table>
                                                <!-- /.table-responsive -->

                                            </div>
                                            <!-- /.panel-body -->
                                        </div>
                                        <!-- /.panel -->
                                    </div>

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
        
        <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aira-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        Confirm Course Delete
                    </div>
                    <div class="modal-body">
                        Do you really want to delete this record permanently?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-danger btn-ok">Delete</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

        <!-- DataTables JavaScript -->
        <script src="${pageContext.request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>

        <script>
            $(document).ready(function () {
                $('#course_table').DataTable({
                    responsive: true
                });
            });
        </script>
        <script>
            $('#confirm-delete').on('show.bs.modal',function(e){
                $(this).find('.btn-ok').attr('href',$(e.relatedTarget).data('href'));
            });
        </script>


    </body>

</html>

