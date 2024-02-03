package com.example.ASYNDM.ASYNDM.mapper;

import com.example.ASYNDM.ASYNDM.dto.CompanyResponseDto;
import com.example.ASYNDM.ASYNDM.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyResponseDto entityToDto(Company company);
}
