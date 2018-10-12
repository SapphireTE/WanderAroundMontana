package com.te.repository;

import com.te.domain.Scenery;
import org.springframework.data.repository.CrudRepository;

public interface SceneryRepository extends CrudRepository <Scenery, Long> {
    Scenery findByCategoryIgnoreCase (String category);
    Scenery findByNatureIgnoreCase(String nature);
    Scenery findByNationalParksIgnoreCase(String national_park);

}
