package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.DepartmentResponseDto;
import com.example.ASYNDM.ASYNDM.entity.Department;
import com.example.ASYNDM.ASYNDM.repository.DepartmentRepository;
import com.example.ASYNDM.ASYNDM.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    @Override
    public List<DepartmentResponseDto> findAll() {
        List<Department> departmentList = repository.findAll();
        List<DepartmentResponseDto> departmentResponseDto = new ArrayList<>();
        for(Department department: departmentList){

            DepartmentResponseDto dto = new DepartmentResponseDto();
            dto.setId(department.getId());
            dto.setDepartmentName(department.getDepartmentName());
            dto.setDepartmentPrefix(department.getDepartmentPrefix());
            departmentResponseDto.add(dto);
        }

        return departmentResponseDto;
    }
}
