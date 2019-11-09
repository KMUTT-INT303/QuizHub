/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Coursedao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Student;
import model.Teacher;

/**
 *
 * @author Top
 */
public class CreateCourseServlet extends HttpServlet {

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
        String path = "/WEB-INF/CreateCourse.jsp";
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String msg = null;
        
        if(!(request.getSession().getAttribute("user") instanceof Teacher)){
            response.sendRedirect("Quizzes");
            return;
        }
        
        if(id.trim().isEmpty() || name.trim().isEmpty()){
            msg = "must to input all values";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
        }
        
        Teacher t = (Teacher) request.getSession().getAttribute("user");
        Coursedao cdao = new Coursedao();
        Course c = new Course(id, name, t);
        Course cinDB = cdao.getCourseById(id);
        if(cinDB == null){
            cdao.addCourse(c);
            msg = "add successful!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }else{
            msg = "This course id have in Server! Try other id.";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }
        
        /*msg = "Cannot create course.";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher(path).forward(request, response);*/
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
        request.getRequestDispatcher("/WEB-INF/CreateCourse.jsp").forward(request, response);
        //processRequest(request, response);
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
