package com.example.ASYNDM.ASYNDM.mapper;

import com.example.ASYNDM.ASYNDM.dto.DepartmentResponseDto;
import com.example.ASYNDM.ASYNDM.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentResponseDto entityDto(Department department);
}
