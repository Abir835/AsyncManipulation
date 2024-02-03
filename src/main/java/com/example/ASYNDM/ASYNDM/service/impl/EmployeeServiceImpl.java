package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.EmployeeResponseDto;
import com.example.ASYNDM.ASYNDM.entity.Employee;
import com.example.ASYNDM.ASYNDM.repository.EmployeeRepository;
import com.example.ASYNDM.ASYNDM.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeResponseDto> findAll() {

        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();

        for(Employee employee: employeeList){
            EmployeeResponseDto dto = new EmployeeResponseDto();
            dto.setId(employee.getId());
            dto.setEmployeeName(employee.getEmployeeName());
            dto.setEmployeeContact(employee.getEmployeeContact());
            dto.setEmployeeEmail(employee.getEmployeeEmail());
            employeeResponseDtoList.add(dto);
        }

        return employeeResponseDtoList;
    }
}
