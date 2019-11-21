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
public class FacultyManagementServlet extends HttpServlet {

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
        
        String path = "/WEB-INF/FacultyManagement.jsp";
        
        String fid = request.getParameter("id");
        String bid = request.getParameter("bid");
        String edit_faculty = request.getParameter("edit_faculty_name");
        String edit_branch = request.getParameter("edit_branch_name");
        
        if(fid == null || fid.isEmpty()){
            //request.setAttribute("faculty", "SELECT SOME FACULTY");
            //request.setAttribute("branch", "SELECT SOME BRANCH");
            //this.setFacultyAttribute(request, response);
            getServletContext().getRequestDispatcher("/ListFaculty").include(request, response);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }
        
        Facultydao fdao = new Facultydao();
        Faculty f = fdao.getFacultyById(Integer.valueOf(fid));
        if(f != null){
            
            if(edit_faculty != null){
                f.setName(edit_faculty);
                fdao.setFacultyName(f);
                request.setAttribute("msg", "change faculty name successful!");
            }
        
            
            Branchdao bdao = new Branchdao();
            ArrayList<Branch> bs = bdao.getAllBranchInFacultyByFacultyId(f.getId());
            if(bid == null || bid.isEmpty()){
                request.setAttribute("branch", null);
            }else{
                Branch b = bdao.getBranchById(Integer.valueOf(bid));
                request.setAttribute("branch", b);
            }
            request.setAttribute("branchesInfaculty", bs);
            request.setAttribute("faculty", f);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }
        
        /*if(bid == null || bid.isEmpty()){
            request.setAttribute("branch", "SELECT SOME BRANCH");
            getServletContext().getRequestDispatcher("/ListFaculty").include(request, response);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }*/
        
        
        
        
        
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
        //getServletContext().getRequestDispatcher("/WEB-INF/FacultyManagement.jsp").forward(request, response);
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
