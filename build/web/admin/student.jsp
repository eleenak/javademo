<%-- 
    Document   : addsourse
    Created on : Sep 4, 2018, 2:25:30 PM
    Author     : Eleena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${student.id gt 0}">
    <c:set var="edit" value="true"/>
</c:if>


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
                        <h1 class="page-header">Student Management</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- add student-->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">

                                <c:choose>
                                    <c:when test="${edit.equals('true')}">Edit</c:when>
                                    <c:otherwise>New</c:otherwise>
                                </c:choose>

                                Student Information <span class="text text-danger">${message}</span>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-9">
                                        <form role="form" 
                                              action="${pageContext.request.contextPath}/Admin/Student/Add"
                                              method="post">

                                            <c:if test="${edit.equals('true')}">
                                                <div class="form-group">
                                                    <label for="inputId">ID</label>
                                                    <input id="inputId" type="text" class="form-control" name="sid" value="${student.id}" readonly="" required >
                                                </div>
                                            </c:if>

                                            <div class="form-group">
                                                <label for="inputName">Name</label>
                                                <input id="inputName" type="text" class="form-control" name="sname" value="${student.name}" placeholder="Enter name" required >
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPhone">Phone</label>
                                                <input id="inputPhone" type="text" class="form-control" name="sphone" value="${student.phone}" placeholder="Enter phone" required >
                                            </div>


                                            <div class="form-group">
                                                <label for="inputAddress">Address</label>
                                                <input id="inputAddress" type="text" class="form-control" name="saddress" value="${student.address}" placeholder="Enter address" required >
                                            </div>

                                            <div class="form-group">
                                                <label for="inputGender">Gender</label>
                                                <div class="form-control">
                                                    <input id="inputGender" name="sgender" value="male" type="radio"  name="sgender" required <c:if test="${student.gender.equals('male')}">checked</c:if> > &nbsp;Male &nbsp;&nbsp;
                                                    <input id="inputGender" name="sgender" value="female" type="radio"  name="sgender" required <c:if test="${student.gender.equals('female')}">checked</c:if> >&nbsp;Female                                               
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="inputInterest">Interest</label>
                                                    <div class="form-control">
                                                        <input id="inputInterest" name="sinterest" value="Bloging" type="checkbox"  name="sgender" <c:if test="${student.interest.contains('Bloging')}">checked</c:if> > &nbsp;Bloging &nbsp;&nbsp;
                                                    <input id="inputInterest" name="sinterest" value="Coding" type="checkbox"  name="sgender" <c:if test="${student.interest.contains('Coding')}">checked</c:if> >&nbsp;Coding&nbsp;&nbsp; 
                                                    <input id="inputInterest" name="sinterest" value="Sports" type="checkbox"  name="sgender" <c:if test="${student.interest.contains('Sports')}">checked</c:if> >&nbsp;Sports 
                                                    </div>
                                                </div>



                                                <button type="submit" class="btn btn-success">Submit </button>
                                                <button type="reset" class="btn btn-warning">Reset </button>
                                            </form>
                                            <span style="color:red">${status}</span>
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
                <!-- /add student-->

                <!-- display student-->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Display Student Information
                            </div>
                            <div class="panel-body">
                                <div class="row">

                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                Student Records
                                                <span style="color:red;">${message}</span>
                                            </div>
                                            <!-- /.panel-heading -->
                                            <div class="panel-body">
                                                <table width="100%" class="table table-striped table-bordered table-hover" id="student_table">
                                                    <thead>
                                                        <tr>
                                                            <th>ID</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Address</th>
                                                            <th>Gender</th>
                                                            <th>Interest</th>
                                                            <th>Edit</th>
                                                            <th>Delete</th>
                                                        </tr>
                                                    </thead>
                                                    <tfoot>
                                                        <tr>
                                                            <th>ID</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Address</th>
                                                            <th>Gender</th>
                                                            <th>Interest</th>
                                                            <th>Edit</th>
                                                            <th>Delete</th>
                                                        </tr>
                                                    </tfoot>
                                                    <tbody>
                                                        <c:forEach items="${studentlist}" var="student">
                                                            <tr>
                                                                <td>${student.id}</td>
                                                                <td>${student.name}</td>
                                                                <td>${student.phone}</td>
                                                                <td>${student.address}</td>
                                                                <td>${student.gender}</td>
                                                                <td>${student.interest}</td>
                                                                <td><a href="${pageContext.request.contextPath}/Admin/Student/Edit?id=${student.id}">Edit</a></td>
                                                                <td><a class="btn btn-danger" href="#"
                                                                       data-href="${pageContext.request.contextPath}/Admin/Student/Delete?id=${student.id}"
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
                </div>
                <!-- /display student-->                                                        
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->
        <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aira-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        Confirm Student Delete
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
        <script>
            $(document).ready(function () {
                $('#student_table').DataTable({
                    responsive: true
                });
            });
        </script>
        <script>
            $('#confirm-delete').on('show.bs.modal', function (e) {
                $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
            });
        </script>

    </body>

</html>

