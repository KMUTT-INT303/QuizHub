<%-- 
    Document   : CreateQuiz
    Created on : Nov 6, 2019, 9:05:17 PM
    Author     : tsch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create a Quiz</h1>
        <form method="post" action="CreateQuiz">
            <div><input type="text" name="quiz_name" placeholder="Your quiz name" /></div>
            <div><input type="text" name="quiz_advice" placeholder="Your quiz advice (Optical)" /></div>
            <div>
            </div><select>
                <option>public</option>
                <option>private</option>
            </select>
        </div>
        <div><input type="text" name="teacher_id" value="" hidden="true" /></div>
        <div><input type="text" name="course_name" placeholder="Course Name" /></div>
        <div><input type="text" name="course_id" placeholder="Course Id" /></div>
        <div><input type="text" name="faculty_id" placeholder="Faculty" /></div>
        <div><input type="text" name="branch_id" placeholder="Branch" /></div>
        <div><input type="text" name="code" placeholder="Code" /></div>
        <div><input type="text" name="cover_image" placeholder="Your quiz photo cover" /></div>
        <div><input type="text" name="skill" placeholder="What's about this quiz skills?" /></div>
        <div>Start Date: <input type="datetime-local" name="start_date"></div>
        <div>End Date: <input type="datetime-local" name="end_date"></div>
        <div><button type="submit">Create</button></div>
    </form>
</body>
</html>
