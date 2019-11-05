/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Studentdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author Top
 */
public class StudentManagementServlet extends HttpServlet {

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
        if(request.getParameter("student_id") == null || request.getParameter("student_id").isEmpty()){
            String findbydesc = request.getParameter("findbydescription"); 
            if(!(findbydesc == null || findbydesc.trim().isEmpty())){
                if(findbydesc.trim().equals(msg)){
                    msg = "input values.";
                    request.setAttribute("msg", msg);
                    this.setStudentList(request);
                    getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
            }else{
                    Studentdao sdao = new Studentdao();
                    ArrayList<Student> students = sdao.getAllStudentLike(findbydesc);
                    if(!students.isEmpty()){
                        request.setAttribute("studentsbydes", students);
                        this.setStudentList(request);
                        getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
                    }else{
                        msg = "NO ONE MATCH.";
                        request.setAttribute("msg", msg);
                        this.setStudentList(request);
                        getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
                    }
                }
            }
            this.setStudentList(request);
            getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
            
        }else{
            long sid = Long.valueOf(request.getParameter("student_id"));
            Studentdao sdao = new Studentdao();
            Student s = sdao.getStudentById(sid);
            if(s != null){
                sdao.removeStudentById(s.getStudent_id());
                msg = "Remove successful!";
                request.setAttribute("msg", msg);
                this.setStudentList(request);
                getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
            }
            this.setStudentList(request);
            getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
        }
        
        this.setStudentList(request);
        msg = "";
        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
        
    }

    private void setStudentList(HttpServletRequest request){
        Studentdao sdao = new Studentdao();
        ArrayList<Student> students = sdao.getAllStudent();
        request.setAttribute("students", students);
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
