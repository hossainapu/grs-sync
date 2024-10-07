package com.istl.database.repository;

import com.istl.database.entity.OfficeMinistry;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeMinistryRepo extends JpaRepository<OfficeMinistry, Integer> {
  List<OfficeMinistry> findByOfficeType(Integer paramInteger);
  
  @Query(value = "SELECT id FROM office_ministries ", nativeQuery = true)
  List<Long> getAllOfficeMinistryId();
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\OfficeMinistryRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */