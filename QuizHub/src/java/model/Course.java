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
public class Course {
    private int course_no;
    private String id;
    private String name;
    private Teacher teacher;

    public Course() {
    }

    public Course(int course_no, String id, String name) {
        this.course_no = course_no;
        this.id = id;
        this.name = name;
    }

    public Course(String id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public Course(int course_no, String id, String name, Teacher teacher) {
        this.course_no = course_no;
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCourse_no() {
        return course_no;
    }

    public void setCourse_no(int course_no) {
        this.course_no = course_no;
    }

    @Override
    public String toString() {
        return "Course{" + "course_no=" + course_no + ", id=" + id + ", name=" + name + ", teacher=" + teacher + '}';
    }
    
    
}
