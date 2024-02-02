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
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RequiredArgsConstructor
@Service
public class BatchEntryServiceImpl implements BatchEntryService {

    private final LogTableRepository logTableRepository;
    private final CompanyRepository companyRepository;


    @Override
    public void addCompanyDeptEmployee(List<LogTable> logTableList) throws JsonProcessingException {

        for (LogTable logTable : logTableList) {
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

    @Scheduled(cron = "0 * * * * ?")
    @Override
    public void runScheduler() {
        List<LogTable> logTables = logTableRepository.findAllByStatus(0);
        if (CollectionUtils.isEmpty(logTables)) {
            return;
        }
        executeJob(logTables);

    }

    @Override
    public void executeJob(List<LogTable> logTableList) {

        final int totalSize = logTableList.size();
        final int batchSize = (totalSize + 4) / 5;
        final int requiredPoolSize = 5;
        final CountDownLatch latch = new CountDownLatch(requiredPoolSize);

        log.trace("Transaction Sync .executeScheduler #Pool size: " + (requiredPoolSize));

        final ExecutorService executorService = Executors.newFixedThreadPool(requiredPoolSize);

        try {
            executorService.execute(() -> {
                try {
                    log.info("execute");
                    for (int i = 0; i < totalSize; i += batchSize) {
                        int toIndex = Math.min(i + batchSize, totalSize);
                        List<LogTable> segment = logTableList.subList(i, toIndex);
                        log.info("segmentSize Calculate "+ segment.size());
                        addCompanyDeptEmployee(segment);
                    }

                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                } finally {
                    log.info("segmentSize in finally block");
                    latch.countDown();
                }
            });

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            executorService.shutdown();
        }
    }


}
