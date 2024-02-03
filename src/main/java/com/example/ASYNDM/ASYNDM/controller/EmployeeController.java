package com.example.ASYNDM.ASYNDM.controller;

import com.example.ASYNDM.ASYNDM.dto.EmployeeResponseDto;
import com.example.ASYNDM.ASYNDM.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public String employee(Model model) {
        List<EmployeeResponseDto> dto = employeeService.findAll();
        model.addAttribute("employee", dto);
        return "employee/employee";
    }
}
