package com.te.service;

import com.te.domain.User;
import com.te.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsernameIgnoreCase(String name){
        User result=userRepository.findByUsernameIgnoreCase(name);
        return result;
    }

    public User findById(Long Id){
        Optional<User> result=userRepository.findById(Id);
        User user = result.get();
        return user;
    }

    public User createUser(User user){
        User result=userRepository.save(user);
        return result;
    }

    public User findByFirstNameIgnoreCase(String FirstName){
        Optional<User> result=userRepository.findByFirstNameIgnoreCase(FirstName);
        User user=result.get();
        return user;
    }







//    public User SaveUsername (User user){
//        User result=userRepository.
//    }
}






