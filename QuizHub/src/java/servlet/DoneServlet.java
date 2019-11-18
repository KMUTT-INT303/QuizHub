/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Choicedao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Choice;

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

        int totalChoice = Integer.valueOf(request.getParameter("count"));
        
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
        
        Choice c = new Choice();
        Choicedao cdao = new Choicedao();
        
        for(int i = 0; i < results.size(); i++) {
            if(cdao.findCorrectChoiceById(Integer.valueOf(results.get(i))).isChoiceCorrect().equals("true")) {
                score ++;
                totalCorrect++;
                
            }
            else
            {
                totalIncorrect++;
            }
        }
        
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
