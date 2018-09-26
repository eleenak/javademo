<%-- 
    Document   : editcourse
    Created on : Sep 4, 2018, 2:25:30 PM
    Author     : Eleena
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <h1 class="page-header">Course Management</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Update Course Information
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-9">
                                        <form role="form" action="${pageContext.request.contextPath}/Admin/Course/Update" method="post">
                                            
                                            <div class="form-group">
                                                <label for="inputId">Id</label>
                                                <input id="inputId" type="text" class="form-control" name="c_id" value="${coursedata.id}" readonly required >
                                            </div>
                                            <div class="form-group">
                                                <label for="inputTitle">Title</label>
                                                <input id="inputTitle" type="text" class="form-control" name="c_title" value="${coursedata.title}"  required >
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPrice">Price</label>
                                                <input id="inputPrice" type="number" class="form-control" name="c_price" value="${coursedata.price}"  required >
                                            </div>
                                                                                                                                                                                                                                                                                                             
                                            <div class="form-group">
                                                <label for="inputDuration">Duration in month</label>
                                                <select id="inputDuration" class="form-control" name="c_duration" >
                                                    <option value="one_month"<c:if test="${cousedata.duration.equals('one_month')}">selected</c:if>> 1 </option>
                                                    <option value="two_months"<c:if test="${cousedata.duration.equals('two_months')}">selected</c:if>> 2 </option>
                                                    <option value="three_months"<c:if test="${cousedata.duration.equals('three_months')}">selected</c:if>> 3 </option>
                                                    <option value="four_months"<c:if test="${cousedata.duration.equals('four_months')}">selected</c:if>> 4 </option>
                                                    <option value="five_months"<c:if test="${cousedata.duration.equals('five_months')}">selected</c:if>> 5 </option>
                                                    <option value="six_months"<c:if test="${cousedata.duration.equals('six_months')}">selected</c:if>> 6 </option>
                                                    
                                                </select>
                                            </div>
                                            
                                            <button type="submit" class="btn btn-success">Submit </button>
                                            <button type="reset" class="btn btn-warning">Reset </button>
                                        </form>
                                        <span style="color:red">${message}</span>
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

