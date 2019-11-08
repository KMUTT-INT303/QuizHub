/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Studentdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author Top
 */
public class ManageAccountForStudentServlet extends HttpServlet {

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
        String msg = "";
        String path = "/WEB-INF/ManageAccount.jsp";
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        
        if(fname.trim().isEmpty() || lname.trim().isEmpty()){
            msg = "input all values.";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
            return;
        }
        
        Student s = (Student) request.getSession().getAttribute("user");
        Studentdao sdao = new Studentdao();
        Student sinDB = sdao.getStudentById(s.getId());
        
        if(s.getId() == sinDB.getId()){
            if(fname.length() > 0 && lname.length() > 0){
                s.setFirstName(fname.trim());
                s.setLastName(lname.trim());
                sdao.editStudentInfo(s);
                msg = "successful.";
                request.setAttribute("msg", msg);
                response.sendRedirect("/QuizHub/ManageAccountForStudent");
                return;
            }
            //getServletContext().getRequestDispatcher(path).forward(request, response);
        }else{
            msg = "cannot change";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
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
       // processRequest(request, response);
       getServletContext().getRequestDispatcher("/WEB-INF/ManageAccount.jsp").forward(request, response);
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
