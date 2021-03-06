package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.Authority;
import com.te.domain.User;
import com.te.repository.AuthorityRepository;
import com.te.repository.UserRepository;
import org.junit.Assert;
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
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class AuthorityServiceTest {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    @Test
    @Transactional
    public void addAuthorityTest(){
        User createUser = new User();
        Boolean isDelete=null;
        Authority authority=new Authority();
        createUser.setUsername("te");
        createUser.setPassword("123456");
        createUser.setEmail("te@gmail.com");
//        Authority expectedAuthority=new Authority();
//        expectedAuthority.setAuthority("registered_user");
//        expectedAuthority.setUser(createUser);
//        authorityRepository.save(expectedAuthority);
        userRepository.save(createUser);
        Authority expectedAuthority1=authorityService.addAuthority("admin",createUser);
        Authority expectedAuthority2=authorityService.addAuthority("registered_user",createUser);
        Authority expectedAuthority3=authorityService.addAuthority("registered_user",createUser);

//      Guest_User role
        Authority expectedAuthority4=authorityService.addAuthority("guest_user",createUser);

        List<Authority> actualAuthority=authorityService.findAuthoritiesByUser(createUser,isDelete);
//        User actualAuthority=authorityService.findAuthoritiesByUser(expectedAuthority.getUser());
        assertEquals(4,actualAuthority.size());
    }

//    @Test
//    @Transactional
//    public void deleteAuthorityTest(){
//        User findByAuthority=new User();
//        Authority deElevateAuthority=new Authority();
//        findByAuthority.getId();
//        userRepository.save(findByAuthority);
//        Authority actualAuthority=authorityRepository.deleteAuthority();
//    }

}
