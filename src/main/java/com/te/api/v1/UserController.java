package com.te.api.v1;

import com.te.domain.User;
import com.te.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/users")
public class UserController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public User findById (@PathVariable("Id") Long Id){
        logger.debug("user path variable is:" +Id);
        User result=userService.findById(Id);
        return result;
    }

    @RequestMapping(value = "/signingup", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        User result=userService.createUser(user);
        return result;
    }



}


