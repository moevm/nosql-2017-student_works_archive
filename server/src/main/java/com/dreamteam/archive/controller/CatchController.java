package com.dreamteam.archive.controller;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.model.StatisticPercentOfGrades;
import com.dreamteam.archive.service.catchservice.CatchService;
import com.dreamteam.archive.service.catchservice.GridFsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/files")
public class CatchController {
    CatchService catchService;

    CatchController(CatchService catchService){
        this.catchService =catchService;
        //this.catchController = catchController;
    }

    @PostMapping
    @RequestMapping()
    public ResponseEntity<?> getQueryGroup(@RequestBody Map<String, String> json)  {
        return new ResponseEntity<List<Archive>>(catchService.getFind(json), HttpStatus.OK);
    }
    @PostMapping
    @RequestMapping("/statisticPercentOfGrades")
    public ResponseEntity<?> getStatistic(@RequestBody Map<String, String> json)  {
        return new ResponseEntity<List<StatisticPercentOfGrades>>(catchService.getStatisticPercentOfGrades(json), HttpStatus.OK);
    }
    
}
