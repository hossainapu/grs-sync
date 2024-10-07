package com.istl.database.repository;

import com.istl.database.entity.Office;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OfficeRepo extends JpaRepository<Office, Long> {
  @Query(value = "SELECT id FROM offices ", nativeQuery = true)
  List<Long> getAllOfficeID();
  
  @Modifying
  @Transactional
  @Query(value = "update offices u set u.status = 0 where 1=1", nativeQuery = true)
  void updateOfficeStatusToFalse();
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\OfficeRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */