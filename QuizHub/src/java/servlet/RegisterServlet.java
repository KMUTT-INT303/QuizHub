/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Branchdao;
import controllers.Facultydao;
import controllers.Studentdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Branch;
import model.Faculty;
import model.Student;

/**
 *
 * @author tsch
 */
public class RegisterServlet extends HttpServlet {

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
        
        String student_id = request.getParameter("student_id");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String faculty_id = request.getParameter("faculty");
        String brach_id = request.getParameter("branch");
        String checkForm = request.getParameter("FROM_REGISTER");

        if(student_id.trim().isEmpty() || password.trim().isEmpty() || fname.trim().isEmpty() || lname.trim().isEmpty() 
                || faculty_id.trim().isEmpty() || brach_id.trim().isEmpty()){
            msg = "You must to input all information";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }
        
        if(checkForm == null || !checkForm.equals("REGISTER_STUDENT")){
            msg = "Something wrong. Plase try again later!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }
        
        
        String bidFromPara = null;
        if(brach_id.length() > 0){
            for(int i =0; i < brach_id.length();i++){
                char j = brach_id.charAt(i);
                if(j == '-'){
                    bidFromPara = brach_id.substring(i+1);
                }
            }
        }
        
        if(student_id.length() < 10){
            msg = "Wrong format of Student ID.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }
        
       for (char c : student_id.toCharArray()) {
            if (!Character.isDigit(c)) {
                msg = "Student ID cannot be text.";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
                return;
            }
        }
        
        
        long sid = Long.valueOf(student_id);      
        int fid = Integer.valueOf(faculty_id);
        int bid = Integer.valueOf(bidFromPara);
        
        if(fid <= 0){
            msg = "Please select your faculty.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }
        
        Studentdao sdao = new Studentdao();
        Student s = sdao.getStudentById(sid);
        Student regStudent = new Student(sid, fname, lname, password, fid, bid);
        
        if(s != null){
            if(s.getId() == sid){
                msg = "You student id has Registered.";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
                return;
            }else{
                sdao.addStudent(regStudent);
                msg = "Register successful.";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
            }
        }else{
            sdao.addStudent(regStudent);
            msg = "Register successful.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
        
        //request.getRequestDispatcher("/Register.jsp").forward(request, response);
        
        
       //request.getRequestDispatcher("/Register.jsp").forward(request, response);
     
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
