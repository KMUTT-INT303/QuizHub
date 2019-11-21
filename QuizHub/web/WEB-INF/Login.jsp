<%-- 
    Document   : login
    Created on : Oct 17, 2019, 10:57:34 AM
    Author     : tsch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>QuizHub - Login</title>
    </head>
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <body>
        <div class="login-section">
            <div class="login-section-width">
                <div id="container" class="container">
                    <div class="row justify-content-center">
                        <div class="col-6">
                            <h3 class="display-4 mb-3">QuizHub</h3>
                            <c:if test="${msg != null}">
                                <div class="row justify-content-center">
                                    <div class="mb-3 badge badge-danger">
                                        ${msg}
                                    </div>
                                </div>
                            </c:if>
                            <div class="info-form justify-content-center">
                                <form id="login-form" action="Login" method="post" class="form-inlin justify-content-center" autocomplete="off">
                                    <div class="form-group">
                                        <label class="sr-only">Username</label>
                                        <input type="number" name="username" class="form-control" placeholder="Username">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only">Passoword</label>
                                        <input type="password" name="password" class="form-control" placeholder="Password">        
                                    </div>
                                    <div class="row mt-1 justify-content-center">
                                        <button type="submit" class="btn btn-success ml-2 mr-2"><i class="fas fa-sign-in-alt"></i> Login</button>
                                        <a href="Register" class="btn btn-success ml-2 mr-2"><i class="fas fa-user-plus"></i> Register</a>
                                    </div>
                                </form>
                            </div>
                            <div class="row mt-1 justify-content-center">
                                <a href="ForgetPassword">Forget Password?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script> 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/1085264464.js" crossorigin="anonymous"></script>

    <script type="text/javascript" src="js/script.js"></script>

</html>