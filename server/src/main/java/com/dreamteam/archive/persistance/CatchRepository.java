package com.dreamteam.archive.persistance;

import com.dreamteam.archive.model.Archive;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CatchRepository extends MongoRepository<Archive, String>{
    List<Archive> findByGrade(int grade);
    List<Archive> findByTitle(String title);
    List<Archive> findBySubject(String subject);
    List<Archive> findByTeacgerName(String teacgerName);
    List<Archive> findByStudentId(String studentId);
    List<Archive> findByStudentName(String studentName);
    List<Archive> findByGroup(String group);
    List<Archive> findByDate(LocalDateTime date);

}
