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
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MailSet;
import model.Student;
import model.Teacher;

/**
 *
 * @author Top
 */
public class ForgetPasswordServlet extends HttpServlet {

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
        String who = request.getParameter("who");
        String icode = request.getParameter("code");
        String path = "/WEB-INF/ForgetPassword.jsp";
        String msg = null;

        
        request.getSession().removeAttribute("codemsg");
        /*request.getSession().removeAttribute("code");
        this.genCode(request);*/
        
        if(who.trim().isEmpty()){
            request.setAttribute("msg", "Input your E-Mail or ID.");
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }
        
        if(icode == null || icode.trim().isEmpty()){
            request.getSession().setAttribute("codemsg", "Plz, correct the code");
            response.sendRedirect("ForgetPassword");
            return;
        }
        
        if(!request.getSession().getAttribute("code").equals(icode)){
            request.getSession().setAttribute("codemsg", "Plz, correct the code");
            response.sendRedirect("ForgetPassword");
            return;
        }
        
        
        String mailAddress = null;
        MailSet ms = new MailSet();

        for (char c : who.toCharArray()) {
            if (!Character.isDigit(c)) {
                mailAddress = who;
                break;
            }
        }
        
        if(mailAddress != null){
            Studentdao sdao = new Studentdao();
            Student s = sdao.getStudentByMail(mailAddress);
            if(s != null){
                ms.setMail(s.getFullname(), "Your password is " + s.getPassword(), s.getEmail());
                ms.sendMail();
                request.getSession().removeAttribute("code");
                this.genCode(request);
                request.setAttribute("msg", "Check you mail, we send your password to you mail.");
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }else{
                Teacherdao tdao = new Teacherdao();
                Teacher t = tdao.getTeacherByMail(mailAddress);
                if(t != null){
                    ms.setMail(t.getFullname(), "Your password is " + t.getPassword(), t.getEmail());
                    ms.sendMail();
                    request.getSession().removeAttribute("code");
                    this.genCode(request);
                    request.setAttribute("msg", "Check you mail, we send your password to you mail.");
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }else{
                    request.getSession().removeAttribute("code");
                    this.genCode(request);
                    request.setAttribute("msg", "Wrong Email!");
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                }
            }
        }
        
        Long id = Long.valueOf(who);
        Studentdao sdao = new Studentdao();
        Student s = sdao.getStudentById(id);
        if(s != null){
            ms.setMail(s.getFullname(), "Your password is " + s.getPassword(), s.getEmail());
            ms.sendMail();
            request.getSession().removeAttribute("code");
            this.genCode(request);
            request.setAttribute("msg", "Check you mail, we send your password to you mail.");
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }else{
            Teacherdao tdao = new Teacherdao();
            Teacher t = tdao.getTeacherById(id);
            if(t != null){
                ms.setMail(t.getFullname(), "Your password is " + t.getPassword(), t.getEmail());
                ms.sendMail();
                request.getSession().removeAttribute("code");
                this.genCode(request);
                request.setAttribute("msg", "Check you mail, we send your password to you mail.");
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }else{
                request.getSession().removeAttribute("code");
                this.genCode(request);
                request.setAttribute("msg", "Maybe you still have not register.");
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }
    }
    
    private void genCode(HttpServletRequest request){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String code = salt.toString();
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
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
        //request.getSession().removeAttribute("codemsg");
                
        if(request.getSession().getAttribute("user") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/Profile.jsp").forward(request, response);
        }
        request.getSession().removeAttribute("code");
        this.genCode(request);
        getServletContext().getRequestDispatcher("/WEB-INF/ForgetPassword.jsp").forward(request, response);
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
