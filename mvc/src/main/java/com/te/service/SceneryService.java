package com.te.service;

import com.te.domain.Scenery;
import com.te.domain.User;
import com.te.repository.SceneryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SceneryService {
    @Autowired
    private SceneryRepository sceneryRepository;

    public List<Scenery> findByCategory(String category){
        List<Scenery> result= sceneryRepository.findByCategoryIgnoreCase(category);
        return result;
    }

    public Scenery findById(Long Id){
        Optional<Scenery> result=sceneryRepository.findById(Id);
        Scenery scenery = result.get();
        return scenery;
    }

//    public Scenery createScenery(Scenery scenery){
//        Scenery result=sceneryRepository.save(scenery);
//        return result;
//    }

//    public List<Scenery> findByNature(String nature){
//        List<Scenery> result=sceneryRepository.findByNature(nature);
////        Scenery nature = result.get();
//        return result;
//    }

//    public Scenery findById (Long Id){
//        Scenery result=sceneryRepository.findById(Id);
//        return result;
//    }

//    public List<Scenery> findByNationalParks(String nationalParks){
//        List<Scenery> result=sceneryRepository.findByNationalParks(nationalParks);
//        return result;
//    }
}
