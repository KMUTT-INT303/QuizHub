<%-- 
    Document   : Quiz
    Created on : Oct 31, 2019, 1:32:38 AM
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

                <div class="col-sm-12">

                    <div class="card mb-2">
                        <div class="card-body">
                            <form method="post" action="JoinQuizzes">

                                <div class="row mb-2">
                                    <div class="col-sm-12 text-center"><h3>Quizhub Code</h3></div>
                                </div>

                                <div class="row mb-2">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6">
                                        <div class="input-group">
                                            <input class="form-control mr-sm-2" type="text" name="code" placeholder="Have a code? Join with your code"> 
                                            <span class="input-group-btn">
                                                <button class="btn btn-outline-primary">Join</button>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                            </form>
                        </div>
                    </div>

                </div>
            </div>

            <div class="row">

                <div class="col-sm-12">

                    <div class="card mb-2">
                        <h6 class="card-header">Quizhub<div class="float-right"><c:if test="${status == 'Teacher'}"><a class="badge badge-success" href="CreateCourse">Create Course</a> <a class="badge badge-success" href="CreateQuiz">Create A Quiz</a></c:if></div></h6>
                            <div class="card-body">
                                <div class="row mb-2">
                                    <div class="col-sm-12">
                                        <div class="row m-3">
                                            <div class="card-deck col-12">

                                            <c:forEach items="${quizzes}" var="q" varStatus="round">
                                                <div class="card">
                                                    <img class="card-img-top" src="images/template.svg" alt="Card image cap">
                                                    <div class="card-body">
                                                        <h5 class="card-title">${q.quizName}</h5>
                                                        <p class="card-text" style="color: gray;">${q.quizComment}</p>
                                                        <span class="badge badge-info">${q.quizCourseName}</span>
                                                    </div>
                                                    <div class="card-footer">
                                                        <small class="text-muted">Due date: ${q.quizEndDate}</small>
                                                    </div>
                                                </div>


                                                <c:if test="${round.count % 3 == 0}">
                                                </div>
                                            </div>
                                                <hr style="width: 50em;">
                                            <div class="row m-3 mb-2">
                                                <div class="card-deck col-12">
                                                </c:if>
                                            </c:forEach>
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

