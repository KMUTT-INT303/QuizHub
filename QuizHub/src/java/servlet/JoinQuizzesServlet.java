/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Quizdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quizzes;

/**
 *
 * @author tsch
 */
public class JoinQuizzesServlet extends HttpServlet {

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

        String code = request.getParameter("code");

        if (code.trim().isEmpty() || code == null) {
            request.setAttribute("jerror", "Please enter a quizzes code.");
            getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
            getServletContext().getRequestDispatcher("/WEB-INF/Quizzes.jsp").forward(request, response);
        } else {

            Quizdao dq = new Quizdao();
            Quizzes q = dq.findQuizzesByCode(code);

            if (q == null) {
                request.setAttribute("jerror", "Invalid quizzes code.");
                getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/Quizzes.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                response.sendRedirect("Quizzes?p=" + q.getPage());
            }
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
