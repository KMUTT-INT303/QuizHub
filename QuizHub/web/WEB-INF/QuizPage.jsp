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

                <div id="block-content-q" class="col-sm-8" ${status == 'Student' ? 'hidden="true"' : ''}>

                    <div class="card mb-4">
                        <h6 class="card-header"><center>${takequiz.quizName}</center></h6>
                                ${msg}

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






                        <c:if test="${status == 'Student'}">
                            <div class="card" id="quiz-info">
                                <div class="card-body">
                                    <h5 class="card-title">${takequiz.quizName}</h5>
                                    <h6 class="card-subtitle mb-4 text-muted">Teacher. Lenadian Pual | Created at 20/10/2019 20:21</h6>


                                    <b><p class="card-text">Description</p></b>
                                    <small><p class="card-text mb-4 ml-2">${takequiz.quizComment}</p></small>


                                    <b><p class="card-text">Details</p></b>
                                    <small>
                                        <p class="card-text mb-4 ml-2">
                                            Course ID: <span class="badge badge-primary">${takequiz.quizCourseId}</span>
                                            Faculty: <span class="badge badge-primary">${takequiz.quizFacultyId}</span>
                                            Branch: <span class="badge badge-primary">${takequiz.quizBranchId}</span>
                                            Skill: <span class="badge badge-info">${takequiz.quizSkillText}</span>
                                            Teacher: <span class="badge badge-dark">${takequiz.quizTeacherId}</span>
                                        </p>
                                    </small>

                                    <div class="row justify-content-center">
                                        <div class="alert alert-info text-center col-6" role="alert">
                                            <b> If you are ready. Press start button! </b>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </c:if>








                        <form method="post" action="Done" id="send">
                            <input name="quiz_id" value="${takequiz.quizId}" hidden />
                            <input name="student_id" value="${user.id}" hidden />
                            <input type="hidden" name="count" value="${countc}">
                            <input type="hidden" name="countq" value="${countq}">
                            <input type="hidden" name="ispractice" value="<c:choose><c:when test="${takequiz.hours == 'unlimited' && takequiz.minutes == 'unlimited'}">true</c:when><c:otherwise>false</c:otherwise></c:choose>">
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
                        </form>

                        <%--<div class="card-footer">
<span class="float-left"><span class="btn btn-secondary" id="prev">Previous</span></span>
<span class="float-right"><span class="btn btn-secondary" id="next">Next</span></span>
</div>--%>
                    </div>
                </div>


                <div class="col" id="info">

                    <c:if test="${status == 'Student'}">
                        <div class="card mb-4">
                            <h6 class="card-header"><div id="block-content-t"><center><i class="fas fa-info-circle"></i> Quiz Alert</center></div></h6>
                            <div class="card-body text-secondary">
                                <center>
                                    <c:choose>
                                        <c:when test="${question.size() <= 0}">

                                            <div class="alert alert-warning col-6" role="alert">
                                                This quiz doesn't have any question yet.
                                            </div>

                                        </c:when>

                                        <c:otherwise>


                                            <c:choose>
                                                <c:when test="${takequiz.hours == 'unlimited' && takequiz.minutes == 'unlimited'}">
                                                    <p>Practice</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="m-3" id="time" hidden="true">
                                                        <div class="timer"></div>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>


                                            <c:choose>
                                                <c:when test="${takequiz.hours == 'unlimited' && takequiz.minutes == 'unlimited'}">
                                                    <div class="alert alert-succes col-8" id="announce" role="alert">
                                                        <p><b>Please attention!</b></p>
                                                        <p><small>This is practice. You can take with unlimited times!</small></p>
                                                        <p><span class="badge badge-success">*Note: Your score will be not recognize.</span></p>
                                                    </div>
                                                    <button id="load" class="btn btn-success" ><i class="fas fa-check-square"></i> Accept </button>
                                                    <div id="start_btn"></div>
                                                    <%--${countc} : ${countq} --%>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="alert alert-warning col-8" id="announce" role="alert">
                                                        <p><b>Please attention!</b></p>
                                                        <p><small>You cannot leaving or close page until you finish. You will lose score if you leave or close!</small></p>
                                                        <p><span class="badge badge-danger">*Note: You can do once time after press accept your score will be recognize.</span></p>
                                                    </div>
                                                    <button id="load" class="btn btn-success" ><i class="fas fa-check-square"></i> Accept </button>
                                                    <div id="start_btn"></div>
                                                    <%--${countc} : ${countq} --%>
                                                </c:otherwise>
                                            </c:choose> 
                                        </c:otherwise>
                                    </c:choose>

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

                        <div class="card mb-4">
                            <div class="card-body text-secondary">
                                <center>   
                                    <button id="delete-quiz" type="submit" class="btn btn-danger" value="${takequiz.quizId}"><i class="fas fa-minus-circle"></i> Remove Quiz</button>
                                </center>
                            </div>
                        </div>


                    </c:if>


                </div>


            </div>



        </main>

        <div class="modal" tabindex="-1" role="dialog" id="block-q">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <p>You are already taken this quiz.</p>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal" tabindex="-1" role="dialog" id="d-quiz">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <p>You are sure? Delete Quiz.</p>
                        <p><small>Quiz data and choice include score, statics will be remove for permanent</small></p>
                        <button type="button" class="btn btn-danger" id="confirm">Confirm</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>


    </body>

    <%@ include file="../Layouts/Footers.jsp" %> 
    <script src="https://cdn.jsdelivr.net/npm/easytimer@1.1.1/dist/easytimer.min.js"></script>
    <script src="js/script.js"></script>

    <script>

        var timer = new Timer();

        $(document).on('click', '#load', function (e)
        {
            e.preventDefault();

            $.ajax({
                type: "POST",
                url: "StartQuiz",
                data: {
                    quiz_id: ${takequiz.quizId},
                    page: '${takequiz.page}',
                    ispratice: '<c:choose><c:when test="${takequiz.hours == 'unlimited' && takequiz.minutes == 'unlimited'}">true</c:when><c:otherwise>false</c:otherwise></c:choose>'
                                },
                                success: function (e) {
                                    if (e == 1) {
                                        $('#block-q').modal('show');
                                    } else {

                                        $('#nready').hide();
                                        $('#load').hide();
                                        $('#announce').remove();

                                        $('#block-content-t').html('<div class="animated heartBeat"><center><i class="fas fa-hourglass-half"></i> Time</center></div>');
                                        $('#info').addClass("animated fadeInLeft");
                                        $('#block-content-q').attr("hidden", false).addClass("animated fadeInLeft");

                                        $('#time').attr("hidden", false);

                                        $('#start_btn').html('<button id="start" class="btn btn-warning" ><i class="fas fa-play"></i> Start</button>');

                                    }
                                }
                            });

                        });

                        $(document).on('click', '#start', function (e)
                        {
                            e.preventDefault();
                            if (!timer.isRunning()) {

                                $('#quiz-info').remove();
                                $('#start').remove();

                                $('#ready').load("LoadQuiz");
                                $('#done_button').load("LoadDoneButton");

        <c:choose>
            <c:when test="${takequiz.hours == 'unlimited' && takequiz.minutes == 'unlimited'}">
                                timer.start({
                                    countdown: true,
                                    startValues: {
                                        hours: 99,
                                        minutes: 0,
                                        seconds: 0
                                    }
                                });
            </c:when>
            <c:otherwise>
                                timer.start({
                                    countdown: true,
                                    startValues: {
                                        hours: ${takequiz.hours},
                                        minutes: ${takequiz.minutes},
                                        seconds: 0
                                    }
                                });
            </c:otherwise>
        </c:choose>
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


                        $(document).on('click', '#confirm', function (e)
                        {
                            e.preventDefault();

                            var quiz_id = $('#delete-quiz').val();

                            $.ajax({
                                type: "POST",
                                url: "DeleteQuizzes",
                                data: {
                                    q_id: quiz_id
                                },
                                success: function (e) {
                                    if (e == 1) {
                                        alert("Your quiz was successful removed.");
                                        location.href = "Quizzes";
                                    } else {
                                        alert("You cannot remove this quiz.");
                                    }
                                }
                            });

                        });

                        $(document).on('click', '#delete-quiz', function (e)
                        {
                            e.preventDefault();

                            $('#d-quiz').modal('show');

                        });

        <c:choose>
            <c:when test="${takequiz.hours == 'unlimited' && takequiz.minutes == 'unlimited'}">
                        $('#time .timer').html('00:00:00');
            </c:when>
            <c:otherwise>
                        $('#time .timer').html('${takequiz.hours}:${takequiz.minutes}:00');
            </c:otherwise>
        </c:choose>

                        timer.addEventListener('secondsUpdated', function (e)
                        {
                            $('#time .timer').html(timer.getTimeValues().toString());
                        });

                        timer.addEventListener('targetAchieved', function (e)
                        {
                            $('#time .timer').html('Time over').delay(10000, function (e) {
                                $('#send').submit();
                                location.href = "Score";
                            });
                        });

    </script>


</html>

