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

                        <c:if test="${(status == 'Teacher')|| status == 'Admin'}">
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
                            <c:if test="${question.size() > 0}">
                                <c:if test="${takequiz.page != page && status == 'Student'}">
                                    <div id="nready">
                                        <div class="card-body text-secondary">
                                            <div class="card">
                                                <div class="card-body">
                                                    Please press start.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:choose>
                                    <c:when test="${status == 'Teacher' || status == 'Admin'}">
                                        <c:forEach items="${question}" var="q" varStatus="qround">
                                            <div class="card-body text-secondary">
                                                <div class="card">
                                                    <div class="card-body sc-remove">
                                                        <h5 class="card-title">${qround.count}. ${q.questionName} <div class="float-right" id="remove-question"><div class="hc-remove"><button type="button" class="btn btn-danger btn-sm" value="${q.questionId}"><i class="fas fa-times-circle"></i></button></div></div></h5>
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
                                    </c:when>
                                    <c:otherwise>
                                        <div id="ready">
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                            <c:if test="${question.size() <= 0}">
                                <div class="card-body text-secondary">
                                    <div class="card">
                                        <div class="card-body">
                                            This quiz doesn't have any question yet.
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </form>

                        <%--<div class="card-footer">
<span class="float-left"><span class="btn btn-secondary" id="prev">Previous</span></span>
<span class="float-right"><span class="btn btn-secondary" id="next">Next</span></span>
</div>--%>
                    </div>
                </div>


                <div class="col-sm-4">

                    <c:if test="${status == 'Student'}">
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
                                    <button id="load" class="btn btn-warning" ><i class="fas fa-play"></i> Ready</button>
                                    <div id="start_btn"></div>
                                    <%--${countc} : ${countq} --%>

                                </center>
                            </div>
                        </div>
                    </c:if>

                    <div id="done_button">

                    </div>

                    <c:if test="${status == 'Teacher' || status == 'Admin'}">
                        <div class="card mb-4">
                            <div class="card-body text-secondary">
                                <center>   
                                    <form action="ManageQuiz" method="post">
                                        <input type="text" hidden name="currentQuiz" value="${takequiz.quizId}">
                                        <button type="submit" class="btn btn-success"><i class="fas fa-cogs"></i> Mange Quizzes</button>
                                    </form>
                                </center>
                            </div>
                        </div>
                    </c:if>


                </div>


            </div>



        </main>


        <div class="modal fade" id="remove-success" tabindex="-1" role="dialog" aria-labelledby="remove-q" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="remove-qmodal">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <%@ include file="../Layouts/Footers.jsp" %> 
    <script src="https://cdn.jsdelivr.net/npm/easytimer@1.1.1/dist/easytimer.min.js"></script>
    <script src="js/script.js"></script>

    <script>

        <c:if test="${takequiz.hours != 'unlimited' && takequiz.minutes != 'unlimited'}">
        var timer = new Timer();

        $(document).on('click', '#load', function (e)
        {
            e.preventDefault();

            $('#nready').hide();
            $('#load').hide();
            $('#start_btn').html('<button id="start" class="btn btn-warning" ><i class="fas fa-play"></i> Start</button>');

            $.ajax({
                type: "POST",
                url: "StartQuiz",
                data: {
                    quiz_id: ${takequiz.quizId},
                    page: '${takequiz.page}'
                },
                success: function (e) {
                    console.log(e);
                }
            });

        });

        $(document).on('click', '#start', function (e)
        {
            e.preventDefault();
            if (!timer.isRunning()) {

                $('#ready').load("LoadQuiz");
                $('#done_button').load("LoadDoneButton");

                timer.start({
                    countdown: true,
                    startValues: {
                        hours: ${takequiz.hours},
                        minutes: ${takequiz.minutes},
                        seconds: 0
                    }
                });
            }

        });

        $(document).on('click', '.sc-remove button', function (e)
        {
            e.preventDefault();

            var q_value = $(this).val();

            $.ajax({
                type: "POST",
                url: "DeleteQuestion",
                data: {
                    q_id: q_value,
                    t_id: '${user.id}',
                    q_page: '${takequiz.page}'
                },
                success: function (e) {
                    location.reload();
                }
            });

        });

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


</html>

