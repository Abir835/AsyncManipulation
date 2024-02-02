package com.example.ASYNDM.ASYNDM.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "EMPLOYEE_CONTACT")
    private String employeeContact;

    @Column(name = "EMPLOYEE_EMAIL")
    private String employeeEmail;

    @Column(name = "EMPLOYEE_IDENTIFIER")
    private String employeeIdentifier;

}
