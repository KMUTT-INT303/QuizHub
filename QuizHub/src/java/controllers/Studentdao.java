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
import model.Student;

/**
 *
 * @author Top
 */
public class Studentdao {
    Connection conn = null;
    private final String GET_ALL_STUDENT = "SELECT * FROM students ORDER BY student_id";
    private final String REMOVE_STUDENT_BY_STUDENT_ID = "DELETE FROM students WHERE student_id = ?";
    private final String ADD_STUDENT = "INSERT INTO students(student_id, first_name, last_name, password, faculty_id, branch_id, account_status) VALUES(?,?,?,?,?,?,?)";
    private final String GET_STUDENT_BY_STUDENT_ID = "SELECT * FROM students WHERE student_id = ?";
    private final String GET_ALL_STUDENT_BY_FACULTY_ID = "SELECT * FROM students s JOIN faculty f ON s.faculty_id = f.faculty_id WHERE f.faculty_id = ?";
    private final String GET_ALL_STUDENT_BY_BRANCH_ID = "SELECT * FROM students s JOIN branch b ON b.branch_id = s.branch_id WHERE b.branch_id = ?";
    
    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> students = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ALL_STUDENT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                students.add(new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("account_status")));
            }return students;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Student> getAllStudentByFacultyId(int fid){
        ArrayList<Student> students = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ALL_STUDENT_BY_FACULTY_ID);
            ps.setInt(1, fid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                students.add(new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("account_status")));
            }return students;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Student> getAllStudentByBranchId(int bid){
        ArrayList<Student> students = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ALL_STUDENT_BY_BRANCH_ID);
            ps.setInt(1, bid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                students.add(new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("account_status")));
            }return students;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Student getStudentById(long sid){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_STUDENT_BY_STUDENT_ID);
            ps.setLong(1, sid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("account_status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public boolean addStudent(Student s){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_STUDENT);
            ps.setLong(1, s.getStudent_id());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            ps.setString(4, s.getPassword());
            ps.setInt(5, s.getFaculty_id());
            ps.setInt(6, s.getBranch_id());
            ps.setString(7, "active");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
    }
    
    public boolean removeStudentById(long sid){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(REMOVE_STUDENT_BY_STUDENT_ID);
            ps.setLong(1, sid);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
    }
    
    
}
