package com.dreamteam.archive.model;

public class StatisticSubjectGrades {

    private String subject;

    private String average;

    public StatisticSubjectGrades(String subject, String average){
        setAverage(average);
        setSubject(subject);
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}