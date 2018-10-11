package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.Scenery;
import com.te.repository.SceneryRepository;
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
public class SceneryServiceTest {
    @Autowired
    private SceneryRepository sceneryRepository;

    @Autowired
    private SceneryService sceneryService;

    @Test
    @Transactional
    public void findByCategoryTest(){
        Scenery expectedResult=new Scenery();
        expectedResult.setCategory("river");
        expectedResult.setNature("hiking");
        expectedResult.setNationalParks("m");
        sceneryRepository.save(expectedResult);
        Scenery actualResult=sceneryService.findByCategory(expectedResult.getCategory());
        assertEquals(expectedResult.getId(), actualResult.getId());
    }
}
