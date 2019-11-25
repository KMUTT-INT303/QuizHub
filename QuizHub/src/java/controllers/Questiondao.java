/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.BuildConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;

/**
 *
 * @author tsch
 */
public class Questiondao {

    Connection conn = null;

    public boolean createQuestion(Question q) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO questions (question_name, quiz_id) VALUES(?,?)");
            ps.setString(1, q.getQuestionName());
            ps.setInt(2, q.getQuizId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Question getQuestionById(int quiz_id) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM questions where question_id = ?");
            ps.setInt(1, quiz_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Question(
                        rs.getInt("question_id"),
                        rs.getString("question_name"),
                        rs.getInt("quiz_id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Question getQuestionByQuizId(int quiz_id) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM questions where quiz_id = ?");
            ps.setInt(1, quiz_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Question(
                        rs.getInt("question_id"),
                        rs.getString("question_name"),
                        rs.getInt("quiz_id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Question> getAllQuestionByQuizId(int quiz_id) {
        conn = BuildConnection.getConnection();
        ArrayList<Question> q = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM questions WHERE quiz_id = ?");
            ps.setInt(1, quiz_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                q.add(
                        new Question(
                                rs.getInt("question_id"),
                                rs.getString("question_name"),
                                rs.getInt("quiz_id")
                        )
                );
            }
            return q;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
