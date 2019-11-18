
package model;

public class SkillStat {
    String name;
    double allPercent;
    double quantityOfSameSkillQuiz;
    double averagePercent;

    public SkillStat(String name, double allPercent, double quantityOfSameSkillQuiz) {
        this.name = name;
        this.allPercent = allPercent;
        this.quantityOfSameSkillQuiz = quantityOfSameSkillQuiz;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAllPercent() {
        return allPercent;
    }

    public void setAllPercent(double allPercent) {
        this.allPercent = allPercent;
    }

    public double getQuantityOfSameSkillQuiz() {
        return quantityOfSameSkillQuiz;
    }

    public void setQuantityOfSameSkillQuiz(double quantityOfSameSkillQuiz) {
        this.quantityOfSameSkillQuiz = quantityOfSameSkillQuiz;
    }

    public double getAveragePercent() {
        return allPercent/quantityOfSameSkillQuiz;
    }

    public void setAveragePercent(double averagePercent) {
        this.averagePercent = averagePercent;
    }

    @Override
    public String toString() {
        return "SkillStat{" + "name=" + name + ", allPercent=" + allPercent + ", quantityOfSameSkillQuiz=" + quantityOfSameSkillQuiz + ", averagePercent=" + averagePercent + '}';
    }
    
}
