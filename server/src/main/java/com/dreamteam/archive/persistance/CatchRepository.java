package com.dreamteam.archive.persistance;

import com.dreamteam.archive.model.Archive;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public interface CatchRepository extends MongoRepository<Archive, String>{
    @Query("{ 'title':?0, 'subject':?1, 'grade':?2, 'teacherName':?3, 'studentId':?4, 'studentName':?5, 'group':?6, 'date':?7}")
    List<Archive> find(Pattern title,Pattern subject,Pattern grade,Pattern teacherName,Pattern studentId,Pattern studentName,Pattern group,Pattern date);
}
