/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.AuthenEmailController;
import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AuthenEmail;
import model.MailSet;
import model.Teacher;

/**
 *
 * @author Top
 */
public class AuthenticationByEmailServlet extends HttpServlet {

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
        String page = request.getParameter("page");
        String AuthenCode = null;
    
        
        
        if (page.equals("ACTIVE")) {
            String path = "/WEB-INF/ActiveByCode.jsp";
            String mailcode = request.getParameter("MailCode");
            if(request.getSession().getAttribute("idteacher") == null){
                response.sendRedirect("Login");
                return;
            }
            if (!mailcode.trim().isEmpty()) {
                AuthenEmailController aec = new AuthenEmailController();
                Teacherdao tdao = new Teacherdao();
                Teacher t = tdao.getTeacherById((Long)request.getSession().getAttribute("idteacher"));
                if(t != null){
                    AuthenEmail ae = aec.getAuthenByTeacherId(t.getId());
                    if(mailcode.equals(ae.getCode())){
                        tdao.setTeacherToActive(t);
                        aec.deleteCodeByTeacher(t.getId());
                        request.getSession().removeAttribute("idteacher");
                        response.sendRedirect("Login");
                        return;
                    }else{
                        msg = "Your code wrong!";
                        request.setAttribute("msg", msg);
                        getServletContext().getRequestDispatcher(path).forward(request, response);
                    }
                }
                
                msg = "Some thing wrong!";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }else{
                msg = "ENTER THE CODE TO ACTIVE";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
                
            }

        }

        if (page.equals("SENDCODE")) {
            String email = request.getParameter("email");
            String code = request.getParameter("code");
            String path = "/WEB-INF/AuthenticationByEmail.jsp";
            if (email.trim().isEmpty() || code.trim().isEmpty()) {
                msg = "input all";
                request.getSession().setAttribute("authenmsg", msg);
                getServletContext().getRequestDispatcher("/WEB-INF/AuthenticationByEmail.jsp").forward(request, response);
            }
            
            if(!code.equals(request.getSession().getAttribute("gencode"))){
                msg = "plz, correct the code!";
                request.getSession().setAttribute("authenmsg", msg);
                response.sendRedirect("AuthenticationByEmail");
                return;
            }
            
            Teacherdao tdao = new Teacherdao();
            Teacher t = tdao.getTeacherByMail(email);
            
            if(t == null){
                msg = "maybe you don't register";
                request.getSession().setAttribute("authenmsg", msg);
                response.sendRedirect("AuthenticationByEmail");
                return;
            }
            
            if(t.getAccount_status().equals("active")){
                msg = "Your account is actived.";
                //request.getSession().removeAttribute("authenmsg");
                request.getSession().setAttribute("authenmsg", msg);
                response.sendRedirect("AuthenticationByEmail");
                return;
            }
            
            request.getSession().setAttribute("idteacher", t.getId());
            AuthenEmailController aec = new AuthenEmailController();
            
            long current_time = System.currentTimeMillis();
            DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            Date time = new Date(current_time);
            Timestamp this_time = Timestamp.valueOf(simple.format(time));
            
            AuthenEmail ae = aec.getAuthenByTeacherId(t.getId());
            
            if(ae != null){
                ae.setCode(this.genCodeAuthentication());
                aec.updateAuthenCode(ae);
                MailSet ms = new MailSet("Active Code");
                ms.setMail(t.getFullname(), "ACTIVE CODE IS: " + ae.getCode() + "\n the code will stay for 30 minutes", email);
                ms.sendMail();
                msg = "Enter Code to Active";
                request.getSession().removeAttribute("authenmsg");
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher("/WEB-INF/ActiveByCode.jsp").forward(request, response);
                return;
            }
            
            AuthenCode = this.genCodeAuthentication();
            AuthenEmail newae = new AuthenEmail(AuthenCode, t.getId(), this_time);
            aec.addNewAuthen(newae);
            MailSet ms = new MailSet("Active Code");
            ms.setMail(t.getFullname(), "ACTIVE CODE IS: " + AuthenCode + "\n the code will stay for 30 minutes", email);
            ms.sendMail();
            request.getSession().removeAttribute("authenmsg");
            msg = "Enter Code to Active";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher("/WEB-INF/ActiveByCode.jsp").forward(request, response);
        }
        
        msg = "Something Wrong!";
        request.setAttribute("authenmsg", msg);
        getServletContext().getRequestDispatcher("/WEB-INF/AuthenticationByEmail.jsp").forward(request, response);

    }
    
    private String genCodeAuthentication() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String code = salt.toString();
        return code;
    }

    private void deleteOlderCode(){
        AuthenEmailController aec = new AuthenEmailController();
        aec.deleteExpiredCode();
    }
    
    private void genCode(HttpServletRequest request) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String code = salt.toString();
        HttpSession session = request.getSession();
        session.setAttribute("gencode", code);
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
        
        if(request.getSession().getAttribute("user") != null){
            response.sendRedirect("Home");
            return;
        }
        //processRequest(request, response);
        this.deleteOlderCode();
        request.getSession().removeAttribute("gencode");
        this.genCode(request);
        getServletContext().getRequestDispatcher("/WEB-INF/AuthenticationByEmail.jsp").forward(request, response);
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
