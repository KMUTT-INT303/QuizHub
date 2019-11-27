/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Choicedao;
import controllers.Questiondao;
import controllers.Resultdao;
import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Choice;
import model.Question;
import model.Result;
import model.Student;
import model.Teacher;

/**
 *
 * @author tsch
 */
public class StartQuizServlet extends HttpServlet {

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

        String id = request.getParameter("quiz_id");
        String page = request.getParameter("page");
        String ispratice = request.getParameter("ispratice");
        String t_id = request.getParameter("t_id");
        PrintWriter out = response.getWriter();
        
        Teacherdao tdao = new Teacherdao();
        Teacher t = tdao.getTeacherById(Long.valueOf(t_id));

        HttpSession session = request.getSession();
        session.setAttribute("doquiz", "true");
        session.setAttribute("page", page);
        session.setAttribute("teacher", t);
        Student s = (Student) session.getAttribute("user");

        //out.print(ispratice);
        if (ispratice.equals("false")) {

            //out.print("true.");
            Resultdao rdao = new Resultdao();
            Result r = new Result();

            Result student = rdao.findResultByStudentId(s.getId());

            //out.print(r);
            if (student == null) {

                r.setTotal_time("0");
                r.setTotalCorrect(0);
                r.setTotalIncorrect(0);
                r.setQuizId(Integer.valueOf(id));
                r.setStudentId(s.getId());

                rdao.createResult(r);

            }

            if (student != null) {
                if (student.getQuizId() == Integer.valueOf(id)) {

                    out.print("1");

                } else {

                    r.setTotal_time("0");
                    r.setTotalCorrect(0);
                    r.setTotalIncorrect(0);
                    r.setQuizId(Integer.valueOf(id));
                    r.setStudentId(s.getId());

                    rdao.createResult(r);
                }
            }
        }

        //out.print("pratice");
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

        String headerName = request.getHeader("x-requested-with");

        if (null == headerName) {
            response.sendRedirect("Quizzes");
        } else {
            processRequest(request, response);
        }
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

        String headerName = request.getHeader("x-requested-with");

        if (null == headerName) {
            response.sendRedirect("Quizzes");
        } else {
            processRequest(request, response);
        }

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
