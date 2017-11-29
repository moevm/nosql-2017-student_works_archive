package com.dreamteam.archive.controller;

import com.dreamteam.archive.model.Archive;
import com.dreamteam.archive.service.catchservice.CatchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping(value="/api/files")
public class CatchController {
    CatchService catchService;
    //CatchController catchController;

    CatchController(CatchService catchService){
        this.catchService =catchService;
        //this.catchController = catchController;
    }

    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQuery(@RequestParam("grade")String grade){
        return new ResponseEntity<List<Archive>>(catchService.getByGrade(grade), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQueryTitle(@RequestParam("title")String title){
        return new ResponseEntity<List<Archive>>(catchService.getByTitle(title), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQueryDate(@RequestParam("date")String date){
        return new ResponseEntity<List<Archive>>(catchService.getByDate(date), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQueryStudentId(@RequestParam("studentId")String studentId){
        return new ResponseEntity<List<Archive>>(catchService.getByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQuerySubject(@RequestParam("subject")String subject){
        return new ResponseEntity<List<Archive>>(catchService.getBySubject(subject), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQueryTeacherName(@RequestParam("teacherName")String teacherName){
        return new ResponseEntity<List<Archive>>(catchService.getByTeacherName(teacherName), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQueryStudentName(@RequestParam("studentName")String studentName){
        return new ResponseEntity<List<Archive>>(catchService.getByStudentName(studentName), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping
    public ResponseEntity<?> getQueryGroup(@RequestParam("group")String group){
        return new ResponseEntity<List<Archive>>(catchService.getByGroup(group), HttpStatus.OK);
    }
}
