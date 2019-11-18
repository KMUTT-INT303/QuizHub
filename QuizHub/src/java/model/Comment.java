/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.org.apache.bcel.internal.generic.D2F;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MaxPong
 */
public class Comment {
    int commentId;
    String comment;
    Timestamp date;
    long studentId;
    int quizId;
    ArrayList<Reply> replys;

    public Comment(String comment, long studentId, int quizId) {
        
        this.comment = comment;
        this.studentId = studentId;
        this.quizId = quizId;
        
    }
    
     public Comment(int commentId,String comment,Timestamp date, long studentId, int quizId ,ArrayList<Reply> replys ) {
        this.commentId=commentId;
        this.comment = comment;
        this.date = date;
        this.studentId = studentId;
        this.quizId = quizId;
        this.replys = replys;
    }
    
    public void addReply(Reply r){
    replys.add(r);
    
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public ArrayList<Reply> getReplys() {
        return replys;
    }

    public void setReplys(ArrayList<Reply> replys) {
        this.replys = replys;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", comment=" + comment + ", date=" + date + ", studentId=" + studentId + ", quizId=" + quizId + ", replys=" + replys + '}';
    }
    
    
    
    
   
    
    
    
}
