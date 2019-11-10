/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Coursedao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Teacher;

/**
 *
 * @author Top
 */
public class ListCourseServlet extends HttpServlet {

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
        //ListCourse(request);
        /*if(request.getSession().getAttribute("user") instanceof Teacher){
            ListCourseByTeacher(request);
            if ("CREATEQUIZ".equalsIgnoreCase(request.getParameter("FROM_CREATE_QUIZ"))) {
                response.sendRedirect("/CreateQuiz.jsp");
                return;
            }
        }*/

        ListCourseByTeacher(request);
        if ("CREATEQUIZ".equalsIgnoreCase(request.getParameter("FROM_CREATE_QUIZ"))) {
            response.sendRedirect("/CreateQuiz.jsp");
            return;
        }

        /*if ("QUIZZES".equalsIgnoreCase(request.getParameter("FROM_QUIZZES"))) {
            response.sendRedirect("/Quizzes.jsp");
            return;
        }*/
        //response.sendRedirect("/CreateQuiz.jsp");
    }

    private void ListCourse(HttpServletRequest request) {

        Coursedao cdao = new Coursedao();
        ArrayList<Course> list = cdao.getAllCourse();
        request.setAttribute("course", list);
    }

    private void ListCourseByTeacher(HttpServletRequest request) {
        Teacher t = (Teacher) request.getSession().getAttribute("user");
        Coursedao cdao = new Coursedao();
        ArrayList<Course> list = cdao.getAllCourseByTeacher(t);
        request.setAttribute("course", list);
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
