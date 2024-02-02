package com.example.ASYNDM.ASYNDM.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
public class LogTableDto {

    private String company;
    private String department;
    private String employee;

}
