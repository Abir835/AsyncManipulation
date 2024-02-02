package com.example.ASYNDM.ASYNDM.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "DEPARTMENT_PREFIX")
    private String departmentPrefix;

    @Column(name = "DEPARTMENT_IDENTIFIER")
    private String departmentIdentifier;

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "DEPARTMENT_IDENTIFIER",
            referencedColumnName = "DEPARTMENT_IDENTIFIER"
    )
    List<Employee> employeeList;


}
