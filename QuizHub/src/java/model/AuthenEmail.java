/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Top
 */
public class AuthenEmail {
    private int id;
    private String code;
    private long teacher_id;
    private Timestamp created_Time;
    private Timestamp remove_Time;

    public AuthenEmail(String code, long teacher_id, Timestamp created_Time) {
        this.code = code;
        this.teacher_id = teacher_id;
        this.created_Time = created_Time;
        this.remove_Time = remove_Time;
    }
    
    public AuthenEmail(int id, String code, long teacher_id, Timestamp created_Time) {
        this.id = id;
        this.code = code;
        this.teacher_id = teacher_id;
        this.created_Time = created_Time;
        this.remove_Time = remove_Time;
    }

    public AuthenEmail(int id, String code, long teacher_id, Timestamp created_Time, Timestamp remove_Time) {
        this.id = id;
        this.code = code;
        this.teacher_id = teacher_id;
        this.created_Time = created_Time;
        this.remove_Time = remove_Time;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Timestamp getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(Timestamp created_Time) {
        this.created_Time = created_Time;
    }

    public void setRemove_Time(Timestamp remove_Time) {
        this.remove_Time = remove_Time;
    }
    
    public Timestamp getRemove_Time() {     
        long t = getCreated_Time().getTime() + 60000;
        DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date result = new Date(t);
        //System.out.println(simple.format(result));
        remove_Time = Timestamp.valueOf(simple.format(result));
        return remove_Time;
    }


    @Override
    public String toString() {
        return "AuthenEmail{" + "id=" + id + ", code=" + code + ", teacher_id=" + teacher_id + ", created_Time=" + created_Time + ", remove_Time=" + remove_Time + '}';
    }


   
    
    
}
