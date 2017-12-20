package com.dreamteam.archive.service.catchservice;

import com.data.Archive;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GridFsServiceImpl implements GridFsService {
    @Autowired
    GridFsOperations gridOperations;

    // this variable is used to store ImageId for other actions like: findOne or delete
    private String imageFileId = "";

    @Override
    public String saveFiles(String name,MultipartFile file){
        // Define metaData
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name  + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name  + " потому что файл пустой.";
        }
        System.out.println("Вы удачно загрузили " +name  + " в " + name  + "-uploaded !");
        DBObject metaData = new BasicDBObject();
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
