package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.persistance.CatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class CatchServiceImpl implements CatchService {

    CatchRepository catchRepository;
    CatchServiceImpl(CatchRepository catchRepository){
        this.catchRepository = catchRepository;
    }
    public List<Archive> getFind(Map<String,String> json){
        Pattern title=(json.get("title")==null)?Pattern.compile("."):Pattern.compile((String)json.get("title"));
        Pattern subject=(json.get("subject")==null)?Pattern.compile("."):Pattern.compile((String)json.get("subject"));
        Pattern grade=(json.get("grade")==null)?Pattern.compile("."):Pattern.compile((String)json.get("grade"));
        Pattern teacherName=(json.get("teacherName")==null)?Pattern.compile("."):Pattern.compile((String)json.get("teacherName"));
        Pattern studentId=(json.get("studentId")==null)?Pattern.compile("."):Pattern.compile((String)json.get("studentId"));
        Pattern studentName=(json.get("studentName")==null)?Pattern.compile("."):Pattern.compile((String)json.get("studentName"));
        Pattern group=(json.get("group")==null)?Pattern.compile("."):Pattern.compile((String)json.get("group"));
        Pattern date=(json.get("date")==null)?Pattern.compile("."):Pattern.compile((String)json.get("date"));
        return catchRepository.find(title,subject,grade,teacherName,studentId,studentName,group,date);
    }
    public List<?> getStatistic(Map<String,String> json){
        List<Archive> result = getFind(json);
        return (new ArrayList<Integer>());
    }


}
