<%-- 
    Document   : StudentMangement
    Created on : Oct 20, 2019, 1:26:31 PM
    Author     : Top
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${user}!</h1>
        <h2>Student Management</h2><hr><br>
        ${msg}
        <table border="3">
            <tr>
                <th>Student_ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Faculty</th>
                <th>Branch</th>
                <th>REMOVE</th>
            </tr>
            <c:forEach items="${students}" var="s">
                <tr>
                    <td>${s.student_id}</td>
                    <td>${s.firstName}</td>
                    <td>${s.lastName}</td>
                    <td>${s.faculty_id}</td>
                    <td>${s.branch_id}</td>
                    <td><a href="/QuizHub/StudentManagement?student_id=${s.student_id}">REMOVE</a></td>                 
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
