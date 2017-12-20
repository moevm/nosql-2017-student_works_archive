package com.dreamteam.archive.model;

public class StatisticPercentOfGrades {
    private String grade;
    private String percent;

    public StatisticPercentOfGrades(String grade){
        setGrade(grade);
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public void setPercent(String percent){
        this.percent = percent;
    }

    public String getGrade(){
        return this.grade;
    }

    public String getPercent(){
        return this.percent;
    }
}
