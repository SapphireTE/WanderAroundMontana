package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.Image;
import com.te.repository.ImageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class ImageServiceTest {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageRepository imageRepository;

    @Test
    @Transactional
    public void findByIdTest(){
        Image expectedImage=new Image();
        expectedImage.setImageName("national_park1");
        imageRepository.save(expectedImage);
        Image actualImage=imageService.findById(expectedImage.getId());
        assertNotNull(actualImage);
        assertEquals(expectedImage.getId(),actualImage.getId());
    }

    @Test
    @Transactional
    public void findByImageNameTest(){
        Image expectedImage=new Image();
        expectedImage.setImageName("national_park2");
        imageRepository.save(expectedImage);
        Image actualImage=imageService.findByImageName(expectedImage.getImageName());
        assertNotNull(actualImage);
        assertEquals(expectedImage.getImageName(),actualImage.getImageName());
    }
}
