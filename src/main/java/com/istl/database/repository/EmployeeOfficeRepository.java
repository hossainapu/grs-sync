package com.istl.database.repository;

import com.istl.database.entity.EmployeeOffice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeOfficeRepository extends JpaRepository<EmployeeOffice, Long> {
  @Query(value = "SELECT DISTINCT employee_record_id FROM employee_offices", nativeQuery = true)
  List<Long> getAllEmployeeRecordIds();
  
  @Query(value = "SELECT id FROM employee_offices where status=1", nativeQuery = true)
  List<Long> getAllEmployeeOfficeIds();
  
  @Modifying
  @Transactional
  @Query(value = "update employee_offices u set u.status = false where 1=1", nativeQuery = true)
  void updateEmployeeOfficeStatusToFalse();
  
  @Modifying
  @Transactional
  @Query("update EmployeeOffice u set u.status =:status where 1=1")
  void updateEmployeeOfficeStatusToFalse(@Param("status") Boolean paramBoolean);
  
  List<EmployeeOffice> findAllByIdIn(List<Long> paramList);
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\EmployeeOfficeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */