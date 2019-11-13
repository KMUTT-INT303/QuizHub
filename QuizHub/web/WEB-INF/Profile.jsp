<%-- 
    Document   : ManageAccount
    Created on : Nov 5, 2019, 6:08:51 PM
    Author     : Top
--%>

<html lang="en">

    <%@ include file="../Layouts/Headers.jsp" %> 

    <body>

        <header><%@ include file="../Layouts/Menu.jsp" %></header>

        <main role="main" class="container">
            <div class="row">

                <div class="col-sm-8">

                    <div class="card mb-4">
                        <h6 class="card-header">Change Password</h6>
                        <div class="card-body text-secondary">
                            ${msg}
                            <form action="ChangePassword" method="post">
                                <div class="form-group row">
                                    <label for="oldpassword" class="col-sm-4 col-form-label">Old Password</label>
                                    <div class="col-sm-8">
                                        <input type="password" class="form-control" name="opass" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="newpassword" class="col-sm-4 col-form-label">New Password</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="npass" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="confirmpassword" class="col-sm-4 col-form-label">Confirm Password</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="cpass" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-primary mb-2">Confirm</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>


                    <div class="card mb-4">
                        <h6 class="card-header">User Information</h6>
                        <div class="card-body text-secondary">
                            ${msg}
                            <form action="ChangePassword" method="post">
                                <div class="form-group row">
                                    <label for="newpassword" class="col-sm-4 col-form-label">First Name</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="fname" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="confirmpassword" class="col-sm-4 col-form-label">Last Name</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="lname" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group row"> 
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-primary mb-2">Confirm</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>


                <div class="col-sm-4">


                    <div class="card mb-4">
                        <h6 class="card-header">Account Status</h6>
                        <div class="card-body text-secondary">
                            <center><p class="btn btn-success col-sm-8">Active</p></center>
                        </div>
                    </div>

                </div>


            </div>
        </main>
    </body>


    <%@ include file="../Layouts/Footers.jsp" %> 


</html>



