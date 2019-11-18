
package model;

public class QuizScore {
    double score;
    double fullScore;
    double percent;
    String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public QuizScore(double score,double fullScore) {
        this.score = score;
        this.fullScore = fullScore;
        this.percent = (score/fullScore)*100;
    }

    public QuizScore(double score, double fullScore,String skill) {
        this.score = score;
        this.fullScore = fullScore;
        this.percent = (score/fullScore)*100;
        this.skill = skill;
    }
    

    public double getScore() {
        return score;
    }

    public double setScore(double score) {
        this.score = score;
        return score;
    }

    public double getFullScore() {
        return fullScore;
    }

    public void setFullScore(double fullScore) {
        this.fullScore = fullScore;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "QuizScore{" + "score=" + score + ", fullScore=" + fullScore + ", percent=" + percent + ", skill=" + skill + '}';
    }

   


  

  
    
    

    
}
