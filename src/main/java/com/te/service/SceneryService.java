package com.te.service;

import com.te.domain.Scenery;
import com.te.domain.User;
import com.te.repository.SceneryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SceneryService {
    @Autowired
    private SceneryRepository sceneryRepository;

    public Scenery findByCategory(String name){
        Scenery result= sceneryRepository.findByCategoryIgnoreCase(name);
        return result;
    }

    public Scenery findById(Long Id){
        Optional<Scenery> result=sceneryRepository.findById(Id);
        Scenery scenery = result.get();
        return scenery;
    }

//    public Scenery findById (Long Id){
//        Scenery result=sceneryRepository.findById(Id);
//        return result;
//    }
}
