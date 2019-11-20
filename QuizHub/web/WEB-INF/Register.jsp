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
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <body>        
        <div class="register-section">
            <div class="register-section-width">
                <div id="container" class="container">
                    <div class="row text-white">
                        <div class="col-sm-6 offset-sm-3 text-center">
                            <h3 class="display-4 mb-3">QuizHub</h3>
                            <h4 class="mb-2">${msg}</h4>
                            <div class="info-form">
                                
                                






                                <div class="container">
                                    <ul class="nav nav-tabs justify-content-center align-items-center" style="border-bottom: 0px;">
                                        <li><a data-toggle="tab" href="#s" class="btn btn-primary m-2"><i class="fas fa-user-graduate"></i> Student Register</a></li>
                                        <li><a data-toggle="tab" href="#t" class="btn btn-primary m-2"><i class="fas fa-chalkboard-teacher"></i> Teacher Register</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div id="s" class="tab-pane fade in active">
                                            <form id="register-form" action="Register" method="post" class="form-inlin justify-content-center"<%--enctype="multipart/form-data" --%> autocomplete="off">
                                                <div><input type="hidden" name="FROM_REGISTER" value="REGISTER_STUDENT"></div>
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
                                                            <label class="sr-only">E-mail</label>
                                                            <input type="text" name="email" class="form-control" placeholder="Email Address">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label class="sr-only">Faculty</label>
                                                            <select class="form-control" id="faculty" name="faculty">
                                                                <option value="0" selected="selected">Select your faculty</option>
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
                                                            <select class="form-control" id="branch" name="branch" hidden="true"> 
                                                                <c:forEach items="${branch}" var="b">
                                                                    <option value="${b.faculty_id}-${b.id}">${b.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>


                                                <button type="submit" class="btn btn-success "><i class="fas fa-check-square"></i> Register</button>
                                                <a href="Login" class="btn btn-success"><i class="fas fa-undo"></i> Back</a>
                                            </form>

                                        </div>
                                        <div id="t" class="tab-pane fade">
                                            <form id="register-form" action="TeacherRegister" method="post" class="form-inlin justify-content-center"<%--enctype="multipart/form-data" --%> autocomplete="off">
                                                <div><input type="hidden" name="FROM_REGISTER" value="REGISTER_TEACHER"></div>
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label class="sr-only">Teacher ID</label>
                                                            <input type="number" name="teacher_id" class="form-control" placeholder="Teacher ID">
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
                                                            <label class="sr-only">E-mail</label>
                                                            <input type="text" name="email" class="form-control" placeholder="Email Address">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label class="sr-only">Faculty</label>
                                                            <select class="form-control" id="faculty" name="faculty">
                                                                <option value="0" selected="selected">Select your faculty</option>
                                                                <c:forEach items="${faculties}" var="f">
                                                                    <option value="${f.id}">${f.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>

                                                <button type="submit" class="btn btn-success "><i class="fas fa-check-square"></i> Register</button>
                                                <a href="Login" class="btn btn-success"><i class="fas fa-undo"></i> Back</a>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/1085264464.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/script.js"></script>

</html>

