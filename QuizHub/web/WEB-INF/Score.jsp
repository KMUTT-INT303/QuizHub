<%-- 
    Document   : newjsp
    Created on : Nov 18, 2019, 5:30:46 PM
    Author     : tsch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Quizzes</title>
        <style>
            body,html{
                height:100%;
                background: linear-gradient(to right, rgb(79, 72, 192), rgb(72, 0, 72));
            }
        </style>
    </head>
    <body>

        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <div class="card col-6 text-center">
                    <center><img id="random" src="" alt="awards" class="img-thumbnail col-5 m-4" style="border: 0px;"></center>
                    <h4 class="p-4">Summary Quizzes</h4>
                    <p class="p-2">Score: ${score}</p>
                    <p class="p-2">Total Correct: ${totalcorrect}</p>
                    <p class="p-2">Total Incorrect: ${totalincorrect}</p>
                    <div class="container mb-3">
                        <div class="row">
                            <div class="col text-center">
                                <a href="Home"><button type="button" class="col btn btn-secondary mb-2">Back</button></a>
                                <button type="button" class="col btn btn-success mb-2">More Details</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <script>
        $(function () {

            var image = new Array();
            image[0] = "https://image.flaticon.com/icons/svg/745/745007.svg";
            image[1] = "https://image.flaticon.com/icons/svg/1218/1218818.svg";
            image[2] = "https://image.flaticon.com/icons/svg/744/744964.svg";
            image[3] = "https://image.flaticon.com/icons/svg/1073/1073231.svg";
            var size = image.length
            var x = Math.floor(size * Math.random())

            $('#random').attr('src', image[x]);

        })
    </script>
    <%

        if (session.getAttribute("score") == null || session.getAttribute("totalcorrect") == null || session.getAttribute("totalincorrect") == null) {
            response.sendRedirect("Quizzes");
        }

        session.removeAttribute("score");
        session.removeAttribute("totalcorrect");
        session.removeAttribute("totalincorrect");

    %>
</html>
