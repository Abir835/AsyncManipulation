package com.example.ASYNDM.ASYNDM.controller;

import com.example.ASYNDM.ASYNDM.dto.DepartmentResponseDto;
import com.example.ASYNDM.ASYNDM.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/department")
    public String department(Model model) {
        List<DepartmentResponseDto> dto = departmentService.findAll();
        model.addAttribute("department",dto);
        return "department/department";
    }
}
