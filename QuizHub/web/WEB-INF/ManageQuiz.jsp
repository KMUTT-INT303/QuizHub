<%-- 
    Document   : ManageQuiz
    Created on : Nov 18, 2019, 3:24:56 PM
    Author     : MaxPong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="../Layouts/Menu.jsp" %>
        <jsp:include page="/ListFaculty"/>
        <jsp:include page="/ListCourse"/>
    </head>
    <body>
       
        <form action="ManageQuiz">  
            Quizzes Name :  <input type="text" name="newName">
            
            Quizzes Access : <select class="form-control" name="newQuizStatus">
                <option selected></option>
                <option value="public">Public</option>
                <option value="private">Private</option>
            </select>
            Quizzes Code : <input type="code" name="newCode">
            Quizzes Course : <select name="newCourse">
                <option selected></option>
                <c:forEach items="${course}" var="c">
                    <option value="${c.id}-${c.name}">${c.id} ${c.name}</option>
                </c:forEach>
            </select>
            Quizzes Faculty : <select name="newFaculty">
                <option selected></option>
                <c:forEach items="${faculties}" var="f">
                    <option value="${f.id}">${f.name}</option>
                </c:forEach>
            </select>
            Quizzes Branch :  
            <select  name="newBranch">
                <option selected></option>
                <c:forEach items="${branches}" var="b">
                    <option value="${b.faculty_id}-${b.id}">${b.name}</option>
                </c:forEach>
            </select> 
            Quizzes Skill
            <input type="text" name="newSkill" >
            Quizzes Start Date 
            <input type="datetime-local" name="newStartDate">
            Quizzes End Date
            <input type="datetime-local" name="newEndDate">
            Quizzes Hours
            <input type="text" name="newHours" >
            Quizzes Minutes
            <input type="text" name="newMinutes" >
            Quizzes Cover Image
            <input type="file" name="newCoverImage">
            <label for="customFile">Choose Images</label>
            
            <input type="text" name="currentQuizId" value="${currentQuizId}" hidden>
            <button type="submit" class="btn btn-primary mb-2">Apply</button>


        </form>  


    </body>
</html>
