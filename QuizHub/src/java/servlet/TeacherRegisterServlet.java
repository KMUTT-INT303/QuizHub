/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;

/**
 *
 * @author Top
 */
public class TeacherRegisterServlet extends HttpServlet {

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
        String msg = null;
        String id = request.getParameter("teacher_id");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String password = request.getParameter("password");
        String faculty_id = request.getParameter("faculty");
        String checkForm = request.getParameter("FROM_REGISTER");
        String path = "/Register.jsp";
        
        if(id.trim().isEmpty() || firstName.trim().isEmpty() || lastName.trim().isEmpty() || password.trim().isEmpty() || faculty_id.trim().isEmpty()){
            msg = "input all information";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        } 
        
        if(checkForm == null || !checkForm.equals("REGISTER_TEACHER")){
            msg = "Something wrong. Plase try again later!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }
        
        int fid = Integer.valueOf(faculty_id);
        if(fid <= 0){
            msg = "Please select your faculty.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }
        
        Long tid = Long.valueOf(id);
        Teacherdao tdao = new Teacherdao();
        Teacher t = tdao.getTeacherById(tid);
        Teacher registerTeacher = new Teacher(tid, firstName, lastName, password, fid);
        if(t != null){
            msg = "This account have registed!";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }else{
            tdao.addTeacher(registerTeacher);
            msg = "Register successful.";
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