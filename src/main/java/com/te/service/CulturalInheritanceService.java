package com.te.service;

import com.te.domain.CulturalInheritance;
import com.te.repository.CulturalInheritanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CulturalInheritanceService {
    @Autowired
    private CulturalInheritanceRepository culturalInheritanceRepository;

    public CulturalInheritance findByCategory(String name){
        CulturalInheritance result=culturalInheritanceRepository.findByCategoryIgnoreCase(name);
        return result;
    }

    public CulturalInheritance save(CulturalInheritance culturalInheritance){
        CulturalInheritance result=culturalInheritanceRepository.save(culturalInheritance);
        return result;
    }
}
