package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.CompanyRequestDto;
import com.example.ASYNDM.ASYNDM.dto.DepartmentRequestDto;
import com.example.ASYNDM.ASYNDM.dto.EmployeeRequestDto;
import com.example.ASYNDM.ASYNDM.entity.Company;
import com.example.ASYNDM.ASYNDM.entity.Department;
import com.example.ASYNDM.ASYNDM.entity.Employee;
import com.example.ASYNDM.ASYNDM.entity.LogTable;
import com.example.ASYNDM.ASYNDM.repository.CompanyRepository;
import com.example.ASYNDM.ASYNDM.repository.LogTableRepository;
import com.example.ASYNDM.ASYNDM.service.BatchEntryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BatchEntryServiceImpl implements BatchEntryService {

    private final LogTableRepository logTableRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void AddCompanyDeptEmployee() throws JsonProcessingException {

        List<LogTable> logTables = logTableRepository.findAllByStatus(0);

        for (LogTable logTable: logTables){
            List<Employee> employeeList = new ArrayList<>();
            List<Department> departmentList = new ArrayList<>();

            ObjectMapper objectMapper = new ObjectMapper();
            CompanyRequestDto companyDto = objectMapper.readValue(logTable.getCompany(), CompanyRequestDto.class);
            DepartmentRequestDto departmentDto = objectMapper.readValue(logTable.getDepartment(), DepartmentRequestDto.class);
            EmployeeRequestDto employeeDto = objectMapper.readValue(logTable.getEmployee(), EmployeeRequestDto.class);

            Employee employee = new Employee();
            employee.setEmployeeIdentifier(employeeDto.getEmployeeIdentifier());
            employee.setEmployeeName(employeeDto.getEmployeeName());
            employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
            employee.setEmployeeContact(employeeDto.getEmployeeContact());
            employeeList.add(employee);

            Department department = new Department();
            department.setDepartmentIdentifier(departmentDto.getDepartmentIdentifier());
            department.setDepartmentName(departmentDto.getDepartmentName());
            department.setDepartmentPrefix(departmentDto.getDepartmentPrefix());
            department.setEmployeeList(employeeList);
            departmentList.add(department);

            Company company = new Company();
            company.setCompanyIdentifier(companyDto.getCompanyIdentifier());
            company.setCompanyName(companyDto.getCompanyName());
            company.setCompanyEmail(companyDto.getCompanyEmail());
            company.setCompanyContact(companyDto.getCompanyContact());
            company.setDepartmentList(departmentList);

            companyRepository.save(company);

            logTable.setStatus(1);
            logTableRepository.save(logTable);
        }
    }



}
