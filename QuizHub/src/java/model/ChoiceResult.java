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
public class ChoiceResult {
    private int choice_result_id;
    private int quiz_id;
    private int question_id;
    private int choice_id;
    private long student_id;

    public ChoiceResult(int choice_result_id, int quiz_id, int question_id, int choice_id, long student_id) {
        this.choice_result_id = choice_result_id;
        this.quiz_id = quiz_id;
        this.question_id = question_id;
        this.choice_id = choice_id;
        this.student_id = student_id;
    }

    public ChoiceResult(int quiz_id, int question_id, int choice_id, long student_id) {
        this.quiz_id = quiz_id;
        this.question_id = question_id;
        this.choice_id = choice_id;
        this.student_id = student_id;
    }

    public ChoiceResult() {
        
    }

    public int getChoice_result_id() {
        return choice_result_id;
    }

    public void setChoice_result_id(int choice_result_id) {
        this.choice_result_id = choice_result_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(int choice_id) {
        this.choice_id = choice_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "ChoiceResult{" + "choice_result_id=" + choice_result_id + ", quiz_id=" + quiz_id + ", question_id=" + question_id + ", choice_id=" + choice_id + ", student_id=" + student_id + '}';
    }

}
