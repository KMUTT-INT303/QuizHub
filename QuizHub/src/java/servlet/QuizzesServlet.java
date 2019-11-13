/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Quizdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Quizzes;
import model.Student;
import model.Teacher;

/**
 *
 * @author tsch
 */
public class QuizzesServlet extends HttpServlet {

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

        if (request.getParameterMap().containsKey("page")) {
            String page = request.getParameter("page");
            if (page.trim().isEmpty()) {
                this.ListQuizByBranch(request);
                String path = "/WEB-INF/Quizzes.jsp";
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }

            getServletContext().getRequestDispatcher("/WEB-INF/QuizPage.jsp").forward(request, response);

        }
    }

    private void ListQuiz(HttpServletRequest request) {
        Quizdao qdao = new Quizdao();
        ArrayList<Quizzes> quizzes = qdao.ListAllQuiz();
        request.setAttribute("quizzes", quizzes);
    }

    private void ListQuizByBranch(HttpServletRequest request) {
        Quizdao qdao = new Quizdao();
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user instanceof Student) {
            Student s = (Student) user;
            ArrayList<Quizzes> quizzes = qdao.ListAllQuizByBranch(s.getBranch_id());
            request.setAttribute("quizzes", quizzes);
        }
        if (user instanceof Teacher) {
            Teacher t = (Teacher) user;
            ArrayList<Quizzes> quizzes = qdao.ListAllQuizByFaculty(t.getFaculty_id());
            request.setAttribute("quizzes", quizzes);
        }
        if (user instanceof Admin) {
            ArrayList<Quizzes> quizzes = qdao.ListAllQuiz();
            request.setAttribute("quizzes", quizzes);
        }

        if (user == null) {
            ArrayList<Quizzes> quizzes = qdao.ListAllQuiz();
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
