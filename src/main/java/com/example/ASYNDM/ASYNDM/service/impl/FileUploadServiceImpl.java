package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.CompanyRequestDto;
import com.example.ASYNDM.ASYNDM.dto.DepartmentDto;
import com.example.ASYNDM.ASYNDM.dto.DepartmentRequestDto;
import com.example.ASYNDM.ASYNDM.dto.EmployeeRequestDto;
import com.example.ASYNDM.ASYNDM.service.CompanyService;
import com.example.ASYNDM.ASYNDM.service.FileUploadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final CompanyService companyService;
    @Override
    public void saveFile(MultipartFile file) throws Exception {

        if (!Objects.requireNonNull(file.getOriginalFilename()).toLowerCase().endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file format. Please upload a CSV file.");
        }

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                final String[] data = line.split(",");
                final CompanyRequestDto companyRequestDto = new CompanyRequestDto();
                final DepartmentRequestDto departmentRequestDto = new DepartmentRequestDto();
                final EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto();
                if(data.length == 0){}
                else{
                    if(data[0].trim().equals("company name") || data[1].trim().equals("company contact")
                            || data[2].trim().equals("company email") || data[4].trim().equals("department name")
                            || data[5].trim().equals("department prefix") || data[6].trim().equals("employee name")
                            || data[7].trim().equals("employee contact")|| data[8].trim().equals("employee email")
                    ){}
                    else{
                        companyRequestDto.setCompanyName(data[0].trim());
                        companyRequestDto.setCompanyContact(data[1].trim());
                        companyRequestDto.setCompanyEmail(data[2].trim());

                        departmentRequestDto.setDepartmentName(data[4].trim());
                        departmentRequestDto.setDepartmentPrefix(data[5].trim());

                        employeeRequestDto.setEmployeeName(data[7].trim());
                        employeeRequestDto.setEmployeeContact(data[8].trim());
                        employeeRequestDto.setEmployeeEmail(data[9].trim());

                        companyService.saveBatch(companyRequestDto, departmentRequestDto, employeeRequestDto);
                    }
                }

            }
            return ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
