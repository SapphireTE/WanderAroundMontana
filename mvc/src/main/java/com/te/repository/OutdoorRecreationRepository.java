package com.te.repository;

import com.te.domain.OutdoorRecreation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutdoorRecreationRepository extends CrudRepository <OutdoorRecreation, Long> {
    List<OutdoorRecreation> findByCategoryIgnoreCase(String category);
//    OutdoorRecreation findBySkiing(String ski);
//    OutdoorRecreation findByHiking(String hiking);
//    OutdoorRecreation findByFishing(String fishing);
//    OutdoorRecreation findByDistance (Double distance);
}
