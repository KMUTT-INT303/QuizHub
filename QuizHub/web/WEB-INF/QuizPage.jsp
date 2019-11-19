<%-- 
    Document   : QuizPage
    Created on : Nov 14, 2019, 12:12:26 AM
    Author     : tsch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <%@ include file="../Layouts/Headers.jsp" %> 

    <body>

        <header><%@ include file="../Layouts/Menu.jsp" %></header>

        <main role="main" class="container">

            <div class="row justify-content-center">

                <div class="col-sm-8">

                    <div class="card mb-4">
                        <h6 class="card-header"><center>${takequiz.quizName}</center></h6>

                        <c:if test="${(status == 'Teacher')|| status == 'admin'}">
                            <div class="card-body text-secondary">
                                <div class="card">
                                    <div class="card-body">
                                        <nav class="nav">
                                            <button class="btn btn-primary m-2" type="button" data-toggle="collapse" data-target="#question" aria-expanded="false" aria-controls="question">
                                                <i class="fas fa-plus"></i> Add Question
                                            </button>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        

                        <div class="collapse" id="question">
                            <div class="card-body text-secondary">
                                <div class="card">
                                    <div class="card-body">
                                        <form role="form" autocomplete="off" method="post" action="CreateQuestion">
                                            <div class="container mb-1">
                                                <div class="row">
                                                    <div class="control-group col">

                                                        <div class="controls-q"> 

                                                            <div class="entry-q input-group col-xs-3">
                                                                <input name="page" value="${takequiz.page}" hidden />
                                                                <input name="quiz_id" value="${takequiz.quizId}" hidden />
                                                                <input class="form-control" name="question" type="text" placeholder="Insert your question" />
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="control-group col">

                                                        <div class="controls-c"> 
                                                            <fieldset role="form" autocomplete="off">
                                                                <div class="entry-c input-group col-xs-3">
                                                                    <input class="form-control m-1" name="choice" type="text" placeholder="Insert your choice" />
                                                                    <select name="correct" class="form-control col-2 m-1">
                                                                        <option value="false">false</option>
                                                                        <option value="true">true</option>
                                                                    </select>
                                                                    <span class="input-group-btn m-1">
                                                                        <button class="btn btn-success btn-add-c" type="button">
                                                                            <i class="fas fa-plus"></i>
                                                                        </button>
                                                                    </span>
                                                                </div>
                                                            </fieldset>
                                                        </div>
                                                    </div>
                                                </div>

                                                <center><button type="submit" class="btn btn-success"><i class="fas fa-check-square"></i> Confirm</button></center>
                                            </div>
                                        </form>                        

                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:if>
                        <form method="post" action="Done" id="send">
                            <input name="quiz_id" value="${takequiz.quizId}" hidden />
                            <input name="student_id" value="${user.id}" hidden />
                            <input type="hidden" name="count" value="${countc}">
                            <c:forEach items="${question}" var="q" varStatus="qround">
                                <div class="card-body text-secondary">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">${qround.count}. ${q.questionName}</h5>
                                            <c:forEach items="${choice}" var="c" varStatus="cround">
                                                <c:if test="${q.questionId == c.questionId}">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="radio" name="result${qround.count}" value="${c.choiceId}">
                                                        <label class="form-check-label" for="${q.questionId}">
                                                            ${c.choiceName}
                                                        </label>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </form>

                        <%--<div class="card-footer">
<span class="float-left"><span class="btn btn-secondary" id="prev">Previous</span></span>
<span class="float-right"><span class="btn btn-secondary" id="next">Next</span></span>
</div>--%>
                    </div>
                </div>


                <div class="col-sm-4">


                    <div class="card mb-4">
                        <h6 class="card-header"><center><i class="fas fa-hourglass-half"></i> Time</center></h6>
                        <div class="card-body text-secondary">
                            <center>   
                                <c:if test="${takequiz.hours == 'unlimited' && takequiz.minutes == 'unlimited'}">
                                    <p>Pratice</p>
                                </c:if>
                                <div class="m-3">
                                    <div id="time">
                                        <div class="timer"></div>
                                    </div>
                                </div>
                                <button id="start" class="btn btn-warning" ><i class="fas fa-play"></i> Start</button>

                                <%--${countc} : ${countq} --%>

                            </center>
                        </div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body text-secondary">
                            <center>   

                                <button type="submit" form="send" class="btn btn-success"><i class="fas fa-arrow-alt-circle-right"></i> Done</button>

                            </center>
                        </div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body text-secondary">
                            <center>   
                                <form action="ManageQuiz" method="get">
                                <button type="submit" class="btn btn-success"><i class="fas fa-cogs"></i> Mange Quizzes</button>
                                </form>
                            </center>
                        </div>
                    </div>


                </div>


            </div>



        </main>
    </body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/easytimer@1.1.1/dist/easytimer.min.js"></script>
    <script src="js/script.js"></script>

    <script>

        <c:if test="${takequiz.hours != 'unlimited' && takequiz.minutes != 'unlimited'}">
        var timer = new Timer();

        $(document).on('click', '#start', function (e)
        {
            e.preventDefault();
            if (!timer.isRunning()) {
                timer.start({
                    countdown: true,
                    startValues: {
                        hours: ${takequiz.hours},
                        minutes: ${takequiz.minutes},
                        seconds: 0
                    }
                });
            }

        })

        $('#time .timer').html('${takequiz.hours}:${takequiz.minutes}:00');

        timer.addEventListener('secondsUpdated', function (e)
        {
            $('#time .timer').html(timer.getTimeValues().toString());
        });

        timer.addEventListener('targetAchieved', function (e)
        {
            $('#time .timer').html('Time over');
        });
        </c:if>

    </script>

    <%@ include file="../Layouts/Footers.jsp" %> 


</html>

