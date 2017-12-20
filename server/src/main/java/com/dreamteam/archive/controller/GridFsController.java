package com.dreamteam.archive.controller;


import java.util.List;
import com.data.Archive;
import com.dreamteam.archive.service.catchservice.GridFsService;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> retrieveText(@RequestParam(value="file") String fileId){
        GridFSDBFile gridFsFile =gridFsService.retrieveTextFiles(fileId);
        return ResponseEntity.ok()
                .contentLength(gridFsFile.getLength())
                .contentType(MediaType.parseMediaType(gridFsFile.getContentType()))
                .body(new InputStreamResource(gridFsFile.getInputStream()));
    }

    @GetMapping("/delete")
    public String delete(@RequestBody String fileId){
        return gridFsService.deleteFile(fileId);
    }
}
