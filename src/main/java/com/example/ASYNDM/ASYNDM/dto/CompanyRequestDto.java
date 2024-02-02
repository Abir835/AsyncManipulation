package com.example.ASYNDM.ASYNDM.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyRequestDto {
    private String companyIdentifier;
    private String companyEmail;
    private String companyName;
    private String companyContact;
}
