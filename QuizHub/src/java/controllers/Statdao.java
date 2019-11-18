/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.SkillStat;
import db.BuildConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.QuizScore;
import model.Quizzes;

public class Statdao {

    //getListOfClass
    Connection conn = null;

    public ArrayList<Course> getAllCourseByName(String searchText) {
        conn = BuildConnection.getConnection();
        ArrayList<Course> c = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM courses WHERE upper(COURSE_NAME) like upper(?)");
            ps.setString(1, "%" + searchText + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Course(rs.getString("course_id"), rs.getString("course_name")));
            }
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(Statdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //getListOfQuizByQuizName
    public ArrayList<Quizzes> getAllQuizByName(String searchText, long studentId) {
        conn = BuildConnection.getConnection();
        ArrayList<Quizzes> q = new ArrayList();
        try {
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM QUIZ WHERE upper(QUIZ_NAME) like upper(?)");
            PreparedStatement ps = conn.prepareStatement("select q.quiz_id as quiz_id,q.quiz_name as quiz_name,Q.COURSE_NAME as course_name,q.page as page FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND CR.CHOICE_RESULT_ID IS NOT NULL AND UPPER(Q.QUIZ_NAME) like UPPER(?) group by q.quiz_id,q.quiz_name,Q.COURSE_NAME,q.page order by q.quiz_name");
            ps.setLong(1, studentId);
            ps.setString(2, "%" + searchText + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                q.add(new Quizzes(rs.getString("quiz_Name"), rs.getString("Course_Name"), rs.getInt("quiz_id"),rs.getString("page")));
            }
            return q;
        } catch (SQLException ex) {
            Logger.getLogger(Statdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //getListOfQuizByCourseName
    public ArrayList<Quizzes> getQuizByCourseId(String courseId, long studentId) {
        conn = BuildConnection.getConnection();
        ArrayList<Quizzes> q = new ArrayList();
        try {
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM QUIZ WHERE upper(COURSE_ID) = upper(?)");
            PreparedStatement ps = conn.prepareStatement("select q.quiz_id as quiz_id,q.quiz_name as quiz_name,Q.COURSE_NAME as course_name,q.page as page FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND CR.CHOICE_RESULT_ID IS NOT NULL AND UPPER(Q.course_id) = UPPER(?) group by q.quiz_id,q.quiz_name,Q.COURSE_NAME,q.page");
            ps.setLong(1, studentId);
            ps.setString(2, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                q.add(new Quizzes(rs.getString("quiz_Name"), rs.getString("Course_Name"), rs.getInt("quiz_id"),rs.getString("page")));
            }
            return q;
        } catch (SQLException ex) {
            Logger.getLogger(Statdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //getTestScoreForQuiz
    public ArrayList<QuizScore> getTestScoreForQuizByName(String quizName, long studentId) {
        //return test score and practice score
        conn = BuildConnection.getConnection();
        ArrayList<QuizScore> q = new ArrayList();
        try {

            PreparedStatement ps = conn.prepareStatement("select count(choice_result_id) as score,quiz_name,skill_text FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND CR.CHOICE_RESULT_ID IS NOT NULL AND CH.CHOICE_CORRECT = true AND UPPER(Q.QUIZ_NAME) like UPPER(?) group by q.quiz_id,q.quiz_name,Q.COURSE_NAME,q.skill_text order by q.quiz_name");
            //PreparedStatement ps2 = conn.prepareStatement("select count(choice_result_id) as score,q.quiz_id as quiz_id,q.quiz_name as quiz_name,Q.COURSE_NAME as course_name FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND CR.ANSWER = true AND UPPER(Q.QUIZ_NAME) like UPPER(?) group by q.quiz_id,q.quiz_name,Q.COURSE_NAME order by q.quiz_name");
            PreparedStatement ps2 = conn.prepareStatement("select count(qt.QUESTION_ID) as fullScore from quiz q join questions qt on q.QUIZ_ID = qt.QUIZ_ID join choice_results cr on cr.QUESTION_ID = qt.QUESTION_ID where cr.STUDENT_ID=? and upper(q.quiz_name)like upper(?) and CR.CHOICE_RESULT_ID IS NOT NULL group by q.quiz_id");

            
            
            ps.setLong(1, studentId);
            ps.setString(2, "%" + quizName + "%");
           
            
            ps2.setLong(1, studentId);
            ps2.setString(2, "%" + quizName + "%");
            
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            while (rs.next() & rs2.next()) {

                q.add(new QuizScore(rs.getLong("score"), rs2.getLong("fullScore"), rs.getString("skill_text")));
            }
            return q;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //getTestScoreForQuizByCourseName
    public ArrayList<QuizScore> getTestScoreForQuizByCourseId(String courseId, long studentId) {
        //return test score and practice score
        conn = BuildConnection.getConnection();
        ArrayList<QuizScore> q = new ArrayList();
        try {

            PreparedStatement ps = conn.prepareStatement("select count(choice_result_id) as score,quiz_name,skill_text FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND CR.CHOICE_RESULT_ID IS NOT NULL AND CH.CHOICE_CORRECT = true AND UPPER(Q.COURSE_ID) = UPPER(?) group by q.quiz_id,q.quiz_name,Q.COURSE_NAME,q.skill_text order by q.quiz_name");
            //PreparedStatement ps2 = conn.prepareStatement("select count(choice_result_id) as score,q.quiz_id as quiz_id,q.quiz_name as quiz_name,Q.COURSE_NAME as course_name FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND CR.ANSWER = true AND UPPER(Q.COURSE_ID) = UPPER(?) group by q.quiz_id,q.quiz_name,Q.COURSE_NAME order by q.quiz_name");
            PreparedStatement ps2 = conn.prepareStatement("select count(qt.QUESTION_ID) as fullScore from quiz q join questions qt on q.QUIZ_ID = qt.QUIZ_ID join choice_results cr on cr.QUESTION_ID = qt.QUESTION_ID where cr.STUDENT_ID=? and upper(q.course_id)=upper(?) and CR.CHOICE_RESULT_ID IS NOT NULL group by q.quiz_id");

            
            ps.setLong(1, studentId);
            ps.setString(2, courseId);
            

            ps2.setLong(1, studentId);
            ps2.setString(2, courseId);
            

            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            while (rs.next() & rs2.next()) {

                q.add(new QuizScore(rs.getLong("score"), rs2.getLong("fullScore"), rs.getString("skill_text")));
            }
            return q;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //getTestScoreForEachQuiz
    public ArrayList<QuizScore> getTestScoreForEachQuizByName(String quizName, long studentId) {
        //return test score and practice score

        conn = BuildConnection.getConnection();
        ArrayList<QuizScore> q = new ArrayList();
        try {

            PreparedStatement ps = conn.prepareStatement("select count(choice_result_id) as score,quiz_name,skill_text FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND CR.CHOICE_RESULT_ID IS NOT NULL AND CH.CHOICE_CORRECT = true AND UPPER(Q.QUIZ_NAME) = UPPER(?) group by q.quiz_id,q.quiz_name,Q.COURSE_NAME,q.skill_text");
            PreparedStatement ps2 = conn.prepareStatement("select count(choice_result_id) as score,quiz_name FROM QUIZ Q JOIN QUESTIONS QT ON Q.QUIZ_ID = QT.QUIZ_ID JOIN CHOICES CH ON CH.QUESTION_ID = QT.QUESTION_ID JOIN CHOICE_RESULTS CR ON CH.CHOICE_ID = CR.CHOICE_ID WHERE CR.STUDENT_ID = ? AND UPPER(Q.QUIZ_NAME) = UPPER(?) group by quiz_name");

            ps.setString(2, quizName);
            ps.setLong(1, studentId);

            ps2.setString(2, quizName);
            ps2.setLong(1, studentId);
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            while (rs.next() & rs2.next()) {

                q.add(new QuizScore(rs.getLong("score"), rs2.getLong("score"), rs.getString("skill_text")));
            }
            return q;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<SkillStat> getSkillStatByCourseId(String courseId, long studentId) {

        ArrayList<QuizScore> quizTestScore = quizTestScore = this.getTestScoreForQuizByCourseId(courseId, studentId);

        if (quizTestScore.isEmpty()) {
            return null;

        } else {

            //Set Skill Part
            ArrayList<SkillStat> sl = new ArrayList();

            for (int i = 0; i < quizTestScore.size(); i++) {

                String skillName = quizTestScore.get(i).getSkill();
                double percent = quizTestScore.get(i).getPercent();
                boolean haveSame = false;
                if (!sl.isEmpty()) {
                    System.out.println("not empty");
                    System.out.println(sl);
                    for (int v = 0; v < sl.size(); v++) {
                        if (sl.get(v).getName().equals(skillName)) {
                            SkillStat skillStatOld = new SkillStat(sl.get(v).getName(),sl.get(v).getAllPercent(),sl.get(v).getQuantityOfSameSkillQuiz());
                            SkillStat skillStatPrepare = skillStatOld;
                            
                            skillStatPrepare.setAllPercent(skillStatOld.getAllPercent() + percent);
                            skillStatPrepare.setName(skillStatOld.getName());
                            skillStatPrepare.setQuantityOfSameSkillQuiz(skillStatOld.getQuantityOfSameSkillQuiz() + 1);
                            sl.set(v, skillStatPrepare);
                            haveSame = true;
                        }

                    }
                }else{
                    System.out.println("it's empty");
                }

                if (haveSame == false) {
                    sl.add(new SkillStat(skillName, percent, 1));
                }
            }
            return sl;

        }
        //bring user to quiz page

    }

}
