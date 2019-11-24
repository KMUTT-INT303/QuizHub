<%-- 
    Document   : headers
    Created on : Oct 17, 2019, 10:54:47 AM
    Author     : tsch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <div class="container">
        <a class="navbar-brand" href="/QuizHub/Home">QuizHub</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active">
                    <a class="nav-link" href="/QuizHub/Home"><i class="fas fa-home"></i> Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="Profile"><i class="fas fa-user"></i> Profile</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="Quizzes"><i class="fas fa-stream"></i> Quizzes</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="StatSearch"><i class="fas fa-chart-bar"></i> View Statistics</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="Question"><i class="fas fa-comment-dots"></i> Question?</a>
                </li>

                <c:if test="${status == 'Admin'}">
                <li class="nav-item">
                    <a class="nav-link" href="ManageSystem"><i class="fas fa-cogs"></i> Manage System</a>
                </li>
                </c:if>

            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fas fa-search"></i> Search</button>
            </form>
        </div>
    </div>
</nav>