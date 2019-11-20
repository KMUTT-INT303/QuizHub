/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.ChoiceResultDao;
import controllers.Choicedao;
import controllers.Resultdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Choice;
import model.ChoiceResult;
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
        int quiz_id = Integer.valueOf(request.getParameter("quiz_id"));
        
        ArrayList<String> results = new ArrayList();
        for(int i = 0; i < totalChoice; i++){
            String result =  request.getParameter("result" + i);
            if(result != null){
                results.add(result);
            }
        }
        
        //String[] result = request.getParameterValues("result");
        
        int score = 0;
        int totalCorrect = 0;
        int totalIncorrect = 0;
        
        Choicedao cdao = new Choicedao();
        Choice c = new Choice();
        
        ChoiceResultDao crdao = new ChoiceResultDao();
        ChoiceResult cr = new ChoiceResult();
        
        
        for(int i = 0; i < results.size(); i++) {
            
            c = cdao.findChoiceById(Integer.valueOf(results.get(i)));
            if(c.isChoiceCorrect().equals("true")) {
                score ++;
                totalCorrect++;
            }
            else
            {
                totalIncorrect++;
            }
            
            cr.setQuiz_id(quiz_id);
            cr.setQuestion_id(c.getQuestionId());
            cr.setChoice_id(c.getChoiceId());
            cr.setStudent_id(student_id);
            
            crdao.createChoiceResult(cr);
            
        }
        
        Resultdao rdao = new Resultdao();
        Result r = new Result();
        
        r = rdao.findResultByQuizId(quiz_id);
        
        r.setTotal_time("");
        r.setTotalCorrect(totalCorrect);
        r.setTotalIncorrect(totalIncorrect);
        r.setQuizId(quiz_id);
        r.setStudentId(student_id);
        r.setResult_id(r.getResult_id());
        
        rdao.updateResult(r);
        
        request.setAttribute("score", score);
        request.setAttribute("totalcorrect", totalCorrect);
        request.setAttribute("totalincorrect", totalIncorrect);
        
        request.getRequestDispatcher("/WEB-INF/Score.jsp").forward(request, response);
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
