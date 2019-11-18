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
import model.Result;

/**
 *
 * @author tsch
 */
public class Resultdao {

    Connection conn = null;

    public boolean createResult(Result r) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO results (total_time, total_correct, total_incorrect, quiz_id, student_id) VALUES(?,?,?,?,?)");
            ps.setString(1, r.getTotal_time());
            ps.setInt(2, r.getTotalCorrect());
            ps.setInt(3, r.getTotalIncorrect());
            ps.setInt(4, r.getQuizId());
            ps.setLong(5, r.getStudentId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updateResult(Result r) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE results SET total_time = ?, total_correct = ?, total_incorrect = ?, quiz_id = ?, student_id = ?, result_date = CURRENT_TIMESTAMP WHERE student_id = ?");
            ps.setString(1, r.getTotal_time());
            ps.setInt(2, r.getTotalCorrect());
            ps.setInt(3, r.getTotalIncorrect());
            ps.setInt(4, r.getQuizId());
            ps.setLong(5, r.getStudentId());
            ps.setLong(6, r.getStudentId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Result findResultByStudentId(long student_id) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM results WHERE student_id = ?");
            ps.setLong(1, student_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Result(
                        rs.getInt("result_id"),
                        rs.getString("total_time"),
                        rs.getInt("total_correct"),
                        rs.getInt("total_incorrect"),
                        rs.getInt("quiz_id"),
                        rs.getLong("student_id"),
                        rs.getTimestamp("result_date")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
