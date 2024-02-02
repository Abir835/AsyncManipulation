package com.example.ASYNDM.ASYNDM.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "COMPANY_EMAIL")
    private String companyEmail;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_CONTACT")
    private String companyContact;

    @Column(name = "COMPANY_IDENTIFIER")
    private String companyIdentifier;

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "COMPANY_IDENTIFIER",
            referencedColumnName = "COMPANY_IDENTIFIER"
    )
    List<Department> departmentList;
}
