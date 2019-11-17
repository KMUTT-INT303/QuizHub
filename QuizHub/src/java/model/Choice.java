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
public class Choice {
    private int choiceId;
    private String choiceName;
    private String choiceCorrect;
    private int questionId;

    public Choice() {
    }

    public Choice(int choiceId, String choiceName, String choiceCorrect, int questionId) {
        this.choiceId = choiceId;
        this.choiceName = choiceName;
        this.choiceCorrect = choiceCorrect;
        this.questionId = questionId;
    }

    public Choice(String choiceName, String choiceCorrect, int questionId) {
        this.choiceName = choiceName;
        this.choiceCorrect = choiceCorrect;
        this.questionId = questionId;
    }

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }

    public String isChoiceCorrect() {
        return choiceCorrect;
    }

    public void setChoiceCorrect(String choiceCorrect) {
        this.choiceCorrect = choiceCorrect;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Choice{" + "choiceId=" + choiceId + ", choiceName=" + choiceName + ", choiceCorrect=" + choiceCorrect + ", questionId=" + questionId + '}';
    }
    
}
