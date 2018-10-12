package com.te.service;

import com.te.domain.User;
import com.te.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String name){
        User result=userRepository.findByUsernameIgnoreCase(name);
        return result;
    }

    public User save(User user){
        User result =  userRepository.save(user);
        return result;
    }

//    public User delete(User user){
//        User result = userRepository.delete(user);
//        return result;
//    }
}






