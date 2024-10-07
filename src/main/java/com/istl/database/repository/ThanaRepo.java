package com.istl.database.repository;

import com.istl.database.entity.Thana;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThanaRepo extends JpaRepository<Thana, Integer> {
  List<Thana> findByDivisionIdAndDistrictId(Integer paramInteger1, Integer paramInteger2);
  
  List<Thana> findByDivisionId(Integer paramInteger);
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\ThanaRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */