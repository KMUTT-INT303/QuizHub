<%-- 
    Document   : CreateQuiz
    Created on : Nov 6, 2019, 9:05:17 PM
    Author     : tsch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <%@ include file="../Layouts/Headers.jsp" %> 

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/ListFaculty"/>
        <jsp:include page="/ListCourse"/>
        <title>Create Quizzes</title>
    </head>

    <body>

        <header><%@ include file="../Layouts/Menu.jsp" %></header>

        <main role="main" class="container">

            <div class="row justify-content-center align-items-center">
                <div class="card col-8 mb-2">
                    <div class="card-body">

                        <center><h3 class="p-2">Create a Quizzes</h3></center>
                        <p>${msg}</p>

                        <form action="CreateQuiz" method="post" autocomplete="off">
                            <div><input type="hidden" name="FROM_CREATE_QUIZ" value="CREATEQUIZ"></div>


                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Quizzes Name</div>
                                    </div>
                                    <input type="text" class="form-control" name="quiz_name" placeholder="">
                                </div>
                            </div>

                            <div class="form-group row">  
                                <label for="description">Quizzes Description</label>
                                <textarea class="form-control" name="quiz_advice" style="width: 100%;"></textarea>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Quizzes Access</div>
                                    </div>
                                    <select class="form-control" id="status" name="quiz_status">
                                        <option value="public">Public</option>
                                        <option value="private">Private</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row" id="code" hidden="true">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend" style="height: fit-content;">
                                        <div class="input-group-text">Join Code</div>
                                    </div>
                                    <input type="text" class="form-control" id="code-value" name="code" placeholder="" value="" readonly>
                                    <div class="input-group-append">
                                        <span class="btn btn-primary mb-2" id="generate">Geranerate Code</span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Quizzes Course</div>
                                    </div>
                                    <select class="form-control" name="course">
                                        <c:forEach items="${course}" var="c">
                                            <option value="${c.id}-${c.name}">${c.id} ${c.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Quizzes Faculty</div>
                                    </div>
                                    <select class="form-control" id="faculty" name="faculty_id">
                                        <c:forEach items="${faculties}" var="f">
                                            <option value="${f.id}">${f.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Quizzes Branch</div>
                                    </div>
                                    <select class="form-control" id="branch" name="branch_id">
                                        <c:forEach items="${branch}" var="b">
                                            <option value="${b.faculty_id}-${b.id}">${b.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" name="cover_image">
                                    <label class="custom-file-label" for="customFile">Choose Images</label>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Quizzes Skill</div>
                                    </div>
                                    <input type="text" class="form-control" name="skill" placeholder="">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Start Date</div>
                                    </div>
                                    <input class="form-control" type="datetime-local" id="start_date" name="start_date">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">End Date</div>
                                    </div>
                                    <input class="form-control" type="datetime-local" name="end_date">
                                </div>
                            </div>

                            <div class="form-group row mb-1">
                                <div class="col">
                                    <center>Time</center>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-8">
                                    <div class="form-row justify-content-center align-items-center">
                                        <div class="col-4">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">Hours</div>
                                                </div>
                                                <input type="text" class="form-control" name="hours" placeholder="00">
                                            </div>
                                        </div>
                                        :
                                        <div class="col-4">
                                            <div class="input-group">
                                                <input type="text" class="form-control" name="minutes" placeholder="00">
                                                <div class="input-group-append">
                                                    <div class="input-group-text">Minutes</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-2"></div>
                            </div>

                            <div class="form-group row mb-4">
                                <div class="col">
                                    <div class="valid-feedback" style="display: block;">
                                        <center>
                                        *If you leave it blank, unlimited time to done.
                                        </center>
                                    </div>
                                </div>
                            </div>



                            <div class="form-group row">
                                <div class="col-sm-12">
                                    <center><button type="submit" class="btn btn-primary mb-2">Create Now</button></center>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

            </div>
        </div>



    </main>
</body>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script> 
<script src="js/script.js"></script>

<%@ include file="../Layouts/Footers.jsp" %> 


</html>
