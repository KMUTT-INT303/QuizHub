/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Top
 */
public class Teacher {
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private int faculty_id;
    private String email;
    private String account_status;

    public Teacher() {
    }

    public Teacher(long id, String firstName, String lastName, String password, int faculty_id, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.faculty_id = faculty_id;
        this.email = email;
    }

    public Teacher(long id, String firstName, String lastName, String password, int faculty_id, String email, String account_status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.faculty_id = faculty_id;
        this.email = email;
        this.account_status = account_status;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", faculty_id=" + faculty_id + ", email=" + email + ", account_status=" + account_status + '}';
    }

    public String getFullname(){
        String fullname = getFirstName() + " " + getLastName();
        return fullname;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }


    
    
}
