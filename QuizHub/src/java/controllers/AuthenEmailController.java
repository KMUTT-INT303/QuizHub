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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AuthenEmail;
import model.Teacher;

/**
 *
 * @author Top
 */
public class AuthenEmailController {
    Connection conn = null;
    
    public boolean addNewAuthen(AuthenEmail ae){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO authenemail(authen_code, teacher_id, created_time, remove_time)values(?,?,?,?)");
            ps.setString(1, ae.getCode());
            ps.setLong(2, ae.getTeacher_id());
            ps.setTimestamp(3, ae.getCreated_Time());
            ps.setTimestamp(4, ae.getRemove_Time());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenEmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteExpiredCode(){
        conn = BuildConnection.getConnection(); 
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM authenemail WHERE remove_time < current_timestamp");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenEmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public AuthenEmail getAuthenByTeacherId(long tid){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM authenemail WHERE teacher_id = ?");
            ps.setLong(1, tid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new AuthenEmail(rs.getInt("authenid"), rs.getString("authen_code"), rs.getLong("teacher_id"), rs.getTimestamp("created_time"), rs.getTimestamp("remove_Time"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthenEmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean updateAuthenCode(AuthenEmail ae){
        conn = BuildConnection.getConnection(); 
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE authenemail SET authen_code = ? WHERE authenid = ?");
            ps.setString(1, ae.getCode());
            ps.setInt(2, ae.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenEmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteCodeByTeacher(long tid){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM authenemail WHERE teacher_id = ?");
            ps.setLong(1, tid);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenEmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    public static void main(String[] args) {
        Teacherdao tdao = new Teacherdao();
        Teacher t = tdao.getTeacherById(Long.valueOf("1000000005"));
        tdao.setTeacherToPending(t);
       /* long t = System.currentTimeMillis();// + 60000;
        DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date result = new Date(t);
        System.out.println(simple.format(result));
        Timestamp use = Timestamp.valueOf(simple.format(result));
        AuthenEmail ae = new AuthenEmail(1, "ABC", Long.valueOf("1000000001"), use);
        AuthenEmailController aec =  new AuthenEmailController();
        aec.addNewAuthen(ae);
        AuthenEmail ae2 = aec.getAuthenByTeacherId(Long.valueOf("1000000001"));
        System.out.println(aec.getAuthenByTeacherId(Long.valueOf("1000000001")));
        ae2.setCode("DEF");
        System.out.println(aec.updateAuthenCode(ae2));
        
        System.out.println(aec.getAuthenByTeacherId(Long.valueOf("1000000001")));
        
        //aec.deleteExpiredCode();*/
    }
    
}
