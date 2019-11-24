<%-- 
    Document   : ManageSystem
    Created on : Nov 13, 2019, 10:28:40 AM
    Author     : Top
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial;}

            /* Style the tab */
            .tab {
                overflow: hidden;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
            }

            /* Style the buttons inside the tab */
            .tab button {
                background-color: inherit;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 14px 16px;
                transition: 0.3s;
                font-size: 17px;
            }

            /* Change background color of buttons on hover */
            .tab button:hover {
                background-color: #ddd;
            }

            /* Create an active/current tablink class */
            .tab button.active {
                background-color: #ccc;
            }

            /* Style the tab content */
            .tabcontent {
                display: none;
                padding: 6px 12px;
                border: 1px solid #ccc;
                border-top: none;
            }
        </style>
        <script>
            function openCity(evt, cityName) {
                var i, tabcontent, tablinks;
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                }
                document.getElementById(cityName).style.display = "block";
                evt.currentTarget.className += " active";
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${user}!</h1>
        <a href="Home">Back</a>
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'Student')">Student</button>
            <button class="tablinks" onclick="openCity(event, 'Teacher')">Teacher</button>
            <button class="tablinks" onclick="openCity(event, 'ActiveTeacher')">Active Teacher</button>
            <button class="tablinks" onclick="openCity(event, 'FacultyAndBranch')">Faculty & Branch</button>
        </div>

        <div id="Student" class="tabcontent">
            <h3>Student</h3>
            <iframe allowfullscreen frameborder="0" width="100%" height="540" src="StudentManagement"></iframe>
        </div>

        <div id="Teacher" class="tabcontent">
            <h3>Teacher</h3>
            <iframe allowfullscreen frameborder="0" width="100%" height="540" src="TeacherManagement"></iframe>
        </div>
        
        <div id="ActiveTeacher" class="tabcontent">
            <h3>Active Teacher</h3>
            <iframe allowfullscreen frameborder="0" width="100%" height="540" src="ActiveUserSystem"></iframe>
        </div>
        
        <div id="FacultyAndBranch" class="tabcontent">
            <h3>Faculty & Branch</h3>
            <iframe allowfullscreen frameborder="0" width="100%" height="540" src="FacultyManagement"></iframe>
        </div>


    </body>
</html>
