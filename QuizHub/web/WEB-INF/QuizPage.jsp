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

            <div class="row">

                <div class="col-sm-8">

                    <div class="card mb-4">
                        <h6 class="card-header"><center>${takequiz.quizName}</center></h6>
                        <div class="card-body text-secondary">
                            ${msg}
                        </div>
                    </div>

                </div>


                <div class="col-sm-4">


                    <div class="card mb-4">
                        <h6 class="card-header"><center>Time</center></h6>
                        <div class="card-body text-secondary">
                            <center>   
                                <div id="time">
                                    <div class="timer"></div>
                                </div>
                            </center>
                        </div>
                    </div>

                </div>


            </div>



        </main>
    </body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/easytimer@1.1.1/dist/easytimer.min.js"></script>

    <script>

        <c:if test="${takequiz.hours != 'unlimited' && takequiz.minutes != 'unlimited'}">
        var timer = new Timer();
        timer.start({
            countdown: true,
            startValues: {
                hours: ${takequiz.hours},
                minutes: ${takequiz.minutes},
                seconds: 0
            }
        });

        $('#time .timer').html(timer.getTimeValues().toString());

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

