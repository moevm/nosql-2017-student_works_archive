package com.dreamteam.archive.controller;

import com.dreamteam.archive.model.Archive;
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
    @RequestMapping()
    public ResponseEntity<?> getQueryGroup(@RequestBody String json)  {
        Map p=new HashMap<String, String>();
        p.put("date","2017");
        System.out.println(json);
        return new ResponseEntity<List<Archive>>(catchService.getFind(p), HttpStatus.OK);
    }
}
