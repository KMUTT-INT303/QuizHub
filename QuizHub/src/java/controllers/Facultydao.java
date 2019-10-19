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
import model.Faculty;

/**
 *
 * @author Top
 */
public class Facultydao {
    Connection conn = null;
    public ArrayList<Faculty> getAllFaculty(){
        ArrayList<Faculty> faculties = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FACULTY");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                faculties.add(new Faculty(rs.getInt("faculty_id"), rs.getString("faculty_name")));
            }return faculties;
        } catch (SQLException ex) {
            Logger.getLogger(Facultydao.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return null;
    }
    
    public Faculty getFacultyById(int fid){
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM faculty WHERE faculty_id = ?");
            ps.setInt(1, fid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Faculty(rs.getInt("faculty_id"), rs.getString("faculty_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facultydao.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static void main(String[] args) {
        Facultydao fdao = new Facultydao();
        ArrayList<Faculty> faculties = new ArrayList();
        faculties = fdao.getAllFaculty();
        //System.out.println(faculties);
        System.out.println(fdao.getFacultyById(3));
    }
}
