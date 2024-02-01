package com.example.ASYNDM.ASYNDM.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    private  String name;
    private  String email;
    private  String contact;
    private  String password;
}
