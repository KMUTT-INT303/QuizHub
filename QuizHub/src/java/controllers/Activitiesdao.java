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
import model.Activities;

/**
 *
 * @author tsch
 */
public class Activitiesdao {

    Connection conn = null;

    public ArrayList<Activities> findLastAtivitiesByStudentId(long student_id) {
        conn = BuildConnection.getConnection();
        ArrayList<Activities> a = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM results WHERE student_id = ? ORDER BY RESULT_ID DESC FETCH FIRST 3 ROWS ONLY");
            ps.setLong(1, student_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    a.add(new Activities(
                            rs.getInt("result_id"),
                            rs.getTimestamp("result_date")
                    )
                    );
                }
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Activities> findLastAtivitiesByTeacherId(long t_id) {
        conn = BuildConnection.getConnection();
        ArrayList<Activities> a = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM QUIZ WHERE teacher_id = ? ORDER BY quiz_id DESC FETCH FIRST 3 ROWS ONLY");
            ps.setLong(1, t_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    a.add(new Activities(
                            rs.getInt("quiz_id"),
                            rs.getTimestamp("start_date")
                        )
                    );
                }
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
