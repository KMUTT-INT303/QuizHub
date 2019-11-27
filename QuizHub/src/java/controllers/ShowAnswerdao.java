package controllers;

import db.BuildConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Choice;
import model.ChoiceResult;
import model.Question;
import model.Quizzes;

public class ShowAnswerdao {

    Connection conn = null;

    public Quizzes getQuizByQuizId(int quiz_id) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM questions where quiz_id = ?");
            ps.setInt(1, quiz_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Quizzes(
                        rs.getInt("quiz_id"),
                        rs.getString("quiz_name"),
                        rs.getString("quiz_comments"),
                        rs.getString("quiz_status"),
                        rs.getLong("teacher_id"),
                        rs.getString("course_name"),
                        rs.getString("course_id"),
                        rs.getInt("faculty_id"),
                        rs.getInt("branch_id"),
                        rs.getString("join_code"),
                        rs.getString("cover_images"),
                        rs.getString("skill_text"),
                        rs.getTimestamp("start_date"),
                        rs.getTimestamp("end_date"),
                        rs.getString("page"),
                        rs.getString("hours"),
                        rs.getString("minutes")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Question> getQuestionByQuizId(int quiz_id) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM questions where quiz_id = ?");
            ps.setInt(1, quiz_id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Question> questions = new ArrayList();
            while (rs.next()) {
                questions.add(new Question(rs.getInt("question_id"),
                        rs.getString("question_name"),
                        rs.getInt("quiz_id")));

            }
            return questions;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Choice> getChoiceByQuizId(int quizId,Long studentId) {

        conn = BuildConnection.getConnection();
        ArrayList<Choice> choices = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choices WHERE quiz_id = ?");
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(
                        rs.getInt("choice_id"),
                        rs.getString("choice_name"),
                        rs.getString("choice_correct"),
                        rs.getInt("question_id"),
                        rs.getInt("quiz_id")
                );
                ArrayList<ChoiceResult>cr =this.getChoiceResultByQuizId(quizId,studentId);
                for(int i = 0;i<cr.size();i++){
                if(c.getChoiceId()==cr.get(i).getChoice_id()){
                c.setChoose("true");
                }
                }
                choices.add(c);
            }
            return choices;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
    
 public ArrayList<Choice> getChoiceByQuizIdTeacher(int quizId) {

        conn = BuildConnection.getConnection();
        ArrayList<Choice> choices = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choices WHERE quiz_id = ?");
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(
                        rs.getInt("choice_id"),
                        rs.getString("choice_name"),
                        rs.getString("choice_correct"),
                        rs.getInt("question_id"),
                        rs.getInt("quiz_id")
                );
      
                choices.add(c);
            }
            return choices;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
    public ArrayList<ChoiceResult> getChoiceResultByQuizId(int quizId, Long studentId) {
        conn = BuildConnection.getConnection();
        ArrayList<ChoiceResult> choices = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choice_results WHERE quiz_id = ? and student_id = ?");
            ps.setInt(1, quizId);
            ps.setLong(2, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                choices.add(
                        new ChoiceResult(
                                rs.getInt("quiz_id"), rs.getInt("question_id"), rs.getInt("choice_id"), rs.getLong("student_id")
                        )
                );
            }
            return choices;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
