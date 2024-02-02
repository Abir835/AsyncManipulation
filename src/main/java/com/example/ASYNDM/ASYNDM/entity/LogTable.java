package com.example.ASYNDM.ASYNDM.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "LOG_TABLE")
public class LogTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "COMPANY", columnDefinition = "TEXT")
    private String company;
    @Column(name = "DEPARTMENT", columnDefinition = "TEXT")
    private String department;
    @Column(name = "EMPLOYEE", columnDefinition = "TEXT")
    private String employee;

//    @Column(name = "PROCESSING_STATUS", columnDefinition = "BOOLEAN DEFAULT false")
//    private Boolean processingStatus = Boolean.FALSE;
    @Column(name = "status", nullable = true)
    private Integer status;

}
