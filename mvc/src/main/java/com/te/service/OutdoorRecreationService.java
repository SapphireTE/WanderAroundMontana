package com.te.service;

import com.te.domain.OutdoorRecreation;
import com.te.domain.User;
import com.te.repository.OutdoorRecreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutdoorRecreationService {
    @Autowired
    private OutdoorRecreationRepository outdoorRecreationRepository;

    public List<OutdoorRecreation> findByCategory(String category){
        List<OutdoorRecreation> result=outdoorRecreationRepository.findByCategoryIgnoreCase(category);
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

//    public OutdoorRecreation findByHiking (String hiking){
//        OutdoorRecreation result=outdoorRecreationRepository.findByHiking(hiking);
//        return result;
//    }
//
//    public OutdoorRecreation findByFishing (String fishing){
//        OutdoorRecreation result=outdoorRecreationRepository.findByFishing(fishing);
//        return result;
//    }
//
//    public OutdoorRecreation findBySkiing (String skiing){
//        OutdoorRecreation result=outdoorRecreationRepository.findBySkiing(skiing);
//        return result;
//    }
//
//    public OutdoorRecreation findByDistance (Double distance){
//        OutdoorRecreation result=outdoorRecreationRepository.findByDistance(distance);
//        return result;
//    }
}
