<%-- 
    Document   : index
    Created on : Sep 2, 2018, 2:22:37 PM
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
        <h1>Welcome to web demo app..</h1>

        <ul>
            <!--uses expression language $ { variable } -->
            <li> <a href="${pageContext.request.contextPath}/Home">Home</a></li>
            <li> <a href="${pageContext.request.contextPath}/About">About</a></li>
            <li> <a href="${pageContext.request.contextPath}/Services">Services</a></li>
            <li> <a href="${pageContext.request.contextPath}/Contact">Contact</a></li>
            <li> <a href="${pageContext.request.contextPath}/Login">Login for Admin</a></li>
            
        </ul>


    </body>
</html>
