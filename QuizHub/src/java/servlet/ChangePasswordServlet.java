/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.Admindao;
import controllers.Studentdao;
import controllers.Teacherdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;
import model.Student;
import model.Teacher;

/**
 *
 * @author Top
 */
public class ChangePasswordServlet extends HttpServlet {

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
        String opass = request.getParameter("opass");
        String npass = request.getParameter("npass");
        String cpass = request.getParameter("cpass");

        if (opass.trim().isEmpty() || npass.trim().isEmpty() || cpass.trim().isEmpty()) {
            msg = "input all password values.";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);
        }

        if (request.getSession().getAttribute("user") instanceof Student) {
            Student s = (Student) request.getSession().getAttribute("user");
            if (s.getPassword().equals(opass)) {
                if (npass.equals(opass)) {
                    msg = "New Password Shouldn't same as Old Password!";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                } else {
                    if (!npass.equals(cpass)) {
                        msg = "Wrong Confirm password!";
                        request.setAttribute("msg", msg);
                        getServletContext().getRequestDispatcher(path).forward(request, response);
                    } else {
                        Studentdao sdao = new Studentdao();
                        Student sinDB = sdao.getStudentById(s.getId());
                        if (sinDB.getId() == s.getId()) {
                            s.setPassword(npass);
                            sdao.editStudentInfo(s);
                            msg = "change password successful.";
                            request.setAttribute("msg", msg);
                            //response.sendRedirect("/QuizHub/ChangePassword");
                            getServletContext().getRequestDispatcher(path).forward(request, response);
                            return;

                        } else {
                            msg = "Cannot change";
                            request.setAttribute("msg", msg);
                            getServletContext().getRequestDispatcher(path).forward(request, response);
                        }
                    }
                }
            } else {
                msg = "Wrong Old Password!";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }

        } else if (request.getSession().getAttribute("user") instanceof Teacher) {
            Teacher t = (Teacher) request.getSession().getAttribute("user");
            if (t.getPassword().equals(opass)) {
                if (npass.equals(opass)) {
                    msg = "New Password Shouldn't same as Old Password!";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                } else {
                    if (!npass.equals(cpass)) {
                        msg = "Wrong Confirm password!";
                        request.setAttribute("msg", msg);
                        getServletContext().getRequestDispatcher(path).forward(request, response);
                    } else {
                        Teacherdao tdao = new Teacherdao();
                        Teacher tinDB = tdao.getTeacherById(t.getId());
                        if (tinDB.getId() == t.getId()) {
                            t.setPassword(npass);
                            tdao.editTeacher(t);
                            msg = "change password successful.";
                            request.setAttribute("msg", msg);
                            //response.sendRedirect("/QuizHub/ChangePassword");
                            getServletContext().getRequestDispatcher(path).forward(request, response);
                            return;
                        } else {
                            msg = "Cannot change";
                            request.setAttribute("msg", msg);
                            getServletContext().getRequestDispatcher(path).forward(request, response);
                        }
                    }
                }
            } else {
                msg = "Wrong Old Password!";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
            
        } else if (request.getSession().getAttribute("user") instanceof Admin) {
            Admin a = (Admin) request.getSession().getAttribute("user");
            if (a.getPassword().equals(opass)) {
                if (npass.equals(opass)) {
                    msg = "New Password Shouldn't same as Old Password!";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher(path).forward(request, response);
                } else {
                    if (!npass.equals(cpass)) {
                        msg = "Wrong Confirm password!";
                        request.setAttribute("msg", msg);
                        getServletContext().getRequestDispatcher(path).forward(request, response);
                    } else {
                        Admindao adao = new Admindao();
                        Admin ainDB = adao.getAdminById(a.getId());
                        if (ainDB.getId() == a.getId()) {
                            a.setPassword(npass);
                            adao.editPassword(a);
                            msg = "change password successful.";
                            request.setAttribute("msg", msg);
                            //response.sendRedirect("/QuizHub/ChangePassword");
                            getServletContext().getRequestDispatcher(path).forward(request, response);
                            return;
                        } else {
                            msg = "Cannot change";
                            request.setAttribute("msg", msg);
                            getServletContext().getRequestDispatcher(path).forward(request, response);
                        }
                    }
                }
            } else {
                msg = "Wrong Old Password!";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        } else {
            msg = "Have a BUG!";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher(path).forward(request, response);

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
        //processRequest(request, response);
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
