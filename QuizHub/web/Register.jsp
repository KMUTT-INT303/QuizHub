<%-- 
    Document   : login
    Created on : Oct 17, 2019, 10:57:34 AM
    Author     : tsch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <jsp:include page="/ListFaculty"/>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>QuizHub - Register</title>
    </head>
    <link rel="stylesheet" type="text/css" href="css/main.css">

    <body>
        <div class="register-section">
            <div class="register-section-width">
                <div id="container" class="container">
                    <div class="row text-white">
                        <div class="col-sm-6 offset-sm-3 text-center">
                            <h3 class="display-4 mb-3">QuizHub</h3>
                            <h2 class="display-4 mb-2">${msg}</h2>
                            <div class="info-form">

                                <form id="register-form" action="Register" method="post" class="form-inlin justify-content-center" autocomplete="off">

                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label class="sr-only">Student ID</label>
                                                <input type="number" name="student_id" class="form-control" placeholder="Student ID">
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group">
                                                <label class="sr-only">Passoword</label>
                                                <input type="password" name="password" class="form-control" placeholder="Password">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label class="sr-only">First Name</label>
                                                <input type="text" name="fname" class="form-control" placeholder="First Name">
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group">
                                                <label class="sr-only">Last Name</label>
                                                <input type="text" name="lname" class="form-control" placeholder="Last Name">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label class="sr-only">Faculty</label>
                                                <select class="form-control" name="faculty">
                                                    <c:forEach items="${faculties}" var="f">
                                                        <option value="${f.id}">${f.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label class="sr-only">Branch</label>
                                                <select class="form-control" name="branch">
                                                    <c:forEach items="${branch}" var="b">
                                                        <option value="${b.id}">${b.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>


                                    <button type="submit" class="btn btn-success ">Register</button>
                                    <a href="Login" class="btn btn-success">Back</a>
                                </form>

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

    <script type="text/javascript" src="js/script.js"></script>

</html>

