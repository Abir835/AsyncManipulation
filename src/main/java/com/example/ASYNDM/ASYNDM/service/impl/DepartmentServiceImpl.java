package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.DepartmentResponseDto;
import com.example.ASYNDM.ASYNDM.entity.Department;
import com.example.ASYNDM.ASYNDM.mapper.DepartmentMapper;
import com.example.ASYNDM.ASYNDM.repository.DepartmentRepository;
import com.example.ASYNDM.ASYNDM.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentResponseDto> findAll() {
        List<Department> departmentList = repository.findAll();

        return departmentList.stream()
                .map(departmentMapper::entityDto)
                .collect(Collectors.toList());
    }
}
