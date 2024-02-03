package com.example.ASYNDM.ASYNDM.service;

import com.example.ASYNDM.ASYNDM.dto.EmployeeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeResponseDto> findAll();

}
