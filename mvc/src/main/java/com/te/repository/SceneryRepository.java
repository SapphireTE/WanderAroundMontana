package com.te.repository;

import com.te.domain.Scenery;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SceneryRepository extends CrudRepository <Scenery, Long> {
    List<Scenery> findByCategoryIgnoreCase (String category);
//    List<Scenery> findByNature (String nature);
//    List<Scenery> findByNationalParks (String nationalParks);
}
