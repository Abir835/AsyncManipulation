package com.example.ASYNDM.ASYNDM.controller;

import com.example.ASYNDM.ASYNDM.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @GetMapping("/file-upload")
    public String fileUploadPage() {
        return "file_upload";
    }

    @PostMapping("/save-file")
    public String saveFileReadData(@RequestParam MultipartFile file) throws Exception {
        fileUploadService.saveFile(file);
        return "redirect:/";
    }

}
