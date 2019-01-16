package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.CulturalInheritance;
import com.te.domain.Scenery;
import com.te.repository.CulturalInheritanceRepository;
import com.te.repository.SceneryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes={AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class CulturalInheritanceServiceTest {
    @Autowired
    private CulturalInheritanceRepository culturalInheritanceRepository;

    @Autowired
    private CulturalInheritanceService culturalInheritanceService;

    @Test
    @Transactional
    public void findByCategoryTest(){
        CulturalInheritance expectedResult=new CulturalInheritance();
        expectedResult.setCategory("Museum");
//        expectedResult.setMuseum("hiking");
//        expectedResult.setHistoricalScene("m");
        culturalInheritanceRepository.save(expectedResult);
        List<CulturalInheritance> actualResult=culturalInheritanceService.findByCategory(expectedResult.getCategory());
        assertEquals(1, actualResult.size());
    }
}
