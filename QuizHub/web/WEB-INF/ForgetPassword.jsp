<%-- 
    Document   : ForgetPassword
    Created on : Nov 20, 2019, 5:01:22 PM
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
        ${msg}${codemsg}
        <form action="ForgetPassword" method="post">
        Your E-mail / ID :<input type="text" name="who"><br>
        <input type="text" name="code" placeholder="code"> ${code}<br>
        <input type="submit"><br>
        </form>
        <a href="Login">Back</a>
    </body>
</html>
