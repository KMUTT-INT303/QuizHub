/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Admindao;
import controllers.Branchdao;
import controllers.Facultydao;
import controllers.Studentdao;
import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Branch;
import model.Faculty;
import model.Student;
import model.Teacher;

/**
 *
 * @author Top
 */
public class ProfileServlet extends HttpServlet {

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
        String path = "/WEB-INF/Profile.jsp";
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        
        if(fname.trim().isEmpty() || lname.trim().isEmpty()){
            msg = "input all values.";
            request.setAttribute("ProfileException", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
            return;
        }
        if(request.getSession().getAttribute("user") instanceof Student){
            Student s = (Student) request.getSession().getAttribute("user");
        Studentdao sdao = new Studentdao();
        Student sinDB = sdao.getStudentById(s.getId());
        
            if(s.getId() == sinDB.getId()){
                if(fname.length() >= 3 && lname.length() >= 3){
                    s.setFirstName(fname.trim());
                    s.setLastName(lname.trim());
                    sdao.editStudentInfo(s);
                    msg = "successful.";
                    request.setAttribute("ProfileException", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                    //response.sendRedirect("/QuizHub/ManageAccountForStudent");
                    return;
                }else{
                    msg = "First Name & Last Name must more than 3 character";
                    request.setAttribute("ProfileException", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }else{
                msg = "cannot change";
                request.setAttribute("ProfileException", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }
        else if(request.getSession().getAttribute("user") instanceof Teacher){
            Teacher t =(Teacher) request.getSession().getAttribute("user");
            Teacherdao tdao = new Teacherdao();
            Teacher tinDB = tdao.getTeacherById(t.getId());

            if(t.getId() == tinDB.getId()){
                if(fname.length() >= 3 && lname.length() >= 3){
                    t.setFirstName(fname.trim());
                    t.setLastName(lname.trim());
                    tdao.editTeacher(t);
                    msg = "successful.";
                    request.setAttribute("ProfileException", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                    //response.sendRedirect("/QuizHub/ManageAccountForStudent");
                    return;
                }else{
                    msg = "First Name & Last Name must more than 3 character";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }else{
                msg = "cannot change";
                request.setAttribute("ProfileException", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }
        else if(request.getSession().getAttribute("user") instanceof Admin){
            Admin a =(Admin) request.getSession().getAttribute("user");
            Admindao adao = new Admindao();
            Admin ainDB = adao.getAdminById(a.getId());

            if(a.getId() == ainDB.getId()){
                if(fname.length() >= 3 && lname.length() >= 3){
                    a.setFirstName(fname.trim());
                    a.setLastName(lname.trim());
                    adao.editAdmin(a);
                    msg = "successful.";
                    request.setAttribute("ProfileException", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                    //response.sendRedirect("/QuizHub/ManageAccountForStudent");
                    return;
                }else{
                    msg = "First Name & Last Name must more than 3 character";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }else{
                msg = "cannot change";
                request.setAttribute("ProfileException", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }
        else{
            msg = "cannot change";
            request.setAttribute("ProfileException", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }
    }

    private void FacultyInfo(HttpServletRequest request){
        Object user = request.getSession().getAttribute("user");
        
        Facultydao fdao = new Facultydao();
        Branchdao bdao = new Branchdao();
        
        if(user instanceof Student){
            Student s = (Student) user;
            Faculty f = fdao.getFacultyById(s.getFaculty_id());
            Branch b = bdao.getBranchById(s.getBranch_id());
            request.setAttribute("faculty_profile", f);
            request.setAttribute("branch_profile", b);
        }
        if(user instanceof Teacher){
            Teacher t = (Teacher) user;
            Faculty f = fdao.getFacultyById(t.getFaculty_id());
            request.setAttribute("faculty_profile", f);
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
        this.FacultyInfo(request);
       request.setAttribute("current_page", "profile");
       getServletContext().getRequestDispatcher("/WEB-INF/Profile.jsp").forward(request, response);
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
