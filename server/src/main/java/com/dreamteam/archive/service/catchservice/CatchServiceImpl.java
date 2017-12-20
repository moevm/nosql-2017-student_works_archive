package com.dreamteam.archive.service.catchservice;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.model.StatisticPercentOfGrades;
import com.dreamteam.archive.persistance.CatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<StatisticPercentOfGrades> getStatisticPercentOfGrades(Map<String,String> json){
        List<StatisticPercentOfGrades> result = new ArrayList<>(3);
        for (Integer i = 3; i <= 5; i++){
            result.add(new StatisticPercentOfGrades(i.toString()));
        }
        Double sizeOfGroup = 0.0;
        List<Integer> count = Arrays.asList(0,0,0);

        for (Archive item : this.getFind(json)) {
            if (item.getGrade().equals("3")){
                count.set(0,count.get(0)+1);
            }
            if (item.getGrade().equals("4")){
                count.set(1,count.get(1)+1);
            }
            if (item.getGrade().equals("5")){
                count.set(2,count.get(2)+1);
            }
            sizeOfGroup++;
        }

        int i = 0;
        for (StatisticPercentOfGrades item: result){
            Double percent = (Double) (count.get(i)/sizeOfGroup*100);
            item.setPercent(percent.toString());
            i++;
        }
        return result;
    }

}
