/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;

/**
 *
 * @author Top
 */
public class ActiveUserSystemServlet extends HttpServlet {

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
        String path = "/WEB-INF/ActiveUserSystem.jsp";
        String teacher_id = request.getParameter("teacher_id");
        String forwhat = request.getParameter("for");
        if(teacher_id == null || teacher_id.isEmpty() || forwhat == null || forwhat.trim().isEmpty()){
            this.ListTeacher(request);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }
        
        Long tid = Long.valueOf(teacher_id);
        Teacherdao tdao = new Teacherdao();
        Teacher t = tdao.getTeacherById(tid);
        if(forwhat.equals("active")){
            if(t != null){
                if(t.getAccount_status().equals("active")){
                    msg = "This Account is Actived.";
                    request.setAttribute("msg", msg);
                    this.ListTeacher(request);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }

                if(t.getAccount_status().equals("pending")){
                    tdao.setTeacherToActive(t);
                    msg = "Active Successful!";
                    request.setAttribute("msg", msg);
                    this.ListTeacher(request);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }else{
                msg = "No this User!";
                request.setAttribute("msg", msg);
                this.ListTeacher(request);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }
        if(forwhat.equals("pending")){
            if(t != null){
                if(t.getAccount_status().equals("pending")){
                    msg = "This Account is waiting for Active.";
                    request.setAttribute("msg", msg);
                    this.ListTeacher(request);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }

                if(t.getAccount_status().equals("active")){
                    tdao.setTeacherToPending(t);
                    msg = "Set to Pending Successful!";
                    request.setAttribute("msg", msg);
                    this.ListTeacher(request);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }else{
                msg = "No this User!";
                request.setAttribute("msg", msg);
                this.ListTeacher(request);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }
        /*if(t != null){
            if(t.getAccount_status().equals("active")){
                msg = "This Account is Actived.";
                request.setAttribute("msg", msg);
                this.ListTeacher(request);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }

            if(t.getAccount_status().equals("pending")){
                tdao.setTeacherToActive(t);
                msg = "Active Successful!";
                request.setAttribute("msg", msg);
                this.ListTeacher(request);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }else{
            msg = "No this User!";
            request.setAttribute("msg", msg);
            this.ListTeacher(request);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }*/
    }
    
        private void ListTeacher(HttpServletRequest request){
        Teacherdao tdao = new Teacherdao();
        ArrayList<Teacher> teachersActive = tdao.getAllTeacherActive();
        request.setAttribute("teachers_active", teachersActive);
        ArrayList<Teacher> teachersPending = tdao.getAllTeacherPending();
        request.setAttribute("teachers_pending", teachersPending);
    }
        private void ListTeacherActive(HttpServletRequest request){
        Teacherdao tdao = new Teacherdao();
        ArrayList<Teacher> teachersActive = tdao.getAllTeacherActive();
        request.setAttribute("teachers_active", teachersActive);
        }
    
    private void ListTeacherPending(HttpServletRequest request){
        Teacherdao tdao = new Teacherdao();
        ArrayList<Teacher> teachersPending = tdao.getAllTeacherPending();
        request.setAttribute("teachers_pending", teachersPending);
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
