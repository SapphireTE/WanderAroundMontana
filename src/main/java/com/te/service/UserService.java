package com.te.service;

import com.te.domain.User;
import com.te.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public User findByUsernameIgnoreCase(String name){
        User result=userRepository.findByUsernameIgnoreCase(name);
        return result;
    }

    public User findById(Long Id){
        Optional<User> result=userRepository.findById(Id);
        User user = result.get();
        return user;
    }

    @Transactional
    public User createUser(User newUser){
        String encodedPass=encoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPass);
        User result=userRepository.save(newUser);
        return result;
    }

//    public User addUser(){
//        User user=new User();
//        user.setUser(user);
//        return userRepository.save(user);
//    }



    public User findByFirstNameIgnoreCase(String FirstName){
        Optional<User> result=userRepository.findByFirstNameIgnoreCase(FirstName);
        User user=result.get();
        return user;
    }

//    public User findByUsername(String name){
//        User result=userRepository.findByUsername(name);
//    }







//    public User SaveUsername (User user){
//        User result=userRepository.
//    }
}






