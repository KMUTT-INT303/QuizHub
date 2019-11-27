package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.QuizScore;
import model.Quizzes;
import model.SkillStat;
import controllers.Statdao;
import model.Student;
import model.Teacher;

/**
 *
 * @author MaxPong
 */
@WebServlet(urlPatterns = {"/ClassScore"})
public class StatSearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchText = request.getParameter("searchText");
        String searchType = request.getParameter("searchType");
        String quizSelect = request.getParameter("quizSelect");
        String classSelect = request.getParameter("classSelect");
        Student s;
        
        
     if(request.getSession().getAttribute("user") instanceof Student){
        //Search Part 
        s = (Student) request.getSession().getAttribute("user");
        if (s != null) {
            if (searchText != null && searchText != "") {
                if (searchText.length() >= 3) {
                    if (searchType.equals("quizName")) {

                        //getCollection Of Quiz from searchtext
                        Statdao sd = new Statdao();
                        ArrayList<Quizzes> ql = sd.getAllQuizByName(searchText, s.getId());

                        ArrayList<QuizScore> quizTestScore = null;
                        quizTestScore = sd.getTestScoreForQuizByName(searchText, s.getId());

                        request.setAttribute("quizList", ql);
                        request.setAttribute("quizTestScore", quizTestScore);
                        request.getServletContext().getRequestDispatcher("/WEB-INF/StatSearch.jsp").forward(request, response);

                    } else {
                        if (searchType.equals("className")) {

                            //show stat of class from searchtext
                            //getCollection Of Class from searchtext 
                            Statdao sd = new Statdao();
                            ArrayList<Course> c = sd.getAllCourseByName(searchText);

                            request.setAttribute("classList", c);
                            request.getServletContext().getRequestDispatcher("/WEB-INF/StatSearch.jsp").forward(request, response);
                        }
                    }

                    //select quiz from class part
                } else {
                    request.setAttribute("msg", "please input more than 3 character");
                }
            }


            if (classSelect != null) {
                Statdao sd = new Statdao();
                ArrayList<Quizzes> ql = sd.getQuizByCourseId(classSelect, s.getId());

                ArrayList<QuizScore> quizTestScore = quizTestScore = sd.getTestScoreForQuizByCourseId(classSelect, s.getId());

                double averagePercentOfClass;
                double sum = 0;

                for (int i = 0; i < quizTestScore.size(); i++) {

                    sum += quizTestScore.get(i).getPercent();
                }
                averagePercentOfClass = sum / quizTestScore.size();

                if (ql.isEmpty() || quizTestScore.isEmpty()) {

                    request.getServletContext().getRequestDispatcher("/WEB-INF/StatSearch.jsp").forward(request, response);
                } else {

                    //Set Skill Part
//                    ArrayList<SkillStat> sl = new ArrayList();
//
//                    for (int i = 0; i < quizTestScore.size(); i++) {
//
//                        String skillName = quizTestScore.get(i).getSkill();
//                        double percent = quizTestScore.get(i).getPercent();
//                        boolean haveSame = false;
//
//                        for (int v = 0; v < sl.size(); v++) {
//                            if (sl.get(v).getName().equals(skillName)) {
//                                SkillStat SkillStatOld = sl.get(v);
//                                SkillStat SkillStatPrepare = null;
//                                SkillStatPrepare.setAllPercent(SkillStatOld.getAllPercent() + percent);
//                                SkillStatPrepare.setName(SkillStatOld.getName());
//                                SkillStatPrepare.setQuantityOfSameSkillQuiz(SkillStatOld.getQuantityOfSameSkillQuiz() + 1);
//                                sl.set(v, SkillStatPrepare);
//                                haveSame = true;
//                            }
//
//                        }
//                        if (haveSame == false) {
//                            sl.add(new SkillStat(skillName, percent, 1));
//                        }
//                    }

                    request.setAttribute("skillList",sd.getSkillStatByCourseId(classSelect,s.getId()));

                    request.setAttribute("averagePercentOfClass", averagePercentOfClass);
                    request.setAttribute("quizList", ql);
                    request.setAttribute("quizTestScore", quizTestScore);
                    request.getServletContext().getRequestDispatcher("/WEB-INF/ClassStat.jsp").forward(request, response);
                }
                //bring user to quiz page

            }
        }
     }else{
     request.setAttribute("msg","you are teacher,you can't have score");
     }
        request.getServletContext().getRequestDispatcher("/WEB-INF/StatSearch.jsp").forward(request, response);
    }

//    public static void main(String[] args) {
//        Statdao s = new Statdao();
//        //ArrayList<QuizScore>q = s.getTestScoreForQuizByCourseId("INT201",67);
//        ArrayList<SkillStat>sl =s.getSkillStatByCourseId("INT201",67);
//        System.out.println(sl);
//        
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

