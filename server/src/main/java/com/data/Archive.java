package com.data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Date;

public class Archive {
    private ObjectId id;
    private String title;
    private String subject;
    private String grade;
    private String teatcherName;
    private String studentId;
    private String studentName;
    private String group;
    private String file;
    private String date;
    Archive(){}
    Archive(String title, String subject, String grade,String date, String teatcherName, String studentId, String studentName, String group, String file){
        this.title=title;
        this.subject=subject;
        this.grade=grade;
        this.teatcherName=teatcherName;
        this.studentId=studentId;
        this.studentName=studentName;
        this.group=group;
        this.file=file;
        this.date=date;
        this.id = new ObjectId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeatcherName() {
        return teatcherName;
    }

    public void setTeatcherName(String titcherName) {
        this.teatcherName = titcherName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
