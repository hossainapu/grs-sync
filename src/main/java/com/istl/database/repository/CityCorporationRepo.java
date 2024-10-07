package com.istl.database.repository;

import com.istl.database.entity.CityCorporation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityCorporationRepo extends JpaRepository<CityCorporation, Integer> {
  List<CityCorporation> findByDivisionIdAndDistrictId(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\CityCorporationRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */