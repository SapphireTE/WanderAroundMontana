package com.te.repository;

import com.te.domain.CulturalInheritance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CulturalInheritanceRepository extends CrudRepository<CulturalInheritance, Long> {
    List<CulturalInheritance> findByCategoryIgnoreCase(String category);
//    CulturalInheritance findByMuseum(String museum);
//    CulturalInheritance findByHistoricalScene(String historicalScene);
}
