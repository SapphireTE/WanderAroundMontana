package com.te.service;

import com.te.domain.CulturalInheritance;
import com.te.domain.User;
import com.te.repository.CulturalInheritanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CulturalInheritanceService {
    @Autowired
    private CulturalInheritanceRepository culturalInheritanceRepository;

    public CulturalInheritance findByCategory(String name){
        CulturalInheritance result=culturalInheritanceRepository.findByCategoryIgnoreCase(name);
        return result;
    }

    public CulturalInheritance findById(Long Id){
        Optional<CulturalInheritance> result=culturalInheritanceRepository.findById(Id);
        CulturalInheritance culturalInheritance = result.get();
        return culturalInheritance;
    }

    public CulturalInheritance createCulturalInheritance(CulturalInheritance culturalInheritance){
        CulturalInheritance result=culturalInheritanceRepository.save(culturalInheritance);
        return result;
    }
}
