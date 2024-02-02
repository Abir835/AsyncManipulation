package com.example.ASYNDM.ASYNDM.repository;

import com.example.ASYNDM.ASYNDM.entity.Company;
import com.example.ASYNDM.ASYNDM.entity.LogTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogTableRepository extends JpaRepository<LogTable, Long>{
    List<LogTable> findAllByStatus(int i);

}