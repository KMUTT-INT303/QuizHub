<%-- 
    Document   : Quiz
    Created on : Oct 31, 2019, 1:32:38 AM
    Author     : tsch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <%@ include file="Layouts/Headers.jsp" %> 

    <body>

        <header><%@ include file="Layouts/Menu.jsp" %></header>
        
        <main role="main" class="container">

            <div class="row">

                <div class="col-sm-12 mb-4">

                    <div class="card mb-2">
                        <h6 class="card-header">Quizhub</h6>
                        <div class="card-body">
                            <form method="post" action="">

                                <div class="row mb-2">
                                    <div class="col-sm-12 text-center"><h3>Quizhub Code</h3></div>
                                </div>

                                <div class="row mb-2">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6">
                                        <div class="input-group">
                                            <input class="form-control mr-sm-2" type="text" name="code" placeholder=""> 
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

                            </form>
                        </div>
                    </div>

                </div>
            </div>

            <div class="row">

                <div class="col-sm-12 mb-4">

                    <div class="card mb-2">
                        <h6 class="card-header">Quizhub</h6>
                        <div class="card-body">
                            <form method="post" action="">

                                <div class="row mb-2">
                                    <div class="col-sm-12">Join quiz with code</div>
                                </div>

                                <div class="row mb-2">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6">
                                        <div class="input-group">
                                            <input class="form-control mr-sm-2" type="text" name="code" placeholder=""> 
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

                            </form>
                        </div>
                    </div>

                </div>
            </div>


        </main>
    </body>

<%@ include file="Layouts/Footers.jsp" %> 


</html>

