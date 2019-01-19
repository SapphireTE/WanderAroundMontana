package com.te.extend.security;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.repository.AuthorityRepository;
import com.te.repository.UserRepository;
import com.te.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSourceAware;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    private static final Logger logger= LoggerFactory.getLogger(UserDetailsServiceImpl.class);

//    @Autowired
//    private User user;


//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username){
//        User result=userService.findByUsernameIgnoreCase(username);
//        List<Authority> authority=authorityRepository.findAuthoritiesByUser(result);
//        result.setAuthorities(authority);
//        return result;
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername (String username) {
        User domainUser=null;
        try {
            domainUser=userService.findByUsernameIgnoreCase(username);
            List<Authority> authority=authorityRepository.findAuthoritiesByUser(domainUser);
            domainUser.setAuthorities(authority);
        } catch (Exception repositoryProblem) {
            logger.debug("catch AuthenticationServiceException from AuthenticationProvider");
        }
        return domainUser;
    }






}
