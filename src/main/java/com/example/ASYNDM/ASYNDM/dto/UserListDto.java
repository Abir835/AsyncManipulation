package com.example.ASYNDM.ASYNDM.dto;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Service
@ToString
public class UserListDto {
    private Long id;
    private String name;
    private String contact;
    private String email;
}
