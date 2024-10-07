package com.istl.database.repository;

import com.istl.database.entity.OfficeOrigin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeOriginRepo extends JpaRepository<OfficeOrigin, Long> {
  List<OfficeOrigin> findByOfficeLayerIdIn(List<Long> paramList);
  
  @Query(value = "SELECT id FROM office_origins ", nativeQuery = true)
  List<Long> getAllOfficeOriginId();
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\OfficeOriginRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */