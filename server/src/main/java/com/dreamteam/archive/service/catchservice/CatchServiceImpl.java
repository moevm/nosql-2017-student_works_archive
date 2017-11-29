package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.persistance.CatchRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CatchServiceImpl implements CatchService {

    CatchRepository catchRepository;
    CatchServiceImpl(CatchRepository catchRepository){
        this.catchRepository = catchRepository;
    }
    @Override
    public List<Archive> getByGrade(String grade) {
        return catchRepository.findByGrade(Integer.valueOf(grade));
    }
    @Override
    public List<Archive> getByTitle(String title){return catchRepository.findByTitle(title);}
    @Override
    public List<Archive> getBySubject(String subject){return catchRepository.findBySubject(subject);}
    @Override
    public List<Archive> getByTeacherName(String teacherName){return catchRepository.findByTeacherName(teacherName);}
    @Override
    public List<Archive> getByStudentId(String studentId){return catchRepository.findByStudentId(studentId);}
    @Override
    public List<Archive> getByStudentName(String studentName){return catchRepository.findByStudentName(studentName);}
    @Override
    public List<Archive> getByGroup(String group){return catchRepository.findByGroup(group);}
    @Override
    public List<Archive> getByDate(String date){return catchRepository.findByDate(LocalDateTime.parse(date, DateTimeFormatter.ISO_INSTANT));}
}
