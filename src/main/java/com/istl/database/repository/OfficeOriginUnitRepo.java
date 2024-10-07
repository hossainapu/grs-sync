package com.istl.database.repository;

import com.istl.database.entity.OfficeOriginUnit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeOriginUnitRepo extends JpaRepository<OfficeOriginUnit, Long> {
  List<OfficeOriginUnit> findByOfficeOriginId(Long paramLong);
  
  List<OfficeOriginUnit> findIdByOfficeOriginId(Long paramLong);
  
  @Query(value = "SELECT id FROM office_origin_units ", nativeQuery = true)
  List<Long> getAllOfficeOriginUnitId();
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\OfficeOriginUnitRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */