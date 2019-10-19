/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Top
 */
public class Teacher {
    private long teacher_id;
    private String firstName;
    private String lastName;
    private String password;
    private int faculty_id;
    private String course_name;
    private String course_id;
    private String account_status;

    public Teacher() {
    }

    public Teacher(long teacher_id, String firstName, String lastName, String password, int faculty_id, String course_name, String course_id, String account_status) {
        this.teacher_id = teacher_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.faculty_id = faculty_id;
        this.course_name = course_name;
        this.course_id = course_id;
        this.account_status = account_status;
    }

    
    @Override
    public String toString() {
        return "Teacher{" + "teacher_id=" + teacher_id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", faculty_id=" + faculty_id + ", course_id=" + course_id + ", course_name=" + course_name + ", account_status=" + account_status + '}';
    }

    public long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    
    
    
}