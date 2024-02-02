package com.example.ASYNDM.ASYNDM.repository;

import com.example.ASYNDM.ASYNDM.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}