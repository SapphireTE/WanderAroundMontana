package com.te.service;

import com.te.config.AppConfig;
import com.te.domain.Authority;
import com.te.domain.User;
import com.te.repository.AuthorityRepository;
import com.te.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class}) //in web.wml
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Test
    @Transactional
    public void findByUsernameTest(){
        User expectedResult=new User();
        expectedResult.setUsername("te");
        expectedResult.setEmail("te@gmail.com");
        expectedResult.setPassword("123456");
        userRepository.save(expectedResult);
        User actualResult=userService.findByUsernameIgnoreCase(expectedResult.getUsername());
        assertNotNull(actualResult);
        assertEquals(expectedResult.getId(), actualResult.getId());
    }

    @Test
    @Transactional
    public void findByUserIdTest(){
        User expectedUser=new User();
        expectedUser.setUsername("te");
        expectedUser.setEmail("te@yahoo.com");
        expectedUser.setPassword("123456");
        userRepository.save(expectedUser);
        User actualUser=userService.findById(expectedUser.getId());
        assertNotNull(actualUser);
        assertEquals(expectedUser.getId(),actualUser.getId());
    }

    @Test
    @Transactional
    public void findByFirstNameTest(){
        User expectedUser=new User();
        expectedUser.setFirstName("te");
        expectedUser.setUsername("tsai.te");
        expectedUser.setEmail("tsai.te@gmail.com");
        expectedUser.setPassword("123456");
        userRepository.save(expectedUser);
        List<User> actualUser=userService.findByFirstNameIgnoreCase(expectedUser.getFirstName());
        assertEquals(1,actualUser.size());

        User expectedUser2=new User();
        expectedUser2.setFirstName("te2");
        expectedUser2.setUsername("tsai.te2");
        expectedUser2.setEmail("tsai.te2@gmail.com");
        expectedUser2.setPassword("123456");
        userRepository.save(expectedUser2);
        List<User> actualUser2=userService.findByFirstNameIgnoreCase(expectedUser.getFirstName());
        assertEquals(1,actualUser2.size());

        User expectedUser3=new User();
        expectedUser3.setFirstName("te3");
        expectedUser3.setUsername("tsai.te3");
        expectedUser3.setEmail("tsai.te3@3gmail.com");
        expectedUser3.setPassword("123456");
        userRepository.save(expectedUser3);
        List<User> actualUser3=userService.findAll();
        assertEquals(3,actualUser3.size());
    }


    @Test
    @Transactional
    public void findByLastNameTest(){
        User expectedUser=new User();
        expectedUser.setLastName("tsai");
        expectedUser.setUsername("tsai.te");
        expectedUser.setEmail("tsai.te@yahoo.com");
        expectedUser.setPassword("123456");
        userRepository.save(expectedUser);
        List<User> actualUser=userService.findByLastName(expectedUser.getLastName());
        assertEquals(1,actualUser.size());

        User expectedUser2 =new User();
        expectedUser2.setLastName("tsai2");
        expectedUser2.setUsername("tsai.te2");
        expectedUser2.setEmail("tsai.te2@gmail.com");
        expectedUser2.setPassword("123456");
        userRepository.save(expectedUser2);
        List<User> actualUser2=userService.findByLastName(expectedUser2.getLastName());
        assertEquals(1,actualUser2.size());

        List<User> actualUser3 =userService.findAll();
        assertEquals(2,actualUser3.size());
    }

    @Test
    @Transactional
    public void createUserTest(){
        //1. constructor a user object x
        //invoke createUser() x
        //new user created with primary key ID x
        //retrieve user instance/object from database user x
        //compare one of the unique attribute e.g username x
        // user object in step 1 should has original password,
        // which is not encoded. user object retrieved from database should be encoded. and they are not equal.


        User newUser=new User();
        String password = "123456"; //?
//        Authority authority=new Authority();
        newUser.setUsername("tete");
        newUser.setEmail("tete@hotmail.com");
        newUser.setPassword(password);
        User expectedUser=userService.createUser(newUser);
        User actualUser=userService.findById(newUser.getId());
//        authority.setAuthority("REGISTERED_USER_ROLE");
        List<Authority> actualAuthorities=authorityRepository.findAuthoritiesByUser(expectedUser);

        assertEquals(newUser.getUsername(), actualUser.getUsername());
        assertEquals(newUser.getEmail(),actualUser.getEmail());
        assertNotEquals(password,actualUser.getPassword());
        assertEquals(1,actualAuthorities.size());
        Authority actualAuthority = actualAuthorities.get(0);
        assertEquals("REGISTERED_USER_ROLE",actualAuthority.getAuthority());
        assertEquals(actualUser.getId(),actualAuthority.getUser().getId());

//        assertEquals(expectedUser.getAuthorities(),actualUser.getAuthorities());
    }


}
