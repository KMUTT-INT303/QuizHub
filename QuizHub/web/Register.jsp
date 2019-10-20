<%-- 
    Document   : Register
    Created on : Oct 19, 2019, 11:21:56 PM
    Author     : Top
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/ListFaculty"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="Register" method="post">
            Student ID: <input type="number" name="student_id"><br>
            Password: <input type="text" name="password"><br>
            First Name: <input type="text" name="fname"><br>
            Last Name: <input type="text" name="lname"><br>
            Faculty: 
            <select name="faculty">
                <c:forEach items="${faculties}" var="f">
                    <option value="${f.id}">${f.name}</option>
                </c:forEach>
            </select>
            <br>
            Branch: 
            <select name="branch">
                <c:forEach items="${branch}" var="b">
                    <option value="${b.faculty_id}">${b.name}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="REGISTER">
        </form>${msg}<a href="/QuizHub/Login.jsp">BACK</a>
    </body>
</html>
