
package com.example.ASYNDM.ASYNDM.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeResponseDto {
    private Long id;
    private String employeeName;
    private String employeeContact;
    private String employeeEmail;

}
