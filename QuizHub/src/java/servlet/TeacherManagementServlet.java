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
import model.Admin;
import model.Teacher;

/**
 *
 * @author Top
 */
public class TeacherManagementServlet extends HttpServlet {

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
        
        if(!(request.getSession().getAttribute("user") instanceof Admin)){
            response.sendRedirect("Home");
            return;
            //getServletContext().getRequestDispatcher("/WEB-INF/StudentManagement.jsp").forward(request, response);
        }
        
            String[] id = request.getParameterValues("delete_id");
            if(id != null){
                ArrayList<String> ids = new ArrayList();
                for(int i = 0; i < id.length; i++){
                    String s = id[i];
                    ids.add(s);
                }
                for(int i = 0; i < ids.size() ; i++){
                    Teacherdao tdao = new Teacherdao();
                    Teacher t = tdao.getTeacherById(Long.valueOf(ids.get(i)));
                    if(t != null){
                        tdao.RemoveTeacherById(Long.valueOf(ids.get(i)));
                    }
                }
                
                while(!ids.isEmpty()){
                    ids.clear();
                }
                
                    msg = "REMOVE SUCCESSFUL!";
                    request.setAttribute("msg", msg);
                    this.setTeacherList(request);
                    getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
                   // response.sendRedirect("TeacherManagement");
                    return;
                
            }
            
        
        if(request.getParameter("teacher_id") == null || request.getParameter("teacher_id").isEmpty()){
            String findbydesc = request.getParameter("findbydescription"); 
            if(!(findbydesc == null || findbydesc.trim().isEmpty())){
                if(findbydesc.trim().equals(msg)){
                    msg = "input values.";
                    request.setAttribute("msg", msg);
                    this.setTeacherList(request);
                    getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
                }else{
                    Teacherdao tdao = new Teacherdao();
                    ArrayList<Teacher> teachers = tdao.getAllTeacherLike(findbydesc);
                    if(!teachers.isEmpty()){
                        request.setAttribute("teachersbydes", teachers);
                        this.setTeacherList(request);
                        getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
                        return;
                    }else{
                        msg = "NO ONE MATCH.";
                        request.setAttribute("msg", msg);
                        this.setTeacherList(request);
                        getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
                    }
                }
            }
            this.setTeacherList(request);
            getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
            
        }else{
            long tid = Long.valueOf(request.getParameter("teacher_id"));
            Teacherdao tdao = new Teacherdao();
            Teacher t = tdao.getTeacherById(tid);
            if(t != null){
                tdao.RemoveTeacherById(t.getId());
                msg = "Remove successful!";
                request.setAttribute("msg", msg);
                this.setTeacherList(request);
                getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
            }
            msg = "No Teacher!";
            request.setAttribute("msg", msg);
            this.setTeacherList(request);
            getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
        }
        
        this.setTeacherList(request);
        msg = "";
        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher("/WEB-INF/TeacherManagement.jsp").forward(request, response);
        
    }

    private void setTeacherList(HttpServletRequest request){
        Teacherdao tdao = new Teacherdao();
        ArrayList<Teacher> teachers = tdao.getAllTeacher();
        request.setAttribute("teachers", teachers);
        
    
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
