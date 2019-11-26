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
            PreparedStatement ps = conn.prepareStatement("INSERT INTO quiz(quiz_name, quiz_comments, quiz_status, teacher_id, course_name, course_id, faculty_id, branch_id, join_code, cover_images, skill_text, start_date, end_date, page, hours, minutes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, q.getQuizName());
            ps.setString(2, q.getQuizComment());
            ps.setString(3, q.getQuizStatus());
            ps.setLong(4, q.getQuizTeacherId());
            ps.setString(5, q.getQuizCourseName());
            ps.setString(6, q.getQuizCourseId());
            ps.setInt(7, q.getQuizFacultyId());
            ps.setInt(8, q.getQuizBranchId());
            ps.setString(9, q.getQuizCode());
            ps.setString(10, q.getQuizCoverImages());
            ps.setString(11, q.getQuizSkillText());
            ps.setTimestamp(12, q.getQuizStartDate());
            ps.setTimestamp(13, q.getQuizEndDate());
            ps.setString(14, q.getPage());
            ps.setString(15, q.getHours());
            ps.setString(16, q.getMinutes());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ArrayList<Quizzes> ListAllQuiz() {
        conn = BuildConnection.getConnection();
        ArrayList<Quizzes> quizzez = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quizzez.add(
                        new Quizzes(
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
                        )
                );
            }
            return quizzez;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Quizzes> ListAllQuizByBranch(int bid) {
        conn = BuildConnection.getConnection();
        ArrayList<Quizzes> quizzez = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz WHERE branch_id = ?");
            ps.setInt(1, bid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quizzez.add(new Quizzes(
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
                        rs.getString("minutes"))
                );
            }
            return quizzez;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Quizzes> ListAllQuizByFaculty(int faculty_id) {
        conn = BuildConnection.getConnection();
        ArrayList<Quizzes> quizzez = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz WHERE faculty_id = ?");
            ps.setInt(1, faculty_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quizzez.add(
                        new Quizzes(
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
                        )
                );
            }
            return quizzez;
        } catch (SQLException ex) {
            Logger.getLogger(Quizdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Quizzes findQuizzesById(int id) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz WHERE quiz_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Quizzes(rs.getInt("quiz_id"),
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
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Quizzes findQuizzesByCode(String code) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz WHERE join_code = ?");
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Quizzes(rs.getInt("quiz_id"),
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
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Quizzes findQuizzesByPage(String code) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz WHERE page = ?");
            ps.setString(1, code);
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
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Quizdao qdao = new Quizdao();
        ArrayList<Quizzes> qs = qdao.ListAllQuiz();
        System.out.println(qs);
    }

}
