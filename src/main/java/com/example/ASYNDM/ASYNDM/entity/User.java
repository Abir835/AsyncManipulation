package com.example.ASYNDM.ASYNDM.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String contact;
    private String password;
    private String role;
}
