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
    
    public static void main(String[] args) {
        Coursedao cdao  = new Coursedao();
        Course c = cdao.getCourseById("INT201");
        System.out.println(c);
        ArrayList<Course> cs = cdao.getAllCourse();
        System.out.println(cs);
    }
}
