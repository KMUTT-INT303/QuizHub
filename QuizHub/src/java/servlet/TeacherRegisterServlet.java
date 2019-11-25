/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Studentdao;
import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
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
        String mail = request.getParameter("email");
        String submail = request.getParameter("submail");
        String checkForm = request.getParameter("FROM_REGISTER");
        String path = "/WEB-INF/Register.jsp";
        
        if(id.trim().isEmpty() || firstName.trim().isEmpty() || lastName.trim().isEmpty() || password.trim().isEmpty() || faculty_id.trim().isEmpty() || mail.trim().isEmpty() || submail.trim().isEmpty()){
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
        
        if(id.length() < 8){
            msg = "Wrong format of Teacher ID.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }
        
        if(!submail.equals("@kmutt.ac.th")){
            msg = "Plz , select mail address.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
        } 
        
        int fid = Integer.valueOf(faculty_id);
        if(fid <= 0){
            msg = "Please select your faculty.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }
        
        String email = mail.trim() + submail;
        Long tid = Long.valueOf(id);
        Teacherdao tdao = new Teacherdao();
        Teacher t = tdao.getTeacherById(tid);
        Teacher registerTeacher = new Teacher(tid, firstName, lastName, password, fid, email);
        if(t != null){
            msg = "This account have registed!";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }else{
            
            Studentdao sdao = new Studentdao();
            Student s = sdao.getStudentById(tid);
            if(s!=null){
                msg = "You must to use your Teacher ID.";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
            
            Teacher tmail = tdao.getTeacherByMail(email);
            if(tmail != null){
                msg = "This email has registed!";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }else{ 
                tdao.addTeacher(registerTeacher);
                msg = "Register successful.";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
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
        //processRequest(request, response);
        request.getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
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
