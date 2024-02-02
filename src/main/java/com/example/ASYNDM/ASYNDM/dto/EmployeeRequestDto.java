package com.example.ASYNDM.ASYNDM.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeRequestDto {
    private String employeeIdentifier;
    private String employeeName;
    private String employeeContact;
    private String employeeEmail;

}
