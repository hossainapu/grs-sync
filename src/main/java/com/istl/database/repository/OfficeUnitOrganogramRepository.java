package com.istl.database.repository;

import com.istl.database.entity.OfficeUnitOrganogram;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeUnitOrganogramRepository extends JpaRepository<OfficeUnitOrganogram, Long> {
  List<OfficeUnitOrganogram> findAllByOfficeId(Integer paramInteger);
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\OfficeUnitOrganogramRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */