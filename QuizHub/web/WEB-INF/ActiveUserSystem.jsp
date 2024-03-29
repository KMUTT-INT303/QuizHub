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
        <h1>Hello ${user.fullname}!</h1>
        ${msg}${errormsg}
        <form action="ActiveUserSystem" method="post">
            FIND PENDING USER:<input type="text" name="descriptionPendingUser" value="${param.descriptionPendingUser}"><input type="submit">
            <input type="hidden" name="tsta" value="TEACHERSTOACTIVE">
        <c:if test="${teacherByDes != null}">
            <table border="3">
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Status</th>
                    <th>#</th>
                </tr>
                <c:forEach items="${teacherByDes}" var="t">
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
                            <input type="checkbox" name="toactive" value="${t.id}">
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4"></td>
                    <td>
                        <input type="submit">
                    </td>
                </tr>
            </table>
        </c:if>
        </form>
            <p>User wait to active</p>
                        TEACHER IS PENDING : ${teachers_pending.size()}
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
        <p>Users have actived</p>
        TEACHER HAVE ACTIVED : ${teachers_active.size()}
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
