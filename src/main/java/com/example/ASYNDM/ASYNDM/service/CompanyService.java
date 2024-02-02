package com.example.ASYNDM.ASYNDM.service;

import com.example.ASYNDM.ASYNDM.dto.CompanyRequestDto;
import com.example.ASYNDM.ASYNDM.dto.DepartmentRequestDto;
import com.example.ASYNDM.ASYNDM.dto.EmployeeRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    void saveBatch(CompanyRequestDto company, DepartmentRequestDto department, EmployeeRequestDto employee) throws JsonProcessingException;

}
