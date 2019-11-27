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
import model.Comment;
import model.Reply;

/**
 *
 * @author MaxPong
 */
public class CommentReplydao {

    private final String ADD_COMMENT = "INSERT INTO COMMENTS(COMMENT,user_ID,QUIZ_ID) VALUES(?,?,?)";
    private final String ADD_REPLY = "INSERT INTO REPLY_COMMENTS(REPLY_COMMENT,user_ID,COMMENT_ID) VALUES(?,?,?)";
    private final String DELETE_COMMENT = "DELETE FROM COMMENTS WHERE COMMENT_ID = ?";
    private final String DELETE_REPLY = "DELETE FROM REPLY_COMMENTS WHERE REPLY_COMMENT_ID = ?";

    Connection conn = null;
    Connection conn2 = null;

    public ArrayList<Comment> getAllCommentByQuizId(int quizId) {
//        ArrayList<Comment> comments = new ArrayList();
//        try {
//            conn = BuildConnection.getConnection();
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FACULTY");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                faculties.add(new Faculty(rs.getInt("faculty_id"), rs.getString("faculty_name")));
//            }return faculties;
//        } catch (SQLException ex) {
//            Logger.getLogger(Facultydao.class.getName()).log(Level.SEVERE, null, ex);
//        }      
//        return null;

//        conn = BuildConnection.getConnection();
//        ArrayList<Quizzes> quizzez = new ArrayList();
//        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                quizzez.add(new Quizzes(rs.getInt("quiz_id"), rs.getString("quiz_name"), rs.getString("quiz_comments"), rs.getString("quiz_status"), rs.getLong("teacher_id"),
//                        rs.getString("course_name"), rs.getString("course_id"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("join_code"), rs.getString("cover_images"), rs.getString("skill_text"),
//                        rs.getTimestamp("start_date"), rs.getTimestamp("end_date"), rs.getString("page"))
//                );
//            }
//            return quizzez;
//        } catch (SQLException ex) {
//            Logger.getLogger(CommentReplyDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
        conn = BuildConnection.getConnection();
        conn2 = BuildConnection.getConnection();
        ArrayList<Comment> comments = new ArrayList();
        try {

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM COMMENTS WHERE QUIZ_ID = ?");
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    PreparedStatement ps2 = conn2.prepareStatement("SELECT * FROM REPLY_COMMENTS WHERE COMMENT_ID = ?");
                    ps2.setInt(1,rs.getInt("comment_id"));
                    ResultSet rs2 = ps2.executeQuery();
                    ArrayList<Reply> replys = new ArrayList();

                    while (rs2.next()) {
                      replys.add(new Reply(rs2.getInt("reply_comment_id"), rs2.getString("reply_comment"),rs2.getTimestamp("reply_comment_date"), rs2.getLong("user_id"), rs2.getInt("comment_id")));
                    }

                    comments.add(new Comment(rs.getInt("comment_id"), rs.getString("comment"), rs.getTimestamp("comment_date"), rs.getLong("user_id"), rs.getInt("quiz_id"), replys));

                }

                return comments;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentReplydao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addComment(Comment c) {

//        try {
//            PreparedStatement ps = conn.prepareStatement(ADD_STUDENT);
//            ps.setLong(1, s.getStudent_id());
//            ps.setString(2, s.getFirstName());
//            ps.setString(3, s.getLastName());
//            ps.setString(4, s.getPassword());
//            ps.setInt(5, s.getFaculty_id());
//            ps.setInt(6, s.getBranch_id());
//            ps.setString(7, "active");
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
//        }return false;
        try {
            conn = BuildConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(ADD_COMMENT);

            ps.setString(1,c.getComment());
            ps.setLong(2,c.getUserId());
            ps.setInt(3,c.getQuizId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommentReplydao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean addReply(Reply r) {
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_REPLY);

            ps.setString(1, r.getReplyComment());
            ps.setLong(2, r.getUserId());
            ps.setInt(3, r.getCommentId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommentReplydao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public boolean deleteComment(int commentId){
    conn = BuildConnection.getConnection();
    try {
            PreparedStatement ps = conn.prepareStatement(DELETE_COMMENT);

            ps.setInt(1,commentId);
           
                

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommentReplydao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    return false;
    }
      public boolean deleteReply(int replyId){
    conn = BuildConnection.getConnection();
    try {
            PreparedStatement ps = conn.prepareStatement(DELETE_REPLY);

            ps.setInt(1,replyId);
           
                

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommentReplydao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    return false;
    }
    


//    public Faculty getFacultyById(int fid){
//        try {
//            conn = BuildConnection.getConnection();
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM faculty WHERE faculty_id = ?");
//            ps.setInt(1, fid);
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                return new Faculty(rs.getInt("faculty_id"), rs.getString("faculty_name"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Facultydao.class.getName()).log(Level.SEVERE, null, ex);
//        }return null;
//    }
}
