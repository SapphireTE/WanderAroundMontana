package com.te.api.v1;

import com.te.domain.User;
import com.te.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/users")
public class UserController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenicationManager;

    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public User findById (@PathVariable("Id") Long Id){
        logger.debug("user path variable is:" +Id);
        User result=userService.findById(Id);
        return result;
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public User createUser(@RequestBody User user){
//        User result=userService.createUser(user);
//        return result;
//    }

    @RequestMapping(value="", method = RequestMethod.GET,params={"username"})
    public User findByUsername(@RequestParam("username") String Username){
        logger.debug("parameter name is:" +Username);
        User result=userService.findByUsernameIgnoreCase(Username);//return userService.findBy(new Car(carId)).get();
        return result;
    }


    @RequestMapping(value="", method=RequestMethod.GET, params={"first_name"})
    public User findByFirstName(@RequestParam("first_name") String FirstName){
        logger.debug("parameter name is:" +FirstName);
        User result =userService.findByFirstNameIgnoreCase(FirstName);
        return result;
    }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public User signup(@RequestBody User user){
        User result=userService.createUser(user);
        return result;
    }

    @RequestMapping(value="/login",method = RequestMethod.POST, params={"username", "password"})
    public void findByLoggingUser(@RequestParam(value="username")String username, @RequestParam(value="password") String password, Device device) {
        logger.debug("parameter name is:" + username);
        logger.debug("parameter name is:" + password);


        try {
            Authentication notFullyAuthentication = new UsernamePasswordAuthenticationToken(username, password);
            final Authentication authentication = authenicationManager.authenticate(notFullyAuthentication);

        } catch (AuthenticationException ex) {
            logger.info("failed message", ex);
        }

    }
}


