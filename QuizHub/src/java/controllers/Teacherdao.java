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
import model.Course;
import model.Teacher;

/**
 *
 * @author Top
 */
public class Teacherdao {
    Connection conn = null;
    
    public ArrayList<Teacher> getAllTeacher(){
        ArrayList<Teacher> teachers = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teachers");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teachers.add(new Teacher(rs.getLong("teacher_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"),
                        rs.getInt("faculty_id"), rs.getString("account_status")));
            }return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Teacher> getAllTeacherLike(String desciption){
        ArrayList<Teacher> teachers = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teachers WHERE CHAR(teacher_id) like ? OR LOWER(first_name) like ? " + "OR LOWER(last_name) like ?");
            ps.setString(1, "%" + desciption + "%");
            ps.setString(2, desciption.toLowerCase() + "%");
            ps.setString(3, desciption.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teachers.add(new Teacher(rs.getLong("teacher_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"),
                        rs.getInt("faculty_id"), rs.getString("account_status")));
            }return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Teacher> getAllTeacherActive(){
        ArrayList<Teacher> teachers = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teachers WHERE account_status = 'active'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teachers.add(new Teacher(rs.getLong("teacher_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"),
                        rs.getInt("faculty_id"), rs.getString("account_status")));
            }return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Teacher> getAllTeacherPending(){
        ArrayList<Teacher> teachers = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teachers WHERE account_status = 'pending'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teachers.add(new Teacher(rs.getLong("teacher_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"),
                        rs.getInt("faculty_id"), rs.getString("account_status")));
            }return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean setTeacherToActive(Teacher t){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE teachers SET account_status = 'active' WHERE teacher_id = ?");
            ps.setLong(1, t.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
    }
    
    public boolean setTeacherToPending(Teacher t){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE teachers SET account_status = 'pending' WHERE teacher_id = ?");
            ps.setLong(1, t.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
    }
    
    public boolean RemoveTeacherById(long tid){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM teachers WHERE teacher_id = ?");
            ps.setLong(1, tid);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
    }
    
    public Teacher getTeacherById(long tid){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teachers WHERE teacher_id = ?");
            ps.setLong(1, tid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Teacher(rs.getLong("teacher_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"),
                        rs.getInt("faculty_id"), rs.getString("account_status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public boolean addTeacher(Teacher t){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO teachers(teacher_id, first_name, last_name, password, faculty_id, account_status) VALUES(?,?,?,?,?,?)");
            ps.setLong(1, t.getId());
            ps.setString(2, t.getFirstName());
            ps.setString(3, t.getLastName());
            ps.setString(4, t.getPassword());
            ps.setInt(5, t.getFaculty_id());
            ps.setString(6, "pending");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean editTeacher(Teacher t){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE teachers SET first_name = ?, last_name = ?, password = ?, faculty_id = ?, account_status= ? WHERE teacher_id = ?");
            ps.setString(1, t.getFirstName());
            ps.setString(2, t.getLastName());
            ps.setString(3, t.getPassword());
            ps.setInt(4, t.getFaculty_id());
            ps.setString(5, t.getAccount_status());
            ps.setLong(6, t.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
   /* public boolean addTeacher(Teacher t){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO teachers(teacher_id, first_name, last_name, password, faculty_id, course_name, course_id, account_status) VALUES(?,?,?,?,?,?,?,?)");
            ps.setLong(1, t.getId());
            ps.setString(2, t.getFirstName());
            ps.setString(3, t.getLastName());
            ps.setString(4, t.getPassword());
            ps.setInt(5, t.getFaculty_id());
            ps.setString(6, t.getCourse_name());
            ps.setString(7, t.getCourse_id());
            ps.setString(8, "pending");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }*/
    
    public static void main(String[] args) {
     /*   Teacherdao tdao = new Teacherdao();
        ArrayList<Teacher> teachers = new ArrayList();
        Teacher t = tdao.getTeacherById(Long.valueOf("1000000001"));
       // tdao.setTeacherToActive(t);
        //teachers = tdao.getAllTeacherPending();
        //System.out.println(teachers);
        long tid = Long.valueOf("1000000001");
        //Teacher addt = new Teacher(tid, "firstName", "lastName", "password", 2);
        Teacher addt = tdao.getTeacherById(tid);
        //tdao.addTeacher(addt);
        System.out.println(addt);
        addt.setFirstName("testname");
        tdao.editTeacher(addt);
        System.out.println(tdao.getTeacherById(tid));*/
     Teacherdao tdao = new Teacherdao();
        ArrayList<Teacher> teachers = new ArrayList();
        teachers = tdao.getAllTeacherLike("b");
        System.out.println(teachers);
    }
    
}
