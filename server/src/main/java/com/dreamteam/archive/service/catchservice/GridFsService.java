package com.dreamteam.archive.service.catchservice;

import com.data.Archive;
import com.mongodb.gridfs.GridFSDBFile;

import java.util.List;

public interface GridFsService {
    String saveFiles(List<Archive> element);
    GridFSDBFile retrieveTextFiles(String fileId);
    String deleteFile(String fileId);
}
