package com.example.ASYNDM.ASYNDM.repository;

import com.example.ASYNDM.ASYNDM.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}