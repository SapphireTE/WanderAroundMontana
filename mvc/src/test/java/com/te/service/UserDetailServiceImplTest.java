package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.Authority;
import com.te.domain.User;
import com.te.extend.security.UserDetailsServiceImpl;
import com.te.repository.AuthorityRepository;
import com.te.repository.UserRepository;
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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes={AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserDetailServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AuthorityRepository authorityRepository;

//    @Autowired
//    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Test
    @Transactional
    public void loadUserByUsernameTest(){
        User expectedUser=new User();
        Authority expectedAuthority=new Authority();
        expectedUser.setUsername("te");
        expectedUser.setEmail("tsai.te@gmail.com");
        expectedUser.setPassword("123");
        userRepository.save(expectedUser);
        expectedAuthority.setAuthority("registered_user");
        expectedAuthority.setUser(expectedUser);
        authorityRepository.save(expectedAuthority);
        User actualUser=userService.findByUsernameIgnoreCase(expectedUser.getUsername());
        assertEquals(expectedUser.getAuthorities(),actualUser.getAuthorities());
    }
}
