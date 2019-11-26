<%-- 
    Document   : AuthenticationByEmail
    Created on : Nov 26, 2019, 10:02:11 PM
    Author     : Top
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${authenmsg}
        <form action="AuthenticationByEmail" method="post">
            <input type="hidden" name="page" value="SENDCODE">
            EMAIL:<input type="text" name="email"><br>
            CODE:<input type="text" name="code">${gencode}<br>
            <input type="submit">
        </form>
        <hr>
        <br>
        <a href="Login">BACK</a>
        
    </body>
</html>
