package com.example.ASYNDM.ASYNDM.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentRequestDto {
    private String departmentIdentifier;
    private String departmentName;
    private String departmentPrefix;
}
