package com.dreamteam.archive.service.catchservice;

import com.data.Archive;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.web.multipart.MultipartFile;


public interface GridFsService {
    String saveFiles(String name,MultipartFile file);
    GridFSDBFile retrieveTextFiles(String fileId);
    String deleteFile(String fileId);
}
