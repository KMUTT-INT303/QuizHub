<%-- 
    Document   : StatSearch
    Created on : Oct 26, 2019, 12:13:11 AM
    Author     : MaxPong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Statistic</title>
    </head>
    <body>
        <h1>Statistic Site</h1>
        <form action="StatSearch">
        <input type="text" name="searchText">
        <select name="searchType">
            <option value="quizName">Quiz Name</option>
            <option value="className">Class Name</option>
        </select>
        <br>
        <button type="submit">search</button>
        </form>
        ${msg}
    
    <c:forEach items="${classList}" var="c" varStatus="cs">
    <a href="StatSearch?classSelect=${c.id}">${c.name}</a> ${c.id}<br>
    </c:forEach>    
    
        
    <c:forEach items="${quizList}" var="q" varStatus="qs"> Quiz Name : 
    <a href="Quizzes?p=${q.page}">${q.quizName}</a>
    
    
    Course : ${q.quizCourseName}
    Test Score :${quizTestScore[qs.index].score} / ${quizTestScore[qs.index].fullScore} Practice Score :
    Percent :${quizTestScore[qs.index].percent}% Skill:${quizTestScore[qs.index].skill}<br>
    
    </c:forEach>   
    </body>
</html>
