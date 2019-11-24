<%-- 
    Document   : ClassStat
    Created on : Oct 26, 2019, 12:13:26 AM
    Author     : MaxPong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="../Layouts/Headers.jsp" %> 
        <title>Class Quiz</title>
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
        <h1>Class quiz statistic</h1>
        ${averagePercentOfClass} %
        <h1>Overall class skill statistic</h1>
        
        <c:forEach items="${skillList}" var="s" varStatus="ss">
        Skill Name : ${s.name}
        Skill Average Percent : ${s.averagePercent} % <br>
        </c:forEach>  
        
    
    <c:forEach items="${quizList}" var="q" varStatus="qs"> Quiz Name : 
    <a href="Quizzes?p=${q.page}">${q.quizName}</a>
    
    
    Course : ${q.quizCourseName}
    Test Score :${quizTestScore[qs.index].score} / ${quizTestScore[qs.index].fullScore} Practice Score :
    Percent :${quizTestScore[qs.index].percent}% Skill:${quizTestScore[qs.index].skill}<br>
    
    </c:forEach>   
    
    </body>
</html>
