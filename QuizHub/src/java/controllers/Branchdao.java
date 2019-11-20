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
import model.Branch;

/**
 *
 * @author Top
 */
public class Branchdao {
    
    Connection conn = null;
    
    
    public boolean setBranchName(Branch b){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE branch SET name = ? WHERE id = ?");
            ps.setString(1, b.getName());
            ps.setInt(2, b.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Branchdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Branch> getAllBranch(){
        ArrayList<Branch> branch = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM branch");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                branch.add(new Branch(rs.getInt("branch_id"), rs.getString("branch_name"), rs.getInt("faculty_id")));
            }return branch;
        } catch (SQLException ex) {
            Logger.getLogger(Branchdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Branch> getAllBranchInFacultyByFacultyId(int fid){
        ArrayList<Branch> branch = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM branch WHERE faculty_id = ?");
            ps.setInt(1, fid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                branch.add(new Branch(rs.getInt("branch_id"), rs.getString("branch_name"), rs.getInt("faculty_id")));
            }return branch;
        } catch (SQLException ex) {
            Logger.getLogger(Branchdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Branch getBranchById(int bid){
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareCall("SELECT * FROM branch WHERE branch_id = ?");
            ps.setInt(1, bid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Branch(rs.getInt("branch_id"), rs.getString("branch_name"), rs.getInt("faculty_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Branchdao.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static void main(String[] args) {
        Branchdao bdao = new Branchdao();
        ArrayList<Branch> bs = bdao.getAllBranchInFacultyByFacultyId(1);
        //System.out.println(bs);
        Branch b = bdao.getBranchById(3);
        System.out.println(b);
    }
}
