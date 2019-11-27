/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author MaxPong
 */
public class Reply {
    int replyCommentId;
    String replyComment;
    Timestamp date;
    long userId;
    int commentId;

    public Reply(String replyComment, long userId, int commentId) {
        this.replyComment = replyComment;
        this.userId = userId;
        this.commentId = commentId;
    }
        
    
    
    public Reply(int replyCommentId, String replyComment, Timestamp date, long userId, int commentId) {
        this.replyCommentId = replyCommentId;
        this.replyComment = replyComment;
        this.date = date;
        this.userId = userId;
        this.commentId = commentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
        


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }





    public int getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(int replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public String getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(String replyComment) {
        this.replyComment = replyComment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reply{" + "replyCommentId=" + replyCommentId + ", replyComment=" + replyComment + ", date=" + date + ", studentId=" + userId + ", commentId=" + commentId + '}';
    }

 
    
    
    
    
    
    
    
    }