/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.QuizManagerdao;
import db.BuildConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quizzes;
import model.Teacher;

/**
 *
 * @author MaxPong
 */
@MultipartConfig
public class ManageQuizServlet extends HttpServlet {

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
      
        int id = -1;
        PrintWriter out = response.getWriter();
        if (request.getParameter("currentQuiz") != null) {
            String quizId = request.getParameter("currentQuiz");
            request.setAttribute("currentQuizId", quizId);
            id = Integer.valueOf(quizId);
        }

        if (request.getParameter("currentQuizId") != null) {
            String quizId = request.getParameter("currentQuizId");
            request.setAttribute("currentQuizId", quizId);
            id = Integer.valueOf(quizId);
        }

        String newName = request.getParameter("newName");
        String newCode = request.getParameter("newCode");
        String newFaculty = request.getParameter("newFaculty");
        String newBranch = request.getParameter("newBranch");
        String newSkill = request.getParameter("newSkill");
        String newStartDate = request.getParameter("newStartDate");
        String newEndDate = request.getParameter("newEndDate");
        String newHours = request.getParameter("newHours");
        String newMinutes = request.getParameter("newMinutes");
        String newCourse = request.getParameter("newCourse");

        QuizManagerdao qm = new QuizManagerdao();

        if ((newName == null || newName.equals("")) && (newCode == null || newCode.equals("")) && (newFaculty == null || newFaculty.equals("")) && (newBranch == null || newBranch.equals(""))
                && (newSkill == null || newSkill.equals("")) && (newStartDate == null || newStartDate.equals("")) && (newEndDate == null || newEndDate.equals("")) && (newHours == null || newHours.equals("")) && (newMinutes == null || newMinutes.equals(""))) {

            request.getServletContext().getRequestDispatcher("/WEB-INF/ManageQuiz.jsp").forward(request, response);

        } else {
            request.setAttribute("id", id);

            String hours = null;
            String minutes = null;

            if (newHours == null || newHours.trim().isEmpty() || newHours == "0" || newHours == "00") {
                hours = "00";
                minutes = newMinutes;
                newHours = "00";
            }

            if (newMinutes == null || newMinutes.trim().isEmpty() || newMinutes == "0" || newMinutes == "00") {
                hours = newHours;
                minutes = "00";
                newMinutes = "00";
            }

            if ((newHours == null || newHours.trim().isEmpty() || newHours == "0" || newHours == "00" )&& (newMinutes == null || newMinutes.trim().isEmpty() || newMinutes == "0" || newMinutes == "00")) {
                hours = "unlimited";
                minutes = "unlimited";
            }

            String removeSD;
            String removeED;

            HttpSession session = request.getSession();
            Teacher t = (Teacher) session.getAttribute("user");

            Quizzes q = new Quizzes();

            if (newName != null && !(newName.equals(""))) {
                qm.setQuizAttributeValue("quiz_name", newName, id);
            }

            if (newCode != null && !(newCode.equals(""))) {
                qm.setQuizAttributeValue("join_code", newCode, id);
            }

            if (newFaculty != null && !(newFaculty.equals(""))) {
                qm.setQuizAttributeValue("faculty_id", newFaculty, id);
            }

            if (newBranch != null && !(newBranch.equals(""))) {
                String[] branch_list = newBranch.split("-");
                String branch_id = branch_list[1];
                qm.setQuizAttributeValue("branch_id", branch_id, id);
            }
            if (newCourse != null && !(newCourse.equals(""))) {
                String[] list = newCourse.split("-");
                String courseId = list[0];
                String courseName = list[1];
                qm.setQuizAttributeValue("course_name", courseName, id);
                qm.setQuizAttributeValue("course_id", courseId, id);
            }
            if (newSkill != null && !(newSkill.equals(""))) {

                qm.setQuizAttributeValue("skill_text", newSkill, id);

            }

            if (newStartDate != null && !(newStartDate.equals(""))) {
                removeSD = newStartDate.replace("T", " ");
                qm.setQuizAttributeValue("start_date", Timestamp.valueOf(removeSD + ":00"), id);
            }
            if (newEndDate != null && !(newEndDate.equals(""))) {
                removeED = newEndDate.replace("T", " ");
                qm.setQuizAttributeValue("end_date", Timestamp.valueOf(removeED + ":00"), id);
            }
            if (newHours != null && !(newHours.equals(""))) {
                qm.setQuizAttributeValue("HOURS", newHours, id);
            }
            if (newMinutes != null && !(newMinutes.equals(""))) {
                qm.setQuizAttributeValue("MINUTES", newMinutes, id);
            }


        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/ManageQuiz.jsp").forward(request, response);

    }

    public static void main(String[] args) {
        QuizManagerdao qd = new QuizManagerdao();
        //qd.deleteQuiz(9);
        qd.setQuizAttributeValue("quiz_name", "good game", 5);
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
