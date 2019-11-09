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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

/**
 *
 * @author Top
 */
public class Admindao {
    Connection conn;
    public Admin getAdminById(long aid){
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM admins WHERE admin_id = ?");
            ps.setLong(1, aid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Admin(rs.getLong("admin_id"), rs.getString("first_name"), rs.getString("last_name"),rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admindao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public static void main(String[] args) {
        Admindao adao = new Admindao();
        Admin a = adao.getAdminById(000);
        System.out.println(a);
    }
}
