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
            PreparedStatement ps = conn.prepareStatement("INSERT INTO choices(choice_name, choice_correct, question_id) VALUES(?,?,?)");
            ps.setString(1, c.getChoiceName());
            ps.setString(2, c.isChoiceCorrect());
            ps.setInt(3, c.getQuestionId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ArrayList<Choice> getAllChoiceByQuestionId(int quest_id) {
        conn = BuildConnection.getConnection();
        ArrayList<Choice> q = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM choices WHERE question_id = ?");
            ps.setInt(1, quest_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                q.add(
                        new Choice(rs.getInt("choice_id"), rs.getString("choice_name"), rs.getString("choice_correct"), rs.getInt("question_id")
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
