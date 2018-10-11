package com.te.service;

import com.te.domain.Scenery;
import com.te.repository.SceneryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SceneryService {
    @Autowired
    private SceneryRepository sceneryRepository;

    public Scenery findByCategory(String name){
        Scenery result= sceneryRepository.findByCategoryIgnoreCase(name);
        return result;
    }
}
