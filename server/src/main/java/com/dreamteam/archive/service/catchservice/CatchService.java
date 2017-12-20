package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.model.StatisticPercentOfGrades;
import com.dreamteam.archive.model.StatisticSubjectGrades;

import java.util.List;
import java.util.Map;

public interface CatchService {
    List<Archive> getFind(Map<String,String> json);
    List<StatisticPercentOfGrades> getStatisticPercentOfGrades(Map<String,String> json);
    List<StatisticSubjectGrades> getStatisticSubjectGrades(Map<String,String> json);
}
