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
            <div class="jumbotron mb-2">
                <h1>Welcome to QuizHub</h1>
                <p class="lead">Make learning awesome! Quizhub! brings engagement and fun to more than 1 billion players every year at school, at work, and at home</p>
                <a class="btn btn-lg btn-primary" href="Quizzes?p=8E4QKLU4JA" role="button">Try an example <i class="fas fa-hand-point-left"></i></a>
            </div>
            <div class="row">
                <div class="col-sm-4">

                    <div class="card mb-2">
                        <h6 class="card-header"><i class="fas fa-user-tag"></i> User Information</h6>
                        <div class="card-body">
                            <div class="card mb-2">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Name: <span class="username">${user.getFullname()}</span></li>
                                </ul>
                            </div>
                            <div class="card mb-2">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Status: ${status}</li>
                                    <li class="list-group-item">ID: ${user.id}</li>
                                    <%--<li class="list-group-item">Last time: 20/10/2562 - 06:39:59</li>--%>
                                </ul>
                                <ul class="list-group list-group-flush">
                                    <c:if test="${status!='Admin'}">
                                        <c:if test="${status == 'Student'}">
                                            <li class="list-group-item">Branch: <span class="id">${branch_profile.name}</span></li>
                                            </c:if>
                                        <li class="list-group-item">Faculty: <span class="id">${faculty_profile.name}</span></li>
                                        </c:if>
                                </ul>
                            </div>
                            <div class="card text-center mb-2"><a href="Profile" class="btn btn-outline-dark"><i class="fas fa-cogs"></i> Manage</a></div>
                            <div class="card text-center mb-2"><a href="Logout" class="btn btn-outline-danger"><i class="fas fa-sign-out-alt"></i> Sign out</a></div>
                        </div>
                    </div>
                    <c:if test='${status != "Admin"}'>
                        <div class="card mb-2">
                            <h6 class="card-header"><i class="fas fa-list"></i> Last Activities</h6>
                            <div class="card-body">
                                <c:if test="${a != null}">
                                    <c:forEach items="${a}" var="activities">
                                        <li class="list-group-item">Id: ${activities.activities_id} at ${activities.activities_date}</li>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${a == null}">
                                    <p>Nothing in your activities.</p>
                                </c:if>
                            </div>
                        </div>
                    </c:if>
                    <c:if test='${status == "Admin"}'>
                        <div class="card mb-2">
                            <h6 class="card-header"><i class="fas fa-user-shield"></i> Admin Panel</h6>
                            <div class="card-body">
                                <div class="card text-center mb-2"><a href="StudentManagement" class="btn btn-outline-dark">Student Manage</a></div>
                                <div class="card text-center mb-2"><a href="TeacherManagement" class="btn btn-outline-dark">Teacher Manage</a></div>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="col-sm-8">
                    <div class="card mb-2">
                        <h6 class="card-header"><i class="fas fa-star"></i> Newest Quizzes</h6>
                        <div class="card-body pb-1">
                            <div class="row mb-2">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-6">
                                    <form method="post" action="JoinQuizzes">
                                        <div class="input-group">
                                            <input class="form-control mr-sm-2" type="text" name="code" placeholder="Join quizzes with your code!"/> 
                                            <span class="input-group-btn">
                                                <button type="submit" class="btn btn-outline-primary"><i class="fas fa-paper-plane"></i> Join</button>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-3"></div>
                            </div>
                            <center><span>${jerror}</span></center>
                            <div class="row mb-2">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-6">
                                    <div class="card text-center mb-2"><a href="Quizzes" class="btn btn-outline-dark"><i class="fas fa-th"></i> Quizzes</a></div>
                                </div>
                                <div class="col-sm-3"></div>
                            </div>
                            <div class="row mb-2">
                                <div class="col-sm-12">
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="card-deck p-2">
                                    <c:if test="${quizzes != null}">
                                        <c:forEach items="${quizzes}" var="q">
                                            <div class="card mb-1">
                                                    <a href="Quizzes?p=${q.page}"><div id="child-link"></div></a>
                                                    <img class="card-img-top" src="images/template.svg" alt="Card image cap">
                                                    <div class="card-body">
                                                        <h5 class="card-title">${q.quizName}</h5>
                                                        <p class="card-text" style="color: gray;">${q.quizComment}</p>
                                                        <p><b>Course: </b><span class="badge badge-primary">${q.quizCourseName}</span></p>
                                                        <p><b>Skill: </b><span class="badge badge-info">${q.quizSkillText}</span></p>
                                                    </div>
                                                    <div class="card-footer">
                                                        <small class="text-muted">Due date: ${q.quizEndDate}</small>
                                                    </div>
                                                </div>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${quizzes == null}">
                                        Quizzes soon.
                                    </c:if>
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
