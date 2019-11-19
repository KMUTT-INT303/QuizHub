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
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MaxPong
 */
public class QuizManagerdao {
    Connection conn = BuildConnection.getConnection();
        PreparedStatement ps = null;
        String fixQuiz;
        
        public void setQuizAttributeValue(String column,String value,int quizId){
        try {
            fixQuiz = "UPDATE Quiz SET " + column + " = ? WHERE quiz_id=?";
            ps = conn.prepareStatement(fixQuiz);
            
            ps.setString(1, value);
            ps.setInt(2,quizId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizManagerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        }
        
            public void setQuizAttributeValue(String column,Timestamp value,int quizId){
        try {
            fixQuiz = "UPDATE Quiz SET " + column + " = ? WHERE quiz_id=?";
            ps = conn.prepareStatement(fixQuiz);
            
            ps.setTimestamp(1, value);
            ps.setInt(2,quizId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizManagerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        }
            
            public void deleteQuiz(int quizId){
           
        try {
            ps = conn.prepareStatement("DELETE FROM quiz WHERE Quiz_id=?");
            ps.setInt(1,quizId);
            ps.executeUpdate();
            ps = conn.prepareStatement("DELETE FROM questions WHERE Quiz_id=?");
            ps.setInt(1,quizId);
            ps.executeUpdate();
            ps = conn.prepareStatement("DELETE FROM choices WHERE Quiz_id=?");
            ps.setInt(1,quizId);
            ps.executeUpdate();
            ps = conn.prepareStatement("DELETE FROM choice_results WHERE Quiz_id=?");
            ps.setInt(1,quizId);
            ps.executeUpdate();
        
        
        
        
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(QuizManagerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            }
            
            
}
