package com.example.ASYNDM.ASYNDM.controller;

import com.example.ASYNDM.ASYNDM.dto.CompanyRequestDto;
import com.example.ASYNDM.ASYNDM.dto.DepartmentRequestDto;
import com.example.ASYNDM.ASYNDM.dto.EmployeeRequestDto;
import com.example.ASYNDM.ASYNDM.service.BatchEntryService;
import com.example.ASYNDM.ASYNDM.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BatchEntryController {

    private final BatchEntryService batchEntryService;

    @GetMapping("/batch-entry")
    public String batchEntry() throws JsonProcessingException {
        batchEntryService.AddCompanyDeptEmployee();
        return "redirect:/";
    }

}
