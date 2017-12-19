package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;

import java.util.List;
import java.util.Map;

public interface CatchService {
    List<Archive> getFind(Map<String,String> json);
    List<?> getStatistic(Map<String,String> json);
}
