package com.example.ASYNDM.ASYNDM.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileUploadService {
    void saveFile(MultipartFile file) throws Exception;

}
