package com.te.service;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.repository.AuthorityRepository;
import com.te.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public User findByUsernameIgnoreCase(String username){
        User result=userRepository.findByUsernameIgnoreCase(username);
        return result;
    }

//    public User findById(Long Id){
//        Optional<User> result=userRepository.findById(Id);
//        User user = result.get();
//        return user;
//    }

    public User findById(Long Id){
        return userRepository.findById(Id).get();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User newUser){
//        Authority addAuthority=new Authority();
        String encodedPass=encoder.encode(newUser.getPassword()); //????
        newUser.setPassword(encodedPass);
        User result=userRepository.save(newUser);
        authorityService.addAuthority("ROLE_REGISTERED_USER",result);
        return result;
    }

//    public User addUser(){
//        User user=new User();
//        user.setUser(user);
//        return userRepository.save(user);
//    }



    public List<User> findByFirstNameIgnoreCase(String firstName){
        List<User> result=userRepository.findByFirstNameIgnoreCase(firstName);
//        List<User> user=result.get();
        return result;
    }

    public List<User> findByLastName (String lastName){
        List<User> result=userRepository.findByLastName(lastName);
        return result;
    }

//    public User setDateOfBirth (LocalDate dateOfBirth){
//        User result=userRepository.setDateOfBirth(dateOfBirth);
//        return result;
//    }

//    public User findByUsername(String name){
//        User result=userRepository.findByUsername(name);
//    }







//    public User SaveUsername (User user){
//        User result=userRepository.
//    }
}






