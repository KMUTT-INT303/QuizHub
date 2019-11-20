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
        <jsp:include page="/ListFaculty"/>
        <jsp:include page="/ListCourse"/>
    </head>
    <body>
        <form action="ManageQuiz">  
            Quizzes Name :  <input type="text" name="newName">
            
            Quizzes Access : <select class="form-control" name="newQuizStatus">
                <option value="public">Public</option>
                <option value="private">Private</option>
            </select>
            Quizzes Code : <input type="code" name="newCode">
            Quizzes Course : <select name="newCourse">
                <c:forEach items="${course}" var="c">
                    <option value="${c.id}-${c.name}">${c.id} ${c.name}</option>
                </c:forEach>
            </select>
            Quizzes Faculty : <select name="newFaculty">
                <c:forEach items="${faculties}" var="f">
                    <option value="${f.id}">${f.name}</option>
                </c:forEach>
            </select>
            Quizzes Branch :  <select  name="newBranch">
                <c:forEach items="${branches}" var="b">
                    <option value="${b.faculty_id}-${b.id}">${b.name}</option>
                </c:forEach>
            </select> 
            <input type="text" name="newSkill" >

            <input type="datetime-local" name="newStartDate">

            <input type="datetime-local" name="newEndDate">

            <input type="text" name="newHours" >

            <input type="text" name="newMinutes" >

            <input type="file" name="newCoverImage">
            <label for="customFile">Choose Images</label>

            <button type="submit" class="btn btn-primary mb-2">Apply</button>


        </form>  


    </body>
</html>
