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

                <div id="time">
                    <div class="timer"></div>
                </div>

            </div>


        </main>
    </body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/easytimer@1.1.1/dist/easytimer.min.js"></script>

    <script>

        var timer = new Timer();
        timer.start({
            countdown: true, 
            startValues: {
                hours: 0,
                minutes: 1,
                seconds: 30
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

    </script>

    <%@ include file="../Layouts/Footers.jsp" %> 


</html>

