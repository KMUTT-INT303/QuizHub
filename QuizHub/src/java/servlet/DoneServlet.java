/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.ChoiceResultDao;
import controllers.Choicedao;
import controllers.Questiondao;
import controllers.Resultdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Choice;
import model.ChoiceResult;
import model.Question;
import model.Result;

/**
 *
 * @author tsch
 */
public class DoneServlet extends HttpServlet {

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

        long student_id = Long.valueOf(request.getParameter("student_id"));
        int totalChoice = Integer.valueOf(request.getParameter("count"));
        int totalQuestion = Integer.valueOf(request.getParameter("countq"));
        int quiz_id = Integer.valueOf(request.getParameter("quiz_id"));
        String isPractice = request.getParameter("ispractice");

        PrintWriter out = response.getWriter();

        //out.print(student_id + " ");
        //out.print(totalChoice + " " );
        //out.print(quiz_id + " " );
        ArrayList<String> results = new ArrayList();
        for (int i = 0; i < totalChoice; i++) {
            String result = request.getParameter("result" + i);
            if (result != null) {
                results.add(result);
            }
        }

        //String[] result = request.getParameterValues("result");
        int score = 0;
        int totalCorrect = 0;
        int totalIncorrect = 0;
        int missingChoice = 0;
        missingChoice = totalQuestion - results.size();

        Choicedao cdao = new Choicedao();
        Choice c = new Choice();

        ChoiceResultDao crdao = new ChoiceResultDao();
        ChoiceResult cr = new ChoiceResult();

        ArrayList<Choice> cs = cdao.getAllChoiceByQuizId(Integer.valueOf(quiz_id));
        ArrayList<Integer> choiceNotChoose = new ArrayList();
        ArrayList<Choice> choiceChoose = new ArrayList();
        for (int i = 0; i < results.size(); i++) {
            Choice cadd = cdao.findChoiceById(Integer.valueOf(results.get(i)));
            choiceChoose.add(cadd);
        }
        for (int i = 0; i < cs.size(); i++) {
            for (int j = 0; j < choiceChoose.size(); j++) {
                if (!(cs.get(i).getChoiceId() == choiceChoose.get(j).getChoiceId())) {
                    choiceNotChoose.add(cs.get(i).getChoiceId());
                }
            }
        }

        for (int i = 0; i < results.size(); i++) {

            c = cdao.findChoiceById(Integer.valueOf(results.get(i)));

            if (c.isChoiceCorrect().equals("true")) {
                score++;
                totalCorrect++;
            } else {
                totalIncorrect++;
            }

            if (!isPractice.equals("true")) {

                cr.setQuiz_id(quiz_id);
                cr.setQuestion_id(c.getQuestionId());
                cr.setChoice_id(c.getChoiceId());
                cr.setStudent_id(student_id);

                crdao.createChoiceResult(cr);
            }
        }

        Questiondao qdao = new Questiondao();
        ArrayList<Question> qm = qdao.getAllQuestionByQuizId(quiz_id);
        int count = qm.size();
        for (int i = 0; i < missingChoice; i++) {

            System.out.println(missingChoice);

            // Questiondao qdao = new Questiondao();
            // ArrayList<Question> qm = qdao.getAllQuestionByQuizId(quiz_id);
            for (int x = 0; x < count; x++) {
                if (qm.get(x).getQuestionId() != c.getQuestionId()) {

                    Choice ic = cdao.findIncorrectChoiceByQuestion(qm.get(x).getQuestionId());

                    cr.setQuiz_id(quiz_id);
                    cr.setQuestion_id(ic.getQuestionId());
                    cr.setChoice_id(ic.getChoiceId());
                    cr.setStudent_id(student_id);

                    crdao.createChoiceResult(cr);

                }
            }

            count = 0;

        }

        Resultdao rdao = new Resultdao();
        Result r = new Result();

        r = rdao.findResultByQuizId(quiz_id);

        if (r
                != null) {

            r.setTotal_time("");
            r.setTotalCorrect(totalCorrect);
            r.setTotalIncorrect(totalIncorrect);
            r.setQuizId(quiz_id);
            r.setStudentId(student_id);
            r.setResult_id(r.getResult_id());

            rdao.updateResult(r);
        }

        HttpSession session = request.getSession();

        session.setAttribute("score", score);
        session.setAttribute("totalcorrect", totalCorrect);
        session.setAttribute("totalincorrect", totalIncorrect);

        //request.getRequestDispatcher("/WEB-INF/Score.jsp").forward(request, response);
        response.sendRedirect("Score");
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
