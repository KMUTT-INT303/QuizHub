<%-- 
    Document   : ActiveUserSystem
    Created on : Nov 12, 2019, 9:43:52 PM
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
        ${msg}
        <table border="3">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Status</th>
                <th>#</th>
            </tr>
            <c:forEach items="${teachers_pending}" var="t">
                <tr>
                    <td>
                        ${t.id}
                    </td>
                    <td>
                        ${t.firstName}
                    </td>
                    <td>
                        ${t.lastName}
                    </td>
                    <td>
                        ${t.account_status}
                    </td>
                    <td>
                        <a href="ActiveUserSystem?teacher_id=${t.id}&for=active">${t.account_status=="active"?"Actived":"Active"}</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <table border="3">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Status</th>
                <th>#</th>
            </tr>
            <c:forEach items="${teachers_active}" var="t">
                <tr>
                    <td>
                        ${t.id}
                    </td>
                    <td>
                        ${t.firstName}
                    </td>
                    <td>
                        ${t.lastName}
                    </td>
                    <td>
                        ${t.account_status}
                    </td>
                    <td>
                        <a href="ActiveUserSystem?teacher_id=${t.id}&for=pending">${t.account_status=="pending"?"wait":"Set To Pending"}</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
