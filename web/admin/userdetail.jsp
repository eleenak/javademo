<%-- 
    Document   : userdetail
    Created on : Sep 23, 2018, 2:36:04 PM
    Author     : Eleena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello user ${userinfo.name} ${userinfo.id}</h1>
        <img alt="${userinfo.name}" src="${pageContext.request.contextPath}/user_image/${userinfo.image}" width="70px" height="100px"/>
    </body>
</html>
