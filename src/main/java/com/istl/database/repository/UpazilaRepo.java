package com.istl.database.repository;

import com.istl.database.entity.Upazila;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpazilaRepo extends JpaRepository<Upazila, Integer> {
  List<Upazila> findByDistrictId(Integer paramInteger);
  
  List<Upazila> findByDivisionIdAndDistrictId(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\UpazilaRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */