/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Choicedao;
import controllers.Questiondao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Choice;
import model.Question;

/**
 *
 * @author tsch
 */
public class CreateQuestionServlet extends HttpServlet {

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

        String question = request.getParameter("question");
        String quiz_id = request.getParameter("quiz_id");
        String[] c = request.getParameterValues("choice");
        String page = request.getParameter("page");

        String[] correct = request.getParameterValues("correct");

        Questiondao qdao = new Questiondao();
        Question q = new Question();

        if (question != null || !question.trim().isEmpty()) {

            q.setQuestionName(question);
            q.setQuizId(Integer.valueOf(quiz_id));

            qdao.createQuestion(q);

            ArrayList<Question> qindb = qdao.getAllQuestionByQuizId(Integer.valueOf(quiz_id));

            Choicedao cdao = new Choicedao();
            Choice choice = new Choice();

            int countCorrect = 0;
            int countIncorrect = 0;

            for (int i = 0; i < c.length; i++) {
                choice.setQuizId(Integer.valueOf(quiz_id));
                choice.setChoiceName(c[i]);
                choice.setChoiceCorrect(correct[i].toString());
                if (correct[i].toString().equals("true")) {
                    countCorrect++;
                    if (countCorrect > 1) {
                        request.setAttribute("msg", "You cannot add correct choice more than one.");
                        getServletContext().getRequestDispatcher("Quizzes?p=" + page).forward(request, response);
                    }
                }

                if (correct[i].toString().equals("false")) {
                    countIncorrect++;
                    if (countIncorrect < 1) {
                        request.setAttribute("msg", "You cannot add false at least one choice.");
                        getServletContext().getRequestDispatcher("Quizzes?p=" + page).forward(request, response);
                    }
                }

                for (Question num : qindb) {
                    choice.setQuestionId(Integer.valueOf(num.getQuestionId()));
                }
                cdao.createChoice(choice);
            }

            response.sendRedirect("Quizzes?p=" + page);

            /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            for (int i = 0; i < c.length; i++) {
                out.print(c[i].toLowerCase().toString());
            }

            for (int i = 0; i < c.length; i++) {
                out.print(correct[i].toLowerCase().toString());
            }
            out.print(question);
            out.print(quiz_id);
        }*/
        } else {
            request.setAttribute("msg", "Please insert your question or choices.");
            getServletContext().getRequestDispatcher("Quizzes?p=" + page).forward(request, response);
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
