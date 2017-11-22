package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;

import java.util.List;

public interface CatchService {
    public List<Archive> getByGrade(String grade);
}
