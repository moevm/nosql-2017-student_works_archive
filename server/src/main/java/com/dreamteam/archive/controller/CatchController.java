package com.dreamteam.archive.controller;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.model.StatisticPercentOfGrades;
import com.dreamteam.archive.model.StatisticSubjectGrades;
import com.dreamteam.archive.service.catchservice.CatchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/files")
public class CatchController {
    CatchService catchService;
    //CatchController catchController;

    CatchController(CatchService catchService){
        this.catchService =catchService;
        //this.catchController = catchController;
    }

    @PostMapping
    @RequestMapping("/find")
    public ResponseEntity<?> getQueryGroup(@RequestBody Map<String, String> json)  {
        return new ResponseEntity<List<Archive>>(catchService.getFind(json), HttpStatus.OK);
    }
    @PostMapping
    @RequestMapping("/statisticPercentOfGrades")
    public ResponseEntity<?> getStatisticPercentOfGrades(@RequestBody Map<String, String> json)  {
        return new ResponseEntity<List<StatisticPercentOfGrades>>(catchService.getStatisticPercentOfGrades(json), HttpStatus.OK);

    }
    @PostMapping
    @RequestMapping("/statisticSubjectGrades")
    public ResponseEntity<?> getStatisticSubjectGrades(@RequestBody Map<String, String> json)  {
        return new ResponseEntity<List<StatisticSubjectGrades>>(catchService.getStatisticSubjectGrades(json), HttpStatus.OK);

    }
}
