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
public class Coursedao {
    Connection conn;
    public Course getCourseById(String cid){
        Teacherdao tdao = new Teacherdao();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM courses WHERE LOWER(course_id) = ?");
            ps.setString(1, cid.toLowerCase());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Teacher t = tdao.getTeacherById(rs.getLong("teacher"));
                return new Course(rs.getString("course_id"), rs.getString("course_name"), t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Coursedao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean addCourse(Course c){
        conn = BuildConnection.getConnection();
        if(this.getCourseById(c.getId()) != null){
            System.out.print("Cannot add.\n");
            return false;
        }else{
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO courses(course_id, course_name, teacher) VALUES(?,?,?)");
                ps.setString(1, c.getId());
                ps.setString(2, c.getName());
                ps.setLong(3, c.getTeacher().getId());
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Coursedao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }
    
    public boolean editCourseName(Course c){
        conn = BuildConnection.getConnection();
        //Teacherdao tdao = new Teacherdao();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE courses SET course_name = ?, teacher = ? WHERE course_id = ?");
            ps.setString(1, c.getName());
            ps.setLong(2, c.getTeacher().getId());
            ps.setString(3, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Coursedao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Course> getAllCourse(){
        conn = BuildConnection.getConnection();
        ArrayList<Course> c = new ArrayList();
        Teacherdao tdao = new Teacherdao();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM courses");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Teacher t = tdao.getTeacherById(rs.getLong("teacher"));
                c.add(new Course(rs.getString("course_id"), rs.getString("course_name"), t));
            }return c;
        } catch (SQLException ex) {
            Logger.getLogger(Coursedao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean removeCourse(Course c){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM courses WHERE course_id = ?");
            ps.setString(1, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Coursedao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
     
    public ArrayList<Course> getAllCourseByTeacher(Teacher t){
        conn = BuildConnection.getConnection();
        ArrayList<Course> c = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM courses WHERE teacher = ?");
            ps.setLong(1, t.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                c.add(new Course(rs.getString("course_id"), rs.getString("course_name"), t));
            }return c;
        } catch (SQLException ex) {
            Logger.getLogger(Coursedao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        Coursedao cdao  = new Coursedao();
        Teacherdao tdao = new Teacherdao();
        long tid = Long.valueOf("1000000004");
        Teacher t = tdao.getTeacherById(tid);
        Course c = new Course("INT123", "TEST", t);
        //System.out.println(c);
        ArrayList<Course> cs = cdao.getAllCourse();
        //System.out.println(cs);
        //Course cc = new Course("testadd3", "hahaha", t);
        cdao.addCourse(c);
       // cdao.removeCourse(c);
        /*System.out.println(cdao.getAllCourse());
        cs = cdao.getAllCourseByTeacher(t);
        System.out.println(cs);
        cdao.removeCourse(cc);
        System.out.println(cdao.getAllCourse());
        cdao.addCourse(cc);*/
        Course cc = cdao.getCourseById("INT123");
        //cdao.addCourse(cc);
        System.out.println(cdao.getCourseById(cc.getId()));
        //cdao.addCourse(cc);
        cc.setName("editaddt3");
        cdao.editCourseName(cc);
        System.out.println(cdao.getCourseById("INT123"));
        //cdao.removeCourse(cc);
        //System.out.println(cdao.getAllCourse());
        
    }
}
