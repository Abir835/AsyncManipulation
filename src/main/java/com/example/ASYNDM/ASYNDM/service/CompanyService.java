package com.example.ASYNDM.ASYNDM.service;

import com.example.ASYNDM.ASYNDM.dto.CompanyRequestDto;
import com.example.ASYNDM.ASYNDM.dto.CompanyResponseDto;
import com.example.ASYNDM.ASYNDM.dto.DepartmentRequestDto;
import com.example.ASYNDM.ASYNDM.dto.EmployeeRequestDto;
import com.example.ASYNDM.ASYNDM.entity.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    void saveBatch(CompanyRequestDto company, DepartmentRequestDto department, EmployeeRequestDto employee) throws JsonProcessingException;
    List<CompanyResponseDto> findAll();
}
