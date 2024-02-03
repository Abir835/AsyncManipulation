package com.example.ASYNDM.ASYNDM.mapper;

import com.example.ASYNDM.ASYNDM.dto.EmployeeResponseDto;
import com.example.ASYNDM.ASYNDM.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeResponseDto entityToDto(Employee employee);
}
