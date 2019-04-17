package com.te.service;

import com.te.domain.User;
import com.te.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public User findByEmail (String email){
//        Optional<User> result=userRepository.findByEmailIgnoreCase(email);
        User result=userRepository.findByEmailIgnoreCase(email);
//        User user=result.get();
        return result;
    }

    public List<User> findByFirstNameIgnoreCase(String firstName){
        List<User> result=userRepository.findByFirstNameIgnoreCase(firstName);
//        List<User> user=result.get();
        return result;
    }

    public List<User> findByLastName (String lastName){
        List<User> result=userRepository.findByLastName(lastName);
        return result;
    }

    public List<User> desUsername (List<User> unsorted){
        Collections.sort(unsorted);
        return unsorted;
    }

    public static void main (String[] args){

        List<User> username=new ArrayList<User>();

        Collections.sort(username);

        for (User user : username){
            System.out.println("Username descending order is:" +user.getUsername());
        }

    }

    //todo find emailorusername method
    //check if arguemnt is null--variable has not been initialized yet, no memory address yet
    //check if argument is empty string--"", is empty, there is a memory address assginning the variable
    //find by username
    //if null
    //find by email
    //if null
    //return null
//    public User findUserByUsernameOrEmail (String username, String email){
//        User result = null;
//
//    }

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






