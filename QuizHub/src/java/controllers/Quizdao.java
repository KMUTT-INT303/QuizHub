/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.BuildConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Quizzes;

/**
 *
 * @author Top
 */
public class Quizdao {

    Connection conn = null;

    public boolean createQuiz(Quizzes q) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO quiz(quiz_name, quiz_comments, quiz_status, teacher_id, course_name, course_id, faculty_id, branch_id, join_code, cover_images, skill_text, start_date, end_date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, q.getQuizName());
            ps.setString(2, q.getQuizComment());
            ps.setString(3, q.getQuizStatus());
            ps.setLong(4, q.getQuizTeacherId());
            ps.setString(5, q.getQuizName());
            ps.setString(6, q.getQuizCourseId());
            ps.setInt(7, q.getQuizFacultyId());
            ps.setInt(8, q.getQuizBranchId());
            ps.setString(9, q.getQuizCode());
            ps.setString(10, q.getQuizCoverImages());
            ps.setString(11, q.getQuizSkillText());
            ps.setTimestamp(12, q.getQuizStartDate());      
            ps.setTimestamp(13, q.getQuizEndDate());   
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
