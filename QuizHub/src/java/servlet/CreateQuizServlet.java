/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Quizdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quizzes;
import model.Teacher;
import java.util.*;
import java.nio.charset.*;

/**
 *
 * @author tsch
 */
public class CreateQuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String quizName = request.getParameter("quiz_name");
        String quizComment = request.getParameter("quiz_advice");
        String quizStatus = request.getParameter("quiz_status");
        String quizTeacherId = "1000000001"; //request.getParameter("teacher_id");
        String course = request.getParameter("course");
        String quizFacultyId = request.getParameter("faculty_id");
        String quizBranchId = request.getParameter("branch_id");
        String quizCode = request.getParameter("code");
        String quizCoverImages = request.getParameter("cover_image");
        String quizSkillText = request.getParameter("skill");
        String quizStartDate = request.getParameter("start_date");
        String quizEndDate = request.getParameter("end_date");

        if (quizName == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/CreateQuiz.jsp").forward(request, response);
        }

        String[] list = course.split("-");
        String courseId = list[0];
        String courseName = list[1];

        String[] branch_list = quizBranchId.split("-");
        String branch_id = branch_list[1];

        String removeTS = quizStartDate.replace("T", " ");
        String removeED = quizEndDate.replace("T", " ");

        HttpSession session = request.getSession();
        Teacher t = (Teacher) session.getAttribute("user"); // Session User to Type Teacher!

        Quizdao qdao = new Quizdao();
        Quizzes q = new Quizzes();

        /* q = new Quizzes(
                quizName,
                quizComment,
                quizStatus,
                Long.valueOf(quizTeacherId),
                //t.getId(),
                courseName,
                courseId,
                Integer.valueOf(quizFacultyId),
                Integer.valueOf(branch_id),
                quizCode,
                quizCoverImages,
                quizSkillText,
                Timestamp.valueOf(removeTS + ":00"),
                Timestamp.valueOf(removeED + ":00")
        );*/
        q.setQuizName(quizName);
        q.setQuizComment(quizComment);
        q.setQuizStatus(quizStatus);
        q.setQuizTeacherId(Long.valueOf(quizTeacherId));
        //t.getId(),
        q.setQuizCourseName(courseName);
        q.setQuizCourseId(courseId);
        q.setQuizFacultyId(Integer.valueOf(quizFacultyId));
        q.setQuizBranchId(Integer.valueOf(branch_id));
        q.setQuizCode(quizCode);
        q.setQuizCoverImages(quizCoverImages);
        q.setQuizSkillText(quizSkillText);
        q.setQuizStartDate(Timestamp.valueOf(removeTS + ":00"));
        q.setQuizEndDate(Timestamp.valueOf(removeED + ":00"));
        q.setPage(RequiredString(10).toUpperCase());

        qdao.createQuiz(q);

        request.setAttribute("msg", "You have created a quiz.");
        getServletContext().getRequestDispatcher("/WEB-INF/CreateQuiz.jsp").forward(request, response);

    }

    public String RequiredString(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString
                = new String(array, Charset.forName("UTF-8"));
        StringBuffer ra = new StringBuffer();
        for (int i = 0; i < randomString.length(); i++) {
            char ch = randomString.charAt(i);
            if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (n > 0)) {
                ra.append(ch);
                n--;
            }
        }
        return ra.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
