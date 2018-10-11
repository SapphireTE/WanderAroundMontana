package com.te.service;

import com.te.domain.OutdoorRecreation;
import com.te.repository.OutdoorRecreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutdoorRecreationService {
    @Autowired
    private OutdoorRecreationRepository outdoorRecreationRepository;

    public OutdoorRecreation findByCategory(String name){
        OutdoorRecreation result=outdoorRecreationRepository.findByCategoryIgnoreCase(name);
        return result;
    }
}
