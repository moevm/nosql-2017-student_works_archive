package com.dreamteam.archive.persistance;

import com.dreamteam.archive.model.Archive;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatchRepository extends MongoRepository<Archive, String>{
    List<Archive> findByGrade(int grade);

}
