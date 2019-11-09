<%-- 
    Document   : CreateCourse
    Created on : Nov 10, 2019, 1:51:25 AM
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
        <h1>Hello ${user.firstName}!</h1>
        ${msg}
        <form action="CreateCourse" method="post">
        COURSE ID:<input type="text" name="id"><br>
        COURSE NAME:<input type="text" name="name"><br>
        <input type="submit"><a href="/QuizHub/Quizzes">BACK</a>
        </form>
    </body>
</html>
