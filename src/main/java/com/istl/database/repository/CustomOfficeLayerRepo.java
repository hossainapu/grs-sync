package com.istl.database.repository;

import com.istl.database.entity.CustomOfficeLayer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomOfficeLayerRepo extends JpaRepository<CustomOfficeLayer, Long> {
  List<CustomOfficeLayer> findByLayerLevel(Integer paramInteger);
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\CustomOfficeLayerRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */