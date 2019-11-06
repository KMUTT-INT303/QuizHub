<%-- 
    Document   : Quiz
    Created on : Oct 31, 2019, 1:32:38 AM
    Author     : tsch
--%>

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
                            <form method="post" action="">

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
                        <h6 class="card-header">Quizhub<div class="float-right"><a class="badge badge-success" href="CreateQuiz">Create A Quiz</a></div></h6>
                        <div class="card-body">
                            <div class="row mb-2">
                                <div class="col-sm-12">
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
            </div>


        </main>
    </body>

    <%@ include file="../Layouts/Footers.jsp" %> 


</html>

