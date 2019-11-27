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
    private final String GET_ALL_STUDENT_LIKE = "SELECT * FROM students WHERE CHAR(student_id) like ? OR LOWER(first_name) like ? " + "OR LOWER(last_name) like ?";
    private final String REMOVE_STUDENT_BY_STUDENT_ID = "DELETE FROM students WHERE student_id = ?";
    private final String ADD_STUDENT = "INSERT INTO students(student_id, first_name, last_name, password, faculty_id, branch_id, email, account_status) VALUES(?,?,?,?,?,?,?,?)";
    private final String EDIT_STUDENT_INFO = "UPDATE students SET first_name = ?, last_name = ?, password = ?, faculty_id = ?, branch_id = ?, email = ?,account_status = ? WHERE student_id = ?";
    private final String GET_STUDENT_BY_STUDENT_ID = "SELECT * FROM students WHERE student_id = ?";
    private final String GET_ALL_STUDENT_BY_FACULTY_ID = "SELECT * FROM students s JOIN faculty f ON s.faculty_id = f.faculty_id WHERE f.faculty_id = ?";
    private final String GET_ALL_STUDENT_BY_BRANCH_ID = "SELECT * FROM students s JOIN branch b ON b.branch_id = s.branch_id WHERE b.branch_id = ?";
    
    public Student getStudentByMail(String mail){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE email = ?");
            ps.setString(1, mail);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("email"), rs.getString("account_status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> students = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ALL_STUDENT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                students.add(new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("email"), rs.getString("account_status")));
            }return students;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Student> getAllStudentLike(String description){
        ArrayList<Student> students = new ArrayList();
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ALL_STUDENT_LIKE);
            ps.setString(1, description + "%");
            ps.setString(2, description.toLowerCase() + "%");
            ps.setString(3, description.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                students.add(new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("email"), rs.getString("account_status")));
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
                students.add(new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("email"), rs.getString("account_status")));
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
                students.add(new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("email"), rs.getString("account_status")));
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
                return new Student(rs.getLong("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("faculty_id"), rs.getInt("branch_id"), rs.getString("email"), rs.getString("account_status"), rs.getTimestamp("LAST_TIME"));
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
            ps.setLong(1, s.getId());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            ps.setString(4, s.getPassword());
            ps.setInt(5, s.getFaculty_id());
            ps.setInt(6, s.getBranch_id());
            ps.setString(7, s.getEmail());
            ps.setString(8, "active");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
    }
    
    public boolean editStudentInfo(Student s){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(EDIT_STUDENT_INFO);
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getPassword());
            ps.setInt(4, s.getFaculty_id());
            ps.setInt(5, s.getBranch_id());
            ps.setString(6, s.getEmail());
            ps.setString(7, s.getAccount_status());
            ps.setLong(8, s.getId());
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
    
    public static void main(String[] args) {
        Studentdao sdao = new Studentdao();
       // Student s = new Student(611305, "firstName", "lastName", "password", 1, 2,"mail@mail");
        //sdao.addStudent(s);
        System.out.println(sdao.getStudentByMail("int303.quizhub@gmail.com"));
    }
    
}
