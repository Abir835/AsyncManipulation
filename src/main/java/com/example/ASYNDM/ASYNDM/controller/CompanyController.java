package com.example.ASYNDM.ASYNDM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
    @GetMapping("/company")
    public String company() {
        return "company/company";
    }
    @GetMapping("/company/add")
    public String companyAdd() {
        return "company/company-add";
    }

}
