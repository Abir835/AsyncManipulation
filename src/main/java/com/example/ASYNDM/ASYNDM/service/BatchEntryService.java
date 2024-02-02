package com.example.ASYNDM.ASYNDM.service;

import com.example.ASYNDM.ASYNDM.entity.LogTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface BatchEntryService {

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = Exception.class)
    void addCompanyDeptEmployee(List<LogTable> logTableList) throws JsonProcessingException;

    void runScheduler();

    void executeJob(List<LogTable> logTableList);
}
