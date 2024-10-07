package com.istl.database.repository;

import com.istl.database.entity.EmployeeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRecordRepository extends JpaRepository<EmployeeRecord, Long> {}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\EmployeeRecordRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */