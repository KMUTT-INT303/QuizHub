/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Questiondao;
import controllers.QuizManagerdao;
import controllers.Quizdao;
import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import model.Quizzes;
import model.Teacher;

/**
 *
 * @author tsch
 */
public class DeleteQuestionServlet extends HttpServlet {

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

        String headerName = request.getHeader("x-requested-with");
        
        PrintWriter out = response.getWriter();

        if (headerName != null) {
            String q_id = request.getParameter("q_id");
            String t_id = request.getParameter("t_id");
            String q_page = request.getParameter("q_page");

            if (q_id != null || !q_id.trim().isEmpty() && t_id != null || !t_id.trim().isEmpty()) {

                Quizdao quzidao = new Quizdao();
                Quizzes qez = quzidao.findQuizzesByPage(q_page);

                if (qez != null) {

                    Questiondao qdao = new Questiondao();
                    Question question = qdao.getQuestionById(Integer.valueOf(q_id));
                    
                    QuizManagerdao qmdao = new QuizManagerdao();

                    if (question != null) {
                        if (qez.getQuizTeacherId() == Long.valueOf(t_id)) {
                            
                            qmdao.deleteQuestion(Integer.valueOf(q_id));
        
                        }
                    }
                }

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
