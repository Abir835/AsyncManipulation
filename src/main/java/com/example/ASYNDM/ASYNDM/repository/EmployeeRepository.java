package com.example.ASYNDM.ASYNDM.repository;

import com.example.ASYNDM.ASYNDM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}