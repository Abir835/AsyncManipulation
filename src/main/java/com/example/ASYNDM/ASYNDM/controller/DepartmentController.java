package com.example.ASYNDM.ASYNDM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentController {
    @GetMapping("/department")
    public String department() {
        return "department/department";
    }
}
