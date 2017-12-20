package com.dreamteam.archive.service.catchservice;

import com.data.Archive;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.stereotype.Service;

@Service
public class GridFsServiceImpl implements GridFsService {
    @Autowired
    GridFsOperations gridOperations;

    // this variable is used to store ImageId for other actions like: findOne or delete
    private String imageFileId = "";
    @Override
    public String saveFiles(List<Archive> element){
        // Define metaData
        DBObject metaData = new BasicDBObject();
        metaData.put("organization", "JavaSampleApproach");

        /**
         * 1. save an image file to MongoDB
         */

        // Get input file
        try {
            InputStream iamgeStream = new FileInputStream("D:\\JSA\\jsa-logo.png");

            metaData.put("type", "image");

            // Store file to MongoDB
            imageFileId = gridOperations.store(iamgeStream, "jsa-logo.png", "image/png", metaData).getId().toString();
            System.out.println("ImageFileId = " + imageFileId);

            /**
             * 2. save text files to MongoDB
             */

            // change metaData
            metaData.put("type", "data");

            // Store files to MongoDb
            gridOperations.store(new FileInputStream("D:\\JSA\\text-1.txt"), "text-1.txt", "text/plain", metaData);
            gridOperations.store(new FileInputStream("D:\\JSA\\text-2.txt"), "text-2.txt", "text/plain", metaData);
            System.out.println("Работает");
            return "Done";
        }catch (FileNotFoundException ex) {
            System.out.println("Error downland file");
            return "Error downland file";
        }
    }
    @Override
    public GridFSDBFile retrieveTextFiles(String fileId){
        GridFSDBFile textFiles = gridOperations.findOne(new Query(Criteria.where("_id").is(fileId)));
        return textFiles;
    }
    @Override
    public String deleteFile(String fileId){
        // delete image via id
        gridOperations.delete(new Query(Criteria.where("_id").is(fileId)));
       return "Done";
    }
}
