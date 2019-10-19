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
                        rs.getInt("faculty_id"), rs.getString("course_name"), rs.getString("course_id"), rs.getString("account_status")));
            }return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(Teacherdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        Teacherdao tdao = new Teacherdao();
        ArrayList<Teacher> teachers = new ArrayList();
        teachers = tdao.getAllTeacher();
        System.out.println(teachers);
    }
    
}
