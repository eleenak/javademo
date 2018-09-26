<%-- 
    Document   : services
    Created on : Sep 3, 2018, 2:37:32 PM
    Author     : Eleena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <body>
        <h1>Services</h1>
        <ul>
            <li> <a href="${pageContext.request.contextPath}/Home">Home</a></li>
            <li> <a href="${pageContext.request.contextPath}/About">About</a></li>
            <li> <a href="${pageContext.request.contextPath}/Services">Services</a></li>
            <li> <a href="${pageContext.request.contextPath}/Contact">Contact</a></li>
        </ul>
        <br>
        <strong>Course Management:</strong>
        <hr>
        <br>
        <a href="${pageContext.request.contextPath}/Admin/Course/Add"> Add new course</a>
        <br>
        <a href="${pageContext.request.contextPath}/Admin/Course/Display"> Display course</a>
        <hr>
        <br>

        <strong>Student Management:</strong>
        <hr>
        <br>
        <a href="${pageContext.request.contextPath}/Admin/Student/Add"> Student Information</a>


    </body>
</html>
