package com.te.api.v1;

import com.te.domain.JsView;
import com.te.domain.User;
import com.te.extend.security.JwtTokenUtil;
import com.te.extend.security.RestAuthenticationRequest;
import com.te.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
//@Controller
//@RequestBody
@RequestMapping(value={"/api/users","/api/user"}) //only comes to users, 请求的 mapping
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass()); //getClass() is present class name, which is UserController

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager; //check SecurityConfig line 120

//    @Autowired
//    private User user;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList(){
        logger.debug("list users");
        return new ArrayList<User>();
    }

    @RequestMapping(value = "/{Id}/user/{/userId}",method = RequestMethod.GET)
    public User findByUserId(@PathVariable("Id") Long Id, @PathVariable("userId") Long userId){
        logger.debug("user path variable is:"+Id);
        logger.debug("user path variable is:"+userId);
        return userService.findById(userId);
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public User findById(@PathVariable("Id") Long Id) {
        logger.debug("user path variable is:" + Id);
        User result = userService.findById(Id);
        return result;

//        try{
//            Authentication notFullyAuthentication=new IdAuthenticationToken(Id);
//            final Authentication authentication=authenticationManager.authenticate(notFullyAuthentication);
//        }catch (AuthenticationException ex){
//            logger.info("invalid Id", ex);
//        }
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public User createUser(@RequestBody User user){
//        User result=userService.createUser(user);
//        return result;
//    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"username"})
    public User findByUsername(@RequestParam(value = "username") String username, Device device) {
        setJsonViewClass(JsView.User.class); //what situation or role
        disableMapperFeature_DEFAULT_VIEW_INCLUSION();
        logger.debug("parameter name is:" +username);
        User result = userService.findByUsernameIgnoreCase(username);//return userService.findBy(new Car(carId)).get();
        return result;

//        try{
//            Authentication notFullyAuthentication = new UsernameAuthenticationToken(username);
//            final Authentication authentication = authenticationManager.authenticate(notFullyAuthentication);
//        }catch (AuthenticationException ex){
//            logger.info("invalid username", ex);
//        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"firstName"})
    public List<User> findByFirstName(@RequestParam("firstName") String firstName) {
        logger.debug("parameter name is:" + firstName);
        List<User> result = userService.findByFirstNameIgnoreCase(firstName);
        return result;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signup(@RequestBody User user) {
        User result = userService.createUser(user);
        return result;
    }

    @RequestMapping(value="/signUp", method=RequestMethod.POST)
    public User signUp(@RequestBody User user){
        User result=userService.createUser(user);
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login (@RequestBody RestAuthenticationRequest restAuthenticationRequest, Device device) { //<?> means can be string or map or something else
        String username=restAuthenticationRequest.getUsername();
        String password=restAuthenticationRequest.getPassword();
        logger.debug("parameter name is:" +username);
        logger.debug("parameter name is:" +password);


        try {
            Authentication notFullyAuthentication = new UsernamePasswordAuthenticationToken(username, password);
            final Authentication authentication = authenticationManager.authenticate(notFullyAuthentication);
            UserDetails userDetails = userService.findByUsernameIgnoreCase(username);

            //how to change the token responsebody from string to the following format {"token": "xxx.xxx.xxx"}
            final String token = jwtTokenUtil.generateToken(userDetails, device);
            HashMap<String,String> tokenString=new HashMap<>();
            tokenString.put("Token",token);
            return ResponseEntity.ok(tokenString);

        } catch (AuthenticationException ex) {
            logger.info("failed message", ex);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid username or password");
        }
    }

//    @RequestMapping(value="/login1",method=RequestMethod.POST)
//    public ResponseEntity<?> login1 (@RequestBody RestAuthenticationRequest authenticationRequest, Device device){
//        try {
//            Authentication notFullAuthenticated = new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.getUsername(),
//                    authenticationRequest.getPassword()
//            );
//            final Authentication authentication = authenticationManager.authenticate(notFullAuthenticated);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            try{
//                final UserDetails userDetails=userService.(notFullAuthenticated);
//            }
//        }catch (AuthenticationException ex){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("authentication failure, please check your login info");
//        }
//        return null;
//    }

    @RequestMapping(value="",method = RequestMethod.GET,params = {"lastName"})
    public List<User> findByLastName (@RequestParam("lastName") String lastName){
        logger.debug("parameter name is:"+lastName);
        List<User> result=userService.findByLastName(lastName);
        return result;
        //userService.findBy(new User(Id)).get();
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }


    @RequestMapping(value = "sortUsername",method = RequestMethod.GET,params = {"username"})
    public List<User> desUsername (@RequestParam("username") String username){
//        public int compare(User, User) {
//        logger.debug("parameter name is:"+username);
        List<User> unsort=userService.findAll();
        List<User> sorted = userService.desUsername(unsort);
//        comparetor
        return sorted;
    }

    //todo set time api


//    @RequestMapping(value="",method=RequestMethod.POST,params = {"dataOfBirth"})
//    public User setDateOfBirth (@DateTimeFormat(pattern="MM/DD/YYYY") LocalDate dateOfBirth){
//        logger.debug("parameter name is:"+dateOfBirth);
//        User result=userService.setDateOfBirth(dateOfBirth);
//        return result;
//    }

}

