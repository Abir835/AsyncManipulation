package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.*;
import com.example.ASYNDM.ASYNDM.entity.Company;
import com.example.ASYNDM.ASYNDM.entity.LogTable;
import com.example.ASYNDM.ASYNDM.entity.User;
import com.example.ASYNDM.ASYNDM.mapper.CompanyMapper;
import com.example.ASYNDM.ASYNDM.repository.CompanyRepository;
import com.example.ASYNDM.ASYNDM.repository.LogTableRepository;
import com.example.ASYNDM.ASYNDM.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final LogTableRepository logTableRepository;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


    @Override
    public void saveBatch(CompanyRequestDto company, DepartmentRequestDto department, EmployeeRequestDto employee) throws JsonProcessingException {

        LogTableDto logTableDto = new LogTableDto();
        ObjectMapper objectMapper = new ObjectMapper();

        company.setCompanyIdentifier(UUID.randomUUID().toString());
        department.setDepartmentIdentifier(UUID.randomUUID().toString());
        employee.setEmployeeIdentifier(UUID.randomUUID().toString());

        logTableDto.setCompany(objectMapper.writeValueAsString(company));
        logTableDto.setEmployee(objectMapper.writeValueAsString(employee));
        logTableDto.setDepartment(objectMapper.writeValueAsString(department));

        LogTable logTable = new LogTable();

        logTable.setCompany(logTableDto.getCompany());
        logTable.setDepartment(logTableDto.getDepartment());
        logTable.setEmployee(logTableDto.getEmployee());
        logTable.setStatus(0);

        logTableRepository.save(logTable);
    }

    @Override
    public List<CompanyResponseDto> findAll() {
        List<Company> companyList = companyRepository.findAll();
        return
                companyList.stream()
                        .map(companyMapper::entityToDto)
                        .collect(Collectors.toList());
    }


}
