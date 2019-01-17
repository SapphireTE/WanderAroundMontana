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

import java.util.List;

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
        expectedResult.setCategory("nature");
        sceneryRepository.save(expectedResult);
        List<Scenery> actualResult=sceneryService.findByCategory(expectedResult.getCategory());
        assertEquals(1, actualResult.size());

        Scenery expectedResult2=new Scenery();
        expectedResult2.setCategory("national_park");
        sceneryRepository.save(expectedResult2);
        List<Scenery> actualResult2=sceneryService.findByCategory(expectedResult2.getCategory());
        assertEquals(1,actualResult2.size());

        List<Scenery> actualResult3=sceneryService.findAll();
        assertEquals(2,actualResult3.size());
    }

    @Test
    @Transactional
    public void findByIdTest(){
        Scenery expectedResult=new Scenery();
        expectedResult.setCategory("mountain");
        sceneryRepository.save(expectedResult);
        Scenery actualResult=sceneryService.findById(expectedResult.getId());
        assertEquals(expectedResult.getId(),actualResult.getId());
    }
}
