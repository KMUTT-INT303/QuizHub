<%-- 
    Document   : ManageAccount
    Created on : Nov 5, 2019, 6:08:51 PM
    Author     : Top
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Account</title>
    </head>
    <body>
        ${msg}
        <h1>Hello ${user.firstName}!</h1>
        ${user}
        <p>Change Password</p>
        <form action="ChangePassword" method="post">
        Old Password:<input type="text" name="opass"><br>
        New Password:<input type="text" name="npass"><br>
        Confirm Password:<input type="text" name="cpass"><br>
        <input type="submit">
        </form>
        
        <p>Edit Information</p>
        <form action="ManageAccountForStudent" method="post">
        FIRST NAME:<input type="text" name="fname"><br>
        LAST NAME:<input type="text" name="lname"><br>
        <input type="submit">
        </form>
        <a href="/QuizHub/Home" class="btn btn-outline-dark">BACK</a>
    </body>
</html>
