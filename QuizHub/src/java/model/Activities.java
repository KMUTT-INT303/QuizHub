/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author tsch
 */
public class Activities {

    private int activities_id;
    private Timestamp activities_date;

    public Activities(int activities_id, Timestamp activities_date) {
        this.activities_id = activities_id;
        this.activities_date = activities_date;
    }

    public int getActivities_id() {
        return activities_id;
    }

    public void setActivities_id(int activities_id) {
        this.activities_id = activities_id;
    }

    public Timestamp getActivities_date() {
        return activities_date;
    }

    public void setActivities_date(Timestamp activities_date) {
        this.activities_date = activities_date;
    }

    @Override
    public String toString() {
        return "Activities{" + "activities_id=" + activities_id + ", activities_date=" + activities_date + '}';
    }
    
}
