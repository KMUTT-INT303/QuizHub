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
import model.ChoiceResult;

/**
 *
 * @author tsch
 */
import model.Result;

public class ChoiceResultDao {

    Connection conn = null;

    public boolean createChoiceResult(ChoiceResult cr) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CHOICE_RESULTS (quiz_id, question_id, choice_id, student_id) VALUES(?,?,?,?)");
            ps.setInt(1, cr.getQuiz_id());
            ps.setInt(2, cr.getQuestion_id());
            ps.setInt(3, cr.getChoice_id());
            ps.setLong(4, cr.getStudent_id());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
}
