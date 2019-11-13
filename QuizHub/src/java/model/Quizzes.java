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
public class Quizzes {

    private String quizName;
    private String quizComment;
    private String quizStatus;
    private long quizTeacherId;
    private String quizCourseName;
    private String quizCourseId;
    private int quizFacultyId;
    private int quizBranchId;
    private String quizCode;
    private String quizCoverImages;
    private String quizSkillText;
    private Timestamp quizStartDate;
    private Timestamp quizEndDate;

    public Quizzes() {
    }

    public Quizzes(String quizName, String quizComment, String quizStatus, long quizTeacherId, String quizCourseName, String quizCourseId, int quizFacultyId, int quizBranchId, String quizCode, String quizCoverImages, String quizSkillText, Timestamp quizStartDate, Timestamp quizEndDate) {
        this.quizName = quizName;
        this.quizComment = quizComment;
        this.quizStatus = quizStatus;
        this.quizTeacherId = quizTeacherId;
        this.quizCourseName = quizCourseName;
        this.quizCourseId = quizCourseId;
        this.quizFacultyId = quizFacultyId;
        this.quizBranchId = quizBranchId;
        this.quizCode = quizCode;
        this.quizCoverImages = quizCoverImages;
        this.quizSkillText = quizSkillText;
        this.quizStartDate = quizStartDate;
        this.quizEndDate = quizEndDate;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizComment() {
        return quizComment;
    }

    public void setQuizComment(String quizComment) {
        this.quizComment = quizComment;
    }

    public String getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(String quizStatus) {
        this.quizStatus = quizStatus;
    }

    public long getQuizTeacherId() {
        return quizTeacherId;
    }

    public void setQuizTeacherId(long quizTeacherId) {
        this.quizTeacherId = quizTeacherId;
    }

    public String getQuizCourseName() {
        return quizCourseName;
    }

    public void setQuizCourseName(String quizCourseName) {
        this.quizCourseName = quizCourseName;
    }

    public String getQuizCourseId() {
        return quizCourseId;
    }

    public void setQuizCourseId(String quizCourseId) {
        this.quizCourseId = quizCourseId;
    }

    public int getQuizFacultyId() {
        return quizFacultyId;
    }

    public void setQuizFacultyId(int quizFacultyId) {
        this.quizFacultyId = quizFacultyId;
    }

    public int getQuizBranchId() {
        return quizBranchId;
    }

    public void setQuizBranchId(int quizBranchId) {
        this.quizBranchId = quizBranchId;
    }

    public String getQuizCode() {
        return quizCode;
    }

    public void setQuizCode(String quizCode) {
        this.quizCode = quizCode;
    }

    public String getQuizCoverImages() {
        return quizCoverImages;
    }

    public void setQuizCoverImages(String quizCoverImages) {
        this.quizCoverImages = quizCoverImages;
    }

    public String getQuizSkillText() {
        return quizSkillText;
    }

    public void setQuizSkillText(String quizSkillText) {
        this.quizSkillText = quizSkillText;
    }

    public Timestamp getQuizStartDate() {
        return quizStartDate;
    }

    public void setQuizStartDate(Timestamp quizStartDate) {
        this.quizStartDate = quizStartDate;
    }

    public Timestamp getQuizEndDate() {
        return quizEndDate;
    }

    public void setQuizEndDate(Timestamp quizEndDate) {
        this.quizEndDate = quizEndDate;
    }

    @Override
    public String toString() {
        return "Quizzes{" + "quizName=" + quizName + ", quizComment=" + quizComment + ", quizStatus=" + quizStatus + ", quizTeacherId=" + quizTeacherId + ", quizCourseName=" + quizCourseName + ", quizCourseId=" + quizCourseId + ", quizFacultyId=" + quizFacultyId + ", quizBranchId=" + quizBranchId + ", quizCode=" + quizCode + ", quizCoverImages=" + quizCoverImages + ", quizSkillText=" + quizSkillText + ", quizStartDate=" + quizStartDate + ", quizEndDate=" + quizEndDate + '}';
    }

}