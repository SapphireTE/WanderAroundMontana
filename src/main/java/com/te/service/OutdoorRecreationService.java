package com.te.service;

import com.te.domain.OutdoorRecreation;
import com.te.domain.User;
import com.te.repository.OutdoorRecreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutdoorRecreationService {
    @Autowired
    private OutdoorRecreationRepository outdoorRecreationRepository;

    public OutdoorRecreation findByCategory(String name){
        OutdoorRecreation result=outdoorRecreationRepository.findByCategoryIgnoreCase(name);
        return result;
    }

    public OutdoorRecreation findById(Long Id){
        Optional<OutdoorRecreation> result=outdoorRecreationRepository.findById(Id);
        OutdoorRecreation outdoorRecreation = result.get();
        return outdoorRecreation;
    }

    public OutdoorRecreation createOutdoorRecreation(OutdoorRecreation outdoorRecreation){
        OutdoorRecreation result=outdoorRecreationRepository.save(outdoorRecreation);
        return result;
    }
}
