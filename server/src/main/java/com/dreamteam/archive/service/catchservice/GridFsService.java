package com.dreamteam.archive.service.catchservice;

import com.data.Archive;
import java.util.List;

public interface GridFsService {
    String saveFiles(List<Archive> element);
    String retrieveTextFiles(String fileId);
    String deleteFile(String fileId);
}
