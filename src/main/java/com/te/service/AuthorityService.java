package com.te.service;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class AuthorityService {
    @Autowired
    public AuthorityRepository authorityRepository;

    @Transactional
    public Authority addAuthority(String role, User user){
        Authority authority=new Authority();
        authority.setAuthority(role);
        authority.setUser(user);
        return authorityRepository.save(authority);
    }

    //TODO findAuthoriesByUser

    public Authority findAuthorityByUser(String authority){
        Authority result=authorityRepository.findAuthorityByUser(authority);
        return result;
    }


}
