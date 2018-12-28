package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.OutdoorRecreation;
import com.te.repository.OutdoorRecreationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes={AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class OutdoorRecreationServiceTest {
    @Autowired
    private OutdoorRecreationRepository outdoorRecreationRepository;

    @Autowired
    private OutdoorRecreationService outdoorRecreationService;

    @Test
    @Transactional
    public void findByCategoryTest(){
        OutdoorRecreation expectedResult=new OutdoorRecreation();
        expectedResult.setCategory("river");
        expectedResult.setHiking("hiking");
        expectedResult.setFishing("m");
        expectedResult.setSkiing("resorts");
        expectedResult.setDistant(1.11);
        outdoorRecreationRepository.save(expectedResult);
        OutdoorRecreation actualResult=outdoorRecreationService.findByCategory (expectedResult.getCategory());
        assertEquals(expectedResult.getId(), actualResult.getId());
    }
}
