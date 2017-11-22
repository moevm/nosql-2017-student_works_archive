package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.persistance.CatchRepository;
import org.springframework.stereotype.Service;

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
}
