package com.dreamteam.archive.service.catchservice;


import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.web.multipart.MultipartFile;


public interface GridFsService {
    GridFSDBFile retrieveTextFiles(String fileId);
    String deleteFile(String fileId);
}
