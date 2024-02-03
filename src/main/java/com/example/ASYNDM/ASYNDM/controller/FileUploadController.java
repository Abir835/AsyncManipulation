package com.example.ASYNDM.ASYNDM.controller;

import com.example.ASYNDM.ASYNDM.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @GetMapping("/file-upload")
    public String fileUploadPage(Model model, Principal principal) {
        boolean loggedIn = (principal != null);
        model.addAttribute("loggedIn", loggedIn);
        return "file_upload";
    }

    @PostMapping("/save-file")
    public String saveFileReadData(@RequestParam MultipartFile file) throws Exception {
        fileUploadService.saveFile(file);
        return "redirect:/";
    }

}
