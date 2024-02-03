package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.EmployeeResponseDto;
import com.example.ASYNDM.ASYNDM.entity.Employee;
import com.example.ASYNDM.ASYNDM.mapper.EmployeeMapper;
import com.example.ASYNDM.ASYNDM.repository.EmployeeRepository;
import com.example.ASYNDM.ASYNDM.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponseDto> findAll() {

        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList
                .stream()
                .map(employeeMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
