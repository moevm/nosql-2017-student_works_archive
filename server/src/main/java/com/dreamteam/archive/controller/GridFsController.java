package com.dreamteam.archive.controller;


import java.util.List;
import com.data.Archive;
import com.dreamteam.archive.service.catchservice.GridFsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/files")
public class GridFsController {
    GridFsService gridFsService;

    GridFsController(GridFsService gridFsService){
        this.gridFsService =gridFsService;
    }

    @PostMapping
    @RequestMapping("/save")
    public String save(@RequestBody List<Archive> element) {

        return gridFsService.saveFiles(element);
    }

    @PostMapping
    @RequestMapping("/get")
    public String retrieveText(@RequestBody String fileId){

        return gridFsService.retrieveTextFiles(fileId);
    }

    @GetMapping("/delete")
    public String delete(@RequestBody String fileId){
        return gridFsService.deleteFile(fileId);
    }
}
