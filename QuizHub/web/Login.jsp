<%-- 
    Document   : login
    Created on : Oct 17, 2019, 10:57:34 AM
    Author     : tsch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <%@ include file="Layouts/Headers.jsp" %> 

    <body class="text-center" data-gr-c-s-loaded="true">
        
        
        <form class="form-signin">
            <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">QuizHub -</h1>
            <label for="inputEmail" class="sr-only">ชื่อผู้ใช้งาน</label>
            <input type="text" id="username" class="form-control" placeholder="ชื่อผู้ใช้งาน" required="" autofocus="">
            <label for="password" class="sr-only">รหัสผ่าน</label>
            <input type="password" id="password" class="form-control" placeholder="รหัสผ่าน" required="">
            <button class="btn btn-lg btn-primary btn-block" type="submit">เข้าสู่ระบบ</button>
            <p class="mt-5 mb-3 text-muted">© 2019</p>
        </form>


    </body>

</html>
