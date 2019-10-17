<%-- 
    Document   : login
    Created on : Oct 17, 2019, 10:57:34 AM
    Author     : tsch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <%@ include file="Layouts/Headers.jsp" %> 

    <body>
        <h1>Login</h1>
        <form action="Login" method="post">
            Username :<input type="number" name="username"><br>
            Password :<input type="text" name="password"><br>
            <input type="submit"><br>
            ${msg}
        </form>
    </body>
    
</html>
