package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.User;
import com.te.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findByUsernameTest(){
        User expectedResult=new User();
        expectedResult.setUsername("te");
        expectedResult.setEmail("te@gmail.com");
        expectedResult.setPassword("123456");
        userRepository.save(expectedResult);
        User actualResult=userService.findByUsername(expectedResult.getUsername());
        assertEquals(expectedResult.getId(), actualResult.getId());
    }


}
