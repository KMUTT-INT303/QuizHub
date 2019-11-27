/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Activitiesdao;
import controllers.Branchdao;
import controllers.Facultydao;
import controllers.Quizdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Activities;
import model.Admin;
import model.Branch;
import model.Faculty;
import model.Quizzes;
import model.Student;
import model.Teacher;

/**
 *
 * @author Top
 */
public class HomeServlet extends HttpServlet {

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
        request.setAttribute("current_page", "home");
        getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    private void LastAtivitiesInfo(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");

        Activitiesdao adao = new Activitiesdao();

        if (user instanceof Student) {
            Student s = (Student) user;
            ArrayList<Activities> a = adao.findLastAtivitiesByStudentId(s.getId());
            request.setAttribute("a", a);
        }

        if (user instanceof Teacher) {
            Teacher t = (Teacher) user;
            ArrayList<Activities> a = adao.findLastAtivitiesByTeacherId(t.getId());
            request.setAttribute("a", a);
        }

    }

    private void FacultyInfo(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");

        Facultydao fdao = new Facultydao();
        Branchdao bdao = new Branchdao();

        if (user instanceof Student) {
            Student s = (Student) user;
            Faculty f = fdao.getFacultyById(s.getFaculty_id());
            Branch b = bdao.getBranchById(s.getBranch_id());
            request.setAttribute("faculty_profile", f);
            request.setAttribute("branch_profile", b);
        }
        if (user instanceof Teacher) {
            Teacher t = (Teacher) user;
            Faculty f = fdao.getFacultyById(t.getFaculty_id());
            request.setAttribute("faculty_profile", f);
        }

    }

    private void LatestQuizzes(HttpServletRequest request) {
        Quizdao qdao = new Quizdao();
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user instanceof Student) {
            Student s = (Student) user;
            ArrayList<Quizzes> quizzes = qdao.ListLatestQuizByBranch(s.getBranch_id());
            request.setAttribute("quizzes", quizzes);
        }
        if (user instanceof Teacher) {
            Teacher t = (Teacher) user;
            ArrayList<Quizzes> quizzes = qdao.ListLatestQuizByFaculty(t.getFaculty_id());
            request.setAttribute("quizzes", quizzes);
        }
        if (user instanceof Admin) {
            ArrayList<Quizzes> quizzes = qdao.ListLatestQuiz();
            request.setAttribute("quizzes", quizzes);
        }

        if (user == null) {
            ArrayList<Quizzes> quizzes = qdao.ListLatestQuiz();
            request.setAttribute("quizzes", quizzes);
        }

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
        this.FacultyInfo(request);
        this.LastAtivitiesInfo(request);
        this.LatestQuizzes(request);
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
