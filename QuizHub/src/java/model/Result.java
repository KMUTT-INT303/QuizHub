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
public class Result {
    private int result_id;
    private String total_time;
    private int totalCorrect;
    private int totalIncorrect;
    private int quizId;
    private long studentId;
    private Timestamp result_date;

    public Result() {
    }

    public Result(int result_id, String total_time, int totalCorrect, int totalIncorrect, int quizId, long studentId, Timestamp result_date) {
        this.result_id = result_id;
        this.total_time = total_time;
        this.totalCorrect = totalCorrect;
        this.totalIncorrect = totalIncorrect;
        this.quizId = quizId;
        this.studentId = studentId;
        this.result_date = result_date;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    public int getTotalIncorrect() {
        return totalIncorrect;
    }

    public void setTotalIncorrect(int totalIncorrect) {
        this.totalIncorrect = totalIncorrect;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Timestamp getResult_date() {
        return result_date;
    }

    public void setResult_date(Timestamp result_date) {
        this.result_date = result_date;
    }

    @Override
    public String toString() {
        return "Result{" + "result_id=" + result_id + ", total_time=" + total_time + ", totalCorrect=" + totalCorrect + ", totalIncorrect=" + totalIncorrect + ", quizId=" + quizId + ", studentId=" + studentId + ", result_date=" + result_date + '}';
    }
   
}
