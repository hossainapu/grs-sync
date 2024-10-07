package com.istl.database.repository;

import com.istl.database.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Integer> {}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\repository\DivisionRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */