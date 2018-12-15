//package com.te.service;
//
//import com.te.domain.User;
//import com.te.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Service
//public class AdminService {
//    @Autowired
//    private UserRepository userRepository;
//
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    public User findById(Long Id) {
//        Optional<User> result = userRepository.findById(Id);
//        User user = result.get();
//        return user;
//    }
//
//    public User findByUsernameIgnoreCase(String Username) {
//        User result = userRepository.findByUsernameIgnoreCase(Username);
//        return result;
//    }
//
//    public User findByEmailIgnoreCase(String Email) {
//        Optional<User> result = userRepository.findByEmailIgnoreCase(Email);
//        User user = result.get();
//        return user;
//    }
//}