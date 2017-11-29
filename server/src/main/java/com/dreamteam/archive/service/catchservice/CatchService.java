package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;

import java.util.List;

public interface CatchService {
    public List<Archive> getByGrade(String grade);
    public List<Archive> getByTitle(String title);
    public List<Archive> getBySubject(String subject);
    public List<Archive> getByTeacherName(String teacherName);
    public List<Archive> getByStudentId(String studentId);
    public List<Archive> getByStudentName(String studentName);
    public List<Archive> getByGroup(String group);
    public List<Archive> getByDate(String date);

}
