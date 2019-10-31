<%-- 
    Document   : home
    Created on : Oct 17, 2019, 10:57:03 AM
    Author     : tsch
--%>

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
                <div class="col-sm-4 mb-4">
                    <div class="card">
                        <h6 class="card-header">User Information</h6>
                        <div class="card-body">
                            <div class="card mb-2">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Welcome, ${user.firstName} ${user.lastName}</li>
                                </ul>
                            </div>
                            <div class="card mb-2">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">User status: Student</li>
                                    <li class="list-group-item">ID: ${user.student_id}</li>
                                    <li class="list-group-item">Last time: 20/10/2562 - 06:39:59</li>
                                </ul>
                            </div>
                            <span><a href="#" class="btn btn-outline-primary float-left">Manage</a></button></span>
                            <span><a href="#" class="btn btn-outline-danger float-right">Sign out</a></span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8 mb-4">
                    <div class="card">
                        <h6 class="card-header">Quizhub</h6>
                        <div class="card-body">
                            <form method="post" action="">
                                <div class="row mb-2">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6">
                                        <div class="input-group">
                                            <input class="form-control mr-sm-2" type="text" name="code" placeholder="Join with you code"/> 
                                            <span class="input-group-btn">
                                                <button class="btn btn-outline-primary">Join</button>
                                            </span>
                                        </div>
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
                                        <div class="card">
                                            <img class="card-img-top" src="..." alt="Card image cap">
                                            <div class="card-body">
                                                <h5 class="card-title">Card title</h5>
                                                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                            </div>
                                            <div class="card-footer">
                                                <span class="text-muted float-left">Last updated 3 mins ago</span>
                                                <span><a href="#" class="btn btn-outline-warning float-right">Start quiz</a></span>
                                            </div>
                                        </div>
                                        <div class="card">
                                            <img class="card-img-top" src="..." alt="Card image cap">
                                            <div class="card-body">
                                                <h5 class="card-title">Card title</h5>
                                                <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                                            </div>
                                            <div class="card-footer">
                                                <span class="text-muted float-left">Last updated 3 mins ago</span>
                                                <span><a href="#" class="btn btn-outline-warning float-right">Start quiz</a></span>
                                            </div>
                                        </div>
                                        <div class="card">
                                            <img class="card-img-top" src="..." alt="Card image cap">
                                            <div class="card-body">
                                                <h5 class="card-title">Card title</h5>
                                                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                                            </div>
                                            <div class="card-footer">
                                                <span class="text-muted float-left">Last updated 3 mins ago</span>
                                                <span><a href="#" class="btn btn-outline-warning float-right">Start quiz</a></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>


<%@ include file="../Layouts/Footers.jsp" %> 


</html>
