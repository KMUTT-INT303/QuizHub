<%-- 
    Document   : TeacherManagement
    Created on : Nov 11, 2019, 11:46:14 PM
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
        <h1>Hello ${user.fullname}!</h1>
        <h2>Teacher Management</h2><hr><br>
        ${msg}<br>TEACHER IN SYSTEM : ${teachers.size()}<br>
        <form action="TeacherManagement" method="post">
            Find Student : <input type="text" name="findbydescription" value="${param.findbydescription}"> <input  type="submit">
            <c:if test="${teachersbydes!=null}">
                <table border="3">
                <tr>
                    <th>Student_ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Faculty</th>
                    <th>Status</th>
                    <th>REMOVE</th>
                </tr>
                <c:forEach items="${teachersbydes}" var="t">
                    <tr>
                        <td>${t.id}</td>
                        <td>${t.firstName}</td>
                        <td>${t.lastName}</td>
                        <td>${t.faculty_id}</td>
                        <td>${t.account_status}</td>
                        <td>
                            <input type="checkbox" name="delete_id" value="${t.id}">
                        </td> 
                    </tr>
                </c:forEach>
                    <te>
                        <td colspan="5"></td>
                        <td><input type="submit"></td>
                    </tr>
                </table>
            </c:if>
        <table border="3">
            <tr>
                <th>Student_ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Faculty</th>
                <th>Status</th>
                <th>REMOVE</th>
            </tr>
            <c:forEach items="${teachers}" var="t">
                <tr>
                    <td>${t.id}</td>
                    <td>${t.firstName}</td>
                    <td>${t.lastName}</td>
                    <td>${t.faculty_id}</td>
                    <td>${t.account_status}</td>
                    <td><a href="TeacherManagement?teacher_id=${t.id}">REMOVE</a></td>                 
                </tr>
            </c:forEach>
        </table>
            <a href="Home">Back</a>
    </body>
</html>
