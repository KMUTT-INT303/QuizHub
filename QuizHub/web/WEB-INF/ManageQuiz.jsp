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


        <form action="ManageQuiz" method="post" enctype="multipart/form-data" id="upText">  
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
            <input type="text" name="currentQuizId" value="${currentQuizId}" hidden>




        </form>




        <input type="button" value="Apply" onclick="submitForm()" />
        <form  method="post" action="Upload" enctype="multipart/form-data" id="upPic">

            <input type="text" name="currentQuizId" value="${currentQuizId}" hidden>
            Quizzes Cover Image
            <input type="file" name="newCoverImage">
            Choose Images
            <button type="submit">Apply Image</button>
        </form>

    </body>

    <script>
        function submitForm() {
            document.getElementById("upText").submit();
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/1085264464.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/script.js"></script>
</html>
