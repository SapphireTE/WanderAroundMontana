package com.te.service;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorityService {
    @Autowired
    public AuthorityRepository authorityRepository;

    public Authority addAuthority(String role, User user){
        Authority auth=new Authority();
        auth.setAuthority(role);
        auth.setUser(user);
        return authorityRepository.save(auth);
    }



}
