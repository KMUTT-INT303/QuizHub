<%-- 
    Document   : ActiveByCode
    Created on : Nov 27, 2019, 12:35:23 AM
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
        <h1>Active Page</h1><hr>
        ${msg}
        <form action="AuthenticationByEmail" method="post">
            <input type="hidden" name="page" value="ACTIVE">
            CODE:<input type="text" name="MailCode"><br>
            <input type="submit">
        </form>
    </body>
</html>
