/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controllers.CommentReplydao;
import controllers.ShowAnswerdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Choice;
import model.ChoiceResult;
import model.Question;
import model.Quizzes;
import model.Student;
import model.Teacher;

/**
 *
 * @author MaxPong
 */
public class ShowAnswerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("user") instanceof Student){ 
        Student s = (Student)request.getSession().getAttribute("user");
        
        int quizId = Integer.valueOf(request.getParameter("currentQuizId"));
          
//        Student s = new Student(61130500001l,"kao","sodsong","1234",1,2,"kao@mail");
//        int quizId = 1;
        
        
        request.setAttribute("currentQuizId",quizId);
        request.getSession().setAttribute("user", s);
        
        ShowAnswerdao sad = new ShowAnswerdao();
        ArrayList<Choice>choices = sad.getChoiceByQuizId(quizId,s.getId());
        ArrayList<ChoiceResult>choiceResults =sad.getChoiceResultByQuizId(quizId,s.getId());
        ArrayList<Question>questions =sad.getQuestionByQuizId(quizId);
        Quizzes quiz =sad.getQuizByQuizId(quizId);
        
        if(choiceResults.isEmpty()){
        request.setAttribute("msg","you haven't done this quiz");
        
        }else{
        
        request.setAttribute("choices",choices);
        request.setAttribute("choiceResults",choiceResults);
        request.setAttribute("questions",questions);
        request.setAttribute("quiz",quiz);
        
         CommentReplydao comments = new CommentReplydao();

        if (comments.getAllCommentByQuizId(quizId) != null) {
            request.setAttribute("CommentList", comments.getAllCommentByQuizId(quizId));
        }
        
        request.getServletContext().getRequestDispatcher("/WEB-INF/ShowAnswer.jsp").forward(request, response);
        
        }
        }else{
        if(request.getSession().getAttribute("user") instanceof Teacher){
                Teacher t = (Teacher)request.getSession().getAttribute("user");
        
        int quizId = Integer.valueOf(request.getParameter("currentQuizId"));
          
//        Student s = new Student(61130500001l,"kao","sodsong","1234",1,2,"kao@mail");
//        int quizId = 1;
        
        
        request.setAttribute("currentQuizId",quizId);
        request.getSession().setAttribute("user",t);
        
        ShowAnswerdao sad = new ShowAnswerdao();
        ArrayList<Choice>choices = sad.getChoiceByQuizIdTeacher(quizId);
        ArrayList<Question>questions =sad.getQuestionByQuizId(quizId);
        Quizzes quiz =sad.getQuizByQuizId(quizId);
        
       {
        
        request.setAttribute("choicesT",choices);
        request.setAttribute("questionsT",questions);
        request.setAttribute("quizT",quiz);
        
         CommentReplydao comments = new CommentReplydao();

        if (comments.getAllCommentByQuizId(quizId) != null) {
            request.setAttribute("CommentList", comments.getAllCommentByQuizId(quizId));
        }
        
        request.getServletContext().getRequestDispatcher("/WEB-INF/ShowAnswer.jsp").forward(request, response);
        
        }
        
        
        
        
        
        
        
        
        
        
        
        }
        }
    }
//    public static void main(String[] args) {
//       ShowAnswerdao sad = new ShowAnswerdao();
//        System.out.println(sad.getChoiceResultByQuizId(1,61130500002l));
//        if(sad.getChoiceResultByQuizId(1,61130500002l).isEmpty()){
//            System.out.println("no way");}
//    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
