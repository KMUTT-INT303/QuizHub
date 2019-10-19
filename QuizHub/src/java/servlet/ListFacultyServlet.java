/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Branchdao;
import controllers.Facultydao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Branch;
import model.Faculty;

/**
 *
 * @author Top
 */
public class ListFacultyServlet extends HttpServlet {

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
                
        this.setFacultyAttribute(request, response);
        this.setBranchAttribute(request, response);
        response.sendRedirect("/Register.jsp");

    }
    private void setFacultyAttribute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Facultydao fdao = new Facultydao();
        ArrayList<Faculty> faculties = new ArrayList();
        faculties = fdao.getAllFaculty();
        request.setAttribute("faculties", faculties);
        
    }
    
    private void setBranchAttribute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Branchdao bdao = new Branchdao();
        Facultydao fdao = new Facultydao();
        ArrayList<Branch> branch = bdao.getAllBranch();
        request.setAttribute("branch", branch);
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
