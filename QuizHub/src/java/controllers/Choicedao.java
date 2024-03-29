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
import model.Choice;

/**
 *
 * @author tsch
 */
public class Choicedao {

    Connection conn = null;

    public boolean createChoice(Choice c) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO choices(choice_name, choice_correct, question_id, quiz_id) VALUES(?,?,?,?)");
            ps.setString(1, c.getChoiceName());
            ps.setString(2, c.isChoiceCorrect());
            ps.setInt(3, c.getQuestionId());
            ps.setInt(4, c.getQuizId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ArrayList<Choice> getAllChoiceByQuizId(int quiz_id) {
        conn = BuildConnection.getConnection();
        ArrayList<Choice> q = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choices WHERE quiz_id = ?");
            ps.setInt(1, quiz_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                q.add(
                        new Choice(
                                rs.getInt("choice_id"),
                                rs.getString("choice_name"),
                                rs.getString("choice_correct"),
                                rs.getInt("question_id"),
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

    public Choice findCorrectChoiceById(int choice) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choices WHERE choice_id = ?");
            ps.setInt(1, choice);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Choice(
                        rs.getString("choice_correct")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Choice findIncorrectChoiceByQuestion(int quiz) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choices WHERE question_id = ? AND choice_correct = 'false' FETCH FIRST 1 ROWS ONLY");
            ps.setInt(1, quiz);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Choice(
                        rs.getInt("choice_id"),
                        rs.getString("choice_name"),
                        rs.getString("choice_correct"),
                        rs.getInt("question_id"),
                        rs.getInt("quiz_id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Choice findChoiceById(int choice) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choices WHERE choice_id = ?");
            ps.setInt(1, choice);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Choice(
                        rs.getInt("choice_id"),
                        rs.getString("choice_name"),
                        rs.getString("choice_correct"),
                        rs.getInt("question_id"),
                        rs.getInt("quiz_id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
