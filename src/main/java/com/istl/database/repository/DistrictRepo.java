package com.istl.database.repository;

import com.istl.database.entity.District;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends JpaRepository<District, Integer> {
  List<District> findByDivisionId(Integer paramInteger);
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\DistrictRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */