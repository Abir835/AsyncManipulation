package com.example.ASYNDM.ASYNDM.controller;

import com.example.ASYNDM.ASYNDM.dto.CompanyRequestDto;
import com.example.ASYNDM.ASYNDM.dto.CompanyResponseDto;
import com.example.ASYNDM.ASYNDM.dto.DepartmentRequestDto;
import com.example.ASYNDM.ASYNDM.dto.EmployeeRequestDto;
import com.example.ASYNDM.ASYNDM.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Controller
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/company")
    public String company(Model model, Principal principal) {
        List<CompanyResponseDto> companyList = companyService.findAll();
        model.addAttribute("companyList",companyList);
        boolean loggedIn = (principal != null);
        model.addAttribute("loggedIn", loggedIn);
        return "company/company";
    }

    @GetMapping("/company/add")
    public String companyAdd(Model model, Principal principal) {
        boolean loggedIn = (principal != null);
        model.addAttribute("loggedIn", loggedIn);
        return "company/company-add";
    }

    @PostMapping("/create-batch")
    public String batchEntry(
            @ModelAttribute CompanyRequestDto company,
            @ModelAttribute DepartmentRequestDto department,
            @ModelAttribute EmployeeRequestDto employee,
            Model model
    ) throws JsonProcessingException {

        companyService.saveBatch(company, department, employee);

        return "redirect:/";
    }

}
