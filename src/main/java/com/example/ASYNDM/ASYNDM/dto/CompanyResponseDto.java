package com.example.ASYNDM.ASYNDM.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyResponseDto {

    private Long id;
    private String companyName;
    private String companyContact;
    private String companyEmail;

}
