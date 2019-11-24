<%-- 
    Document   : BranchManagement
    Created on : Nov 20, 2019, 11:18:39 PM
    Author     : Top
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/ListFaculty"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${msg}${faculty}
        <table border='3'>
            <tr>
                <th>ID</th>
                <th>Faculty Name</th>
                <th> # </th>
            </tr>
            <c:forEach items="${faculties}" var="f">
            <tr>
                <td>${f.id}</td>
                <td>${f.name}</td>
                <td><a href="FacultyManagement?id=${f.id}">EDIT</a></td>
            </tr>
            </c:forEach>
        </table><br>
        <form action="FacultyManagement" method="get">
            <input type="hidden" name="id" value="${faculty.id}">
            Faculty Name : <input type="text" name="edit_faculty_name" value="${faculty == null ? 'SELECT SOME FACULTY':faculty.name}">
            <input type="submit" value="EDIT"><br>
        </form>
        <br>
        <table border='3'>
            <tr>
                <th>ID</th>
                <th>Branch Name</th>
                <th> # </th>
            </tr>
            <c:forEach items="${branchesInfaculty}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.name}</td>
                <td><a href="FacultyManagement?id=${faculty.id}&bid=${b.id}">EDIT</a></td>
            </tr>
            </c:forEach>
        </table><br>
        <form action="FacultyManagement" method="get">
            <input type="hidden" name="id" value="${faculty.id}">
            <input type="hidden" name="bid" value="${branch.id}">
            Branch Name : <input type="text" name="edit_branch_name" value="${branch == null?'SELECT SOME BRANCH':branch.name}">
            <input type="submit" value="EDIT"><br>
        </form>
    </body>
</html>
