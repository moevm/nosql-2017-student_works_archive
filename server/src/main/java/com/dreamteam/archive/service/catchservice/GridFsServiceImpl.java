package com.dreamteam.archive.service.catchservice;



import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import java.io.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GridFsServiceImpl implements GridFsService {
    @Autowired
    GridFsOperations gridOperations;


    @Override
    public GridFSDBFile retrieveTextFiles(String fileId){
        System.out.println("Внутри");
        GridFSDBFile textFiles = gridOperations.findOne(new Query(Criteria.where("_id").is(fileId)));
        System.out.println(textFiles);
        return textFiles;
    }
    @Override
    public String deleteFile(String fileId){
        gridOperations.delete(new Query(Criteria.where("_id").is(fileId)));
        return "Done";
    }
}
