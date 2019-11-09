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
import model.Admin;
import controllers.Admindao;
import model.Student;
import model.Teacher;

/**
 *
 * @author tsch
 */
public class LoginServlet extends HttpServlet {

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
       String username = request.getParameter("username");
        String password = request.getParameter("password");
        String path = "/Login.jsp";
        String msg = "";
        
        for (char c : username.toCharArray()) {
            if (!Character.isDigit(c)) {
            msg = "Your username cannot be text.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
            return;
            }
        } 
        
        if(username.trim().isEmpty() || password.trim().isEmpty()){
            msg = "Your username or password are incorrect.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }
        
        long usernameToLong = Long.valueOf(username);  
        
        Studentdao sdao = new Studentdao();
        Student s = sdao.getStudentById(usernameToLong);
            
        if(s != null){
            if(s.getPassword().equals(password)){
                    request.getSession().setAttribute("user", s);
                    request.getSession().setAttribute("status", "Student");
                    response.sendRedirect("Home");
                    return;
            }else{
                msg = "Your username or password are incorrect.";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);  
                return;
            }
        }else{
            Teacherdao tdao = new Teacherdao();
            Teacher t = tdao.getTeacherById(usernameToLong);
            
            if(t != null){
                if(t.getPassword().equals(password)){
                    request.getSession().setAttribute("user", t);
                    request.getSession().setAttribute("status", "Teacher");
                    response.sendRedirect("Home");
                    return;
                }else{
                    msg = "Your username or password are incorrect.";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }else{
                Admindao adao = new Admindao();
                Admin a = adao.getAdminById(usernameToLong);
                if(a.getPassword().equals(password)){
                    request.getSession().setAttribute("user", a);
                    request.getSession().setAttribute("status", "Admin");
                    response.sendRedirect("Home");
                    return;
                }else{
                    msg = "Your username or password are incorrect.";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }
            
        }
        msg = "Your username or password are incorrect.";
        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher(path).forward(request, response);
       
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
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
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
