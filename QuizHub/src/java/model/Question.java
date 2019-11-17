/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tsch
 */
public class Question {
    private int questionId;
    private String questionName;
    private int quizId;

    public Question(int questionId, String questionName, int quizId) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.quizId = quizId;
    }

    public Question(String questionName, int quizId) {
        this.questionName = questionName;
        this.quizId = quizId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString() {
        return "Question{" + "questionId=" + questionId + ", questionName=" + questionName + ", quizId=" + quizId + '}';
    }
    
}
