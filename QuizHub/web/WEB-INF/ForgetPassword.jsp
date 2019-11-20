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
            Your E-mail / ID :<input type="text" name="who" autocomplete="off"><br>
            <input type="text" name="code" placeholder="code" autocomplete="off"> ${code}<br>
        <input type="submit"><br>
        </form>
        <a href="Login">Back</a>
    </body>
</html>
