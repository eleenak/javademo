<%-- 
    Document   : about
    Created on : Sep 3, 2018, 2:37:18 PM
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
        <h1>About Us</h1>
        <ul>
            <li> <a href="${pageContext.request.contextPath}/Home">Home</a></li>
            <li> <a href="${pageContext.request.contextPath}/About">About</a></li>
            <li> <a href="${pageContext.request.contextPath}/Services">Services</a></li>
            <li> <a href="${pageContext.request.contextPath}/Contact">Contact</a></li>
        </ul>
    </body>
</html>
