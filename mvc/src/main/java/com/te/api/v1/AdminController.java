package com.te.api.v1;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.extend.security.JwtTokenUtil;
import com.te.repository.AuthorityRepository;
import com.te.service.AuthorityService;
import com.te.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //???
@RequestMapping(value={"/api/admin"}) //???????
public class AdminController {
    private final Logger logger = LoggerFactory.getLogger(getClass()); //???

    @Autowired
    private UserService userService; //??

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AuthorityRepository authorityRepository;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/users/{Id}", method= RequestMethod.GET)
    public User elevateAdminRole (@PathVariable("Id") Long Id){ //???
        logger.debug("user path variable is:"+Id); //??
        User result=userService.findById(Id);
        //TODO create admin authority object
        //setUser to selected user
        //save authority
        Authority authority=new Authority();
        authority.setAuthority("ADMIN");
        authority.setUser(result);
        authorityRepository.save(authority);
        return result;
    }

    //todo de-elevate role
    @RequestMapping(value="/users/demote/{Id}", method=RequestMethod.GET)
    public User demoteAdminRole (@PathVariable("Id") Long Id){
        logger.debug("User path variable is:"+Id);
        User result=userService.findById(Id);
        Authority authority=new Authority();
        authority.setAuthority("ROLE_REGISTERED_USER");
        authority.setUser(result);
        authorityRepository.save(authority);
        return result;
    }

}
