package com.te.api.v1;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/authorities")
public class AuthorityController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthorityService authorityService;

//    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
//    public Authority findByAuthority(@PathVariable("Authority") String Authority) {
//        logger.debug("parameter name is:" +Authority);
//        Authority result = authorityService.findByAuthority(Authority);
//        return result;
//    }
}
