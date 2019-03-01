package com.te.service;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


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

//    todo need to comment out this method
    public List<Authority> findAuthoritiesByUser(User user, Boolean isDelete){
        List<Authority> authorities=authorityRepository.findAuthoritiesByUserAndIsDelete(user, isDelete);
        return authorities;
    }

    public List<Authority> findAll(){
        return authorityRepository.findAll();
    }

//    @Transactional
//    public Authority deleteAuthority(String role, User user){
//        Authority authority=new Authority();
//        authority.setAuthority(role);
//        authority.setUser(user);
//        return  authorityRepository.save(authority);
//    }


}
