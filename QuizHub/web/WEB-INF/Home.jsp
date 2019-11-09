<%-- 
    Document   : home
    Created on : Oct 17, 2019, 10:57:03 AM
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
            <div class="jumbotron">
                <h1>Welcome to QuizHub</h1>
                <p class="lead">Make learning awesome! Quizhub! brings engagement and fun to more than 1 billion players every year at school, at work, and at home</p>
                <a class="btn btn-lg btn-primary" href="../../components/navbar/" role="button">Try an example »</a>
            </div>
            <div class="row">
                <div class="col-sm-4">

                    <div class="card mb-2">
                        <h6 class="card-header">User Information</h6>
                        <div class="card-body">
                            <div class="card mb-2">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Name: <span class="username">${user.firstName} ${user.lastName}</span></li>
                                </ul>
                            </div>
                            <div class="card mb-2">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Status: ${status}</li>
                                    <li class="list-group-item">ID: ${user.id}</li>
                                    <li class="list-group-item">Last time: 20/10/2562 - 06:39:59</li>
                                </ul>
                            </div>
                            <div class="card text-center mb-2"><a href="ManageAccount" class="btn btn-outline-dark">Manage</a></div>
                            <div class="card text-center mb-2"><a href="Logout" class="btn btn-outline-danger">Sign out</a></div>
                        </div>
                    </div>

                    <div class="card mb-2">
                        <h6 class="card-header">Last Activities</h6>
                        <div class="card-body">
                            <p>Nothing</p>
                        </div>
                    </div>
                    <c:if test='${status == "Admin"}'>
                    <div class="card mb-2">
                        <h6 class="card-header">Admin Panel</h6>
                        <div class="card-body">
                            <div class="card text-center mb-2"><a href="/QuizHub/StudentManagement" class="btn btn-outline-dark">Student Manage</a></div>
                            <div class="card text-center mb-2"><a href="#" class="btn btn-outline-dark">Teacher Manage</a></div>
                        </div>
                    </div>
                    </c:if>
                </div>
                <div class="col-sm-8">
                    <div class="card mb-2">
                        <h6 class="card-header">Featured Quizzes</h6>
                        <div class="card-body">
                            <div class="row mb-2">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-6">
                                    <form method="post" action="JoinQuizzes">
                                        <div class="input-group">
                                            <input class="form-control mr-sm-2" type="text" name="code" placeholder="Have a code? Join with your code "/> 
                                            <span class="input-group-btn">
                                                <button type="submit" class="btn btn-outline-primary">Join</button>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-3"></div>
                            </div>
                            <div class="row mb-2">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-6">
                                    <div class="card text-center mb-2"><a href="Quizzes" class="btn btn-outline-dark">Quizzes</a></div>
                                </div>
                                <div class="col-sm-3"></div>
                            </div>
                            <div class="row mb-2">
                                <div class="col-sm-12">
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="card-group">
                                    <div class="card m-2">
                                        <img class="card-img-top" src="images/template.svg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Java Programing</h5>
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                            <p class="card-text text-center"><a href="#" class="btn btn-primary">Go somewhere</a></p>
                                        </div>
                                        <div class="card-footer">
                                            <span class="text-muted float-left">Last updated 3 mins ago</span>
                                        </div>
                                    </div>
                                    <div class="card m-2">
                                        <img class="card-img-top" src="images/template.svg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Network Quiz</h5>
                                            <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                                            <p class="card-text text-center"><a href="#" class="btn btn-primary">Go somewhere</a></p>
                                        </div>
                                        <div class="card-footer">
                                            <span class="text-muted float-left">Last updated 3 mins ago</span>
                                        </div>
                                    </div>
                                    <div class="card m-2">
                                        <img class="card-img-top" src="images/template.svg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Web Programing</h5>
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                                            <p class="card-text text-center"><a href="#" class="btn btn-primary">Go somewhere</a></p>
                                        </div>
                                        <div class="card-footer">
                                            <span class="text-muted float-left">Last updated 3 mins ago</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>


<%@ include file="../Layouts/Footers.jsp" %> 


</html>
