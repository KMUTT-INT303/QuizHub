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
public class Branch {
    private int id;
    private String name;
    private int faculty_id;

    public Branch(int id, String name, int faculty_id) {
        this.id = id;
        this.name = name;
        this.faculty_id = faculty_id;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Branch{" + "id=" + id + ", name=" + name + ", faculty_id=" + faculty_id + '}';
    }
    
    
}
