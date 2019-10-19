<%-- 
    Document   : login
    Created on : Oct 17, 2019, 10:57:34 AM
    Author     : tsch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>QuizHub - Login</title>
    </head>
    <link rel="stylesheet" type="text/css" href="css/main.css">

    <body>
        <div class="login-section">
            <div class="login-section-width">
                <div id="container" class="container">
                    <div class="row text-white">
                        <div class="col-sm-6 offset-sm-3 text-center">
                            <h3 class="display-4 mb-5">QuizHub</h3>
                            <h2 class="display-4 mb-5">${msg}</h2>
                            <div class="info-form">
                                <form action="Login" method="post" class="form-inlin justify-content-center" autocomplete="off">
                                    <div class="form-group">
                                        <label class="sr-only">Username</label>
                                        <input type="number" name="username" class="form-control" placeholder="Username">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only">Passoword</label>
                                        <input type="password" name="password" class="form-control" placeholder="Password">
                                    </div>
                                    <button type="submit" class="btn btn-success ">Login</button>
                                    <a href="Register" class="btn btn-success">Register</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
