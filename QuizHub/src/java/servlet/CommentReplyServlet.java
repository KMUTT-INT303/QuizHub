/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;
import controllers.CommentReplydao;
import model.Quizzes;
import model.Reply;
import model.Student;
import model.Teacher;

/**
 *
 * @author MaxPong
 */
public class CommentReplyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Student ex = new Student(61130500068l, "max", "pong", "1234", 1313, 7777);
//        request.getSession().setAttribute("user",ex);
        Long id = -1l;
        int quizId = -1;
        
//        String mode = request.getParameter("mode");
//        if (mode.equals("getComment")){
//            
//            return;
//        }
        
        if(request.getSession().getAttribute("user") instanceof Student){
        Student s = ((Student) (request.getSession().getAttribute("user")));
        id = s.getId();
        
        }else if(request.getSession().getAttribute("user") instanceof Teacher){
        Teacher t = ((Teacher) (request.getSession().getAttribute("user")));
        id= t.getId();
        }
        //int currentQuizId  = (int)(request.getSession().getAttribute("currentQuizId"));
        int currentQuizId  = Integer.valueOf((String)(request.getParameter("currentQuizId")));
        
//int currentQuizId=-1;
        if ((request.getSession().getAttribute("currentQuizId")) != null) {
            currentQuizId = ((int) (request.getSession().getAttribute("currentQuizId")));
        }
        
        String deleteComment = request.getParameter("deleteComment");
        String deleteReply = request.getParameter("deleteReply");
        String commentText = request.getParameter("comment");
        String replyText = request.getParameter("reply");

        //Insert comment or reply part
        if (commentText != null&&!commentText.equals("")) {
            CommentReplydao crd = new CommentReplydao();
            Comment c = new Comment(commentText,id, currentQuizId);
            

            crd.addComment(c);
        }

        if (replyText != null&&!replyText.equals("")) {
            CommentReplydao crd = new CommentReplydao();
            Reply r = new Reply(replyText,id, Integer.valueOf(request.getParameter("commentTarget")));
            //Reply r = new Reply(replyText, ((Student) (request.getSession().getAttribute("user"))).getStudent_id(),1);
            
            crd.addReply(r);
        }
        
        //delete comment or reply 
        if(deleteReply!=null||deleteComment!=null){
        if(deleteComment!=null){
        CommentReplydao crd = new CommentReplydao();
        crd.deleteComment(Integer.valueOf(deleteComment));
        }else{
        CommentReplydao crd = new CommentReplydao();
        crd.deleteReply(Integer.valueOf(deleteReply));
        }
        
        }

//get list of comment and reply part and set Attribute
        CommentReplydao comments = new CommentReplydao();

        if (comments.getAllCommentByQuizId(currentQuizId) != null) {
            request.setAttribute("CommentList", comments.getAllCommentByQuizId(currentQuizId));
        }
        request.setAttribute("currentQuizId",currentQuizId);
      //  response.sendRedirect(mode); //it will use get method
        //request.getServletContext().getRequestDispatcher("/ShowAnswer").forward(request, response); //it will use post get method
        
        response.sendRedirect("ShowAnswer?currentQuizId=" + currentQuizId);
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
}
