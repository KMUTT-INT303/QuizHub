<%-- 
    Document   : CreateCourse
    Created on : Nov 10, 2019, 1:51:25 AM
    Author     : Top
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <%@ include file="../Layouts/Headers.jsp" %> 

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/ListFaculty"/>
        <jsp:include page="/ListCourse"/>
        <title>Create Quizzes</title>
    </head>

    <body>

        <header><%@ include file="../Layouts/Menu.jsp" %></header>

        <main role="main" class="container">

            <div class="row justify-content-center align-items-center">
                <div class="card col-8 mb-2">
                    <div class="card-body">

                        <center><h3 class="p-2">Create a Course</h3></center>
                        <p>${msg}</p>

                        <form action="CreateCourse" method="post" autocomplete="off">

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Course ID</div>
                                    </div>
                                    <input type="text" class="form-control" name="id" placeholder="">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">Course Name</div>
                                    </div>
                                    <input type="text" class="form-control" name="name" placeholder="">
                                </div>
                            </div>


                            <div class="form-group row">
                                <div class="col-sm-12">
                                    <center><button type="submit" class="btn btn-primary mb-2">Create Now</button></center>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

            </div>
        </div>



    </main>
</body>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script> 
<script src="js/script.js"></script>

<%@ include file="../Layouts/Footers.jsp" %> 


</html>
